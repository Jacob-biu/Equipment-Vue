package com.equipment.system.service.impl;

import java.util.List;
import com.equipment.common.utils.DateUtils;
import com.equipment.system.domain.vo.StatisticsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.equipment.system.mapper.TEquipmentWarnMapper;
import com.equipment.system.domain.TEquipmentWarn;
import com.equipment.system.service.ITEquipmentWarnService;

/**
 * 报警信息Service业务层处理
 *
 * @author equipment
 * @date 2023-02-18
 */
@Service
public class TEquipmentWarnServiceImpl implements ITEquipmentWarnService
{
    @Autowired
    private TEquipmentWarnMapper tEquipmentWarnMapper;

    /**
     * 查询报警信息
     *
     * @param id 报警信息主键
     * @return 报警信息
     */
    @Override
    public TEquipmentWarn selectTEquipmentWarnById(Long id)
    {
        return tEquipmentWarnMapper.selectTEquipmentWarnById(id);
    }

    /**
     * 查询报警信息列表
     *
     * @param tEquipmentWarn 报警信息
     * @return 报警信息
     */
    @Override
    public List<TEquipmentWarn> selectTEquipmentWarnList(TEquipmentWarn tEquipmentWarn)
    {
        return tEquipmentWarnMapper.selectTEquipmentWarnList(tEquipmentWarn);
    }

    @Override
    public List<StatisticsVO> statistics(String userName) {
        return tEquipmentWarnMapper.statistics(userName);
    }

    /**
     * 新增报警信息
     *
     * @param tEquipmentWarn 报警信息
     * @return 结果
     */
    @Override
    public int insertTEquipmentWarn(TEquipmentWarn tEquipmentWarn)
    {
        tEquipmentWarn.setCreateTime(DateUtils.getNowDate());
        return tEquipmentWarnMapper.insertTEquipmentWarn(tEquipmentWarn);
    }

    /**
     * 修改报警信息
     *
     * @param tEquipmentWarn 报警信息
     * @return 结果
     */
    @Override
    public int updateTEquipmentWarn(TEquipmentWarn tEquipmentWarn)
    {
        tEquipmentWarn.setUpdateTime(DateUtils.getNowDate());
        return tEquipmentWarnMapper.updateTEquipmentWarn(tEquipmentWarn);
    }

    /**
     * 批量删除报警信息
     *
     * @param ids 需要删除的报警信息主键
     * @return 结果
     */
    @Override
    public int deleteTEquipmentWarnByIds(Long[] ids)
    {
        return tEquipmentWarnMapper.deleteTEquipmentWarnByIds(ids);
    }

    /**
     * 删除报警信息信息
     *
     * @param id 报警信息主键
     * @return 结果
     */
    @Override
    public int deleteTEquipmentWarnById(Long id)
    {
        return tEquipmentWarnMapper.deleteTEquipmentWarnById(id);
    }
}
