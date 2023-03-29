package com.equipment.system.task;

import com.equipment.common.core.domain.entity.SysDictData;
import com.equipment.common.email.bean.MailBean;
import com.equipment.common.email.util.MailUtil;
import com.equipment.system.domain.TEquiment;
import com.equipment.system.domain.TEquipmentWarn;
import com.equipment.system.service.ISysDictDataService;
import com.equipment.system.service.ITEquimentService;
import com.equipment.system.service.ITEquipmentWarnService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @Author: weisong
 * @CreateTime: 2023-02-18  23:01
 * @Description:定时任务警告消息
 * @Version: 1.0
 */
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class EquipmentTask {
    @Autowired
    private ITEquipmentWarnService itEquipmentWarnService;
    @Autowired
    private ITEquimentService itEquimentService;
    @Autowired
    private ISysDictDataService iSysDictDataService;
    @Autowired
    private MailUtil mailUtil;

    private static final Logger logger= LoggerFactory.getLogger(EquipmentTask.class);

    //每小时执行
    @Scheduled(cron ="0 0 * * * ? ")
    public void pushTask(){
        logger.info("告警任务执行");

        //查询所有设备
        List<TEquiment> list=itEquimentService.selectTEquimentList(new TEquiment());
        if (list.size()>0){
            //取随机的设备信息进行告警
            int num = (int)(Math.random()*(list.size()-1));
            TEquiment tEquiment=list.get(num);
            tEquiment.setType("02");
            TEquipmentWarn tEquipmentWarn=new TEquipmentWarn();
            tEquipmentWarn.setEquipmentName(tEquiment.getName());
            tEquipmentWarn.setEquipmentId(tEquiment.getId());
            tEquipmentWarn.setEquipmentPostion(tEquiment.getPosition());
            tEquipmentWarn.setCreateTime(new Date());
            tEquipmentWarn.setCreateBy(tEquiment.getDirector());
            SysDictData sysDictData=new SysDictData();
            sysDictData.setDictType("warn_type");
            List<SysDictData> dictDataList=iSysDictDataService.selectDictDataList(sysDictData);
            //取随机的设备信息进行告警
            int typeNum = (int)(Math.random()*(dictDataList.size()-1));
            sysDictData=dictDataList.get(typeNum);
            tEquipmentWarn.setType(sysDictData.getDictValue());
            tEquipmentWarn.setTypeName(sysDictData.getDictLabel());
            itEquipmentWarnService.insertTEquipmentWarn(tEquipmentWarn);
            MailBean mailBean = new MailBean();
            mailBean.setRecipient(tEquiment.getQqEmail());//接收者
            mailBean.setSubject("设备预警信息");//标题
            //内容主体
            mailBean.setContent("设备预警，设备名称："+tEquiment.getName()+"。设备预警类型："+sysDictData.getDictLabel());

            mailUtil.sendSimpleMail(mailBean);

        }

    }
}
