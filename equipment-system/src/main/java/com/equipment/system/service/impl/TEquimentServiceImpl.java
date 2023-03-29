package com.equipment.system.service.impl;

import java.util.List;
import com.equipment.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.equipment.system.mapper.TEquimentMapper;
import com.equipment.system.domain.TEquiment;
import com.equipment.system.service.ITEquimentService;

/**
 * 设备Service业务层处理
 *
 * @author equipment
 * @date 2023-02-18
 */
@Service
public class TEquimentServiceImpl implements ITEquimentService
{
    @Autowired
    private TEquimentMapper tEquimentMapper;

    /**
     * 查询设备
     *
     * @param id 设备主键
     * @return 设备
     */
    @Override
    public TEquiment selectTEquimentById(Long id)
    {
        return tEquimentMapper.selectTEquimentById(id);
    }

    /**
     * 查询设备列表
     *
     * @param tEquiment 设备
     * @return 设备
     */
    @Override
    public List<TEquiment> selectTEquimentList(TEquiment tEquiment)
    {
        return tEquimentMapper.selectTEquimentList(tEquiment);
    }

    /**
     * 新增设备
     *
     * @param tEquiment 设备
     * @return 结果
     */
    @Override
    public int insertTEquiment(TEquiment tEquiment)
    {
        tEquiment.setCreateTime(DateUtils.getNowDate());
        return tEquimentMapper.insertTEquiment(tEquiment);
    }

    /**
     * 修改设备
     *
     * @param tEquiment 设备
     * @return 结果
     */
    @Override
    public int updateTEquiment(TEquiment tEquiment)
    {
        tEquiment.setUpdateTime(DateUtils.getNowDate());
        return tEquimentMapper.updateTEquiment(tEquiment);
    }

    /**
     * 批量删除设备
     *
     * @param ids 需要删除的设备主键
     * @return 结果
     */
    @Override
    public int deleteTEquimentByIds(Long[] ids)
    {
        return tEquimentMapper.deleteTEquimentByIds(ids);
    }

    /**
     * 删除设备信息
     *
     * @param id 设备主键
     * @return 结果
     */
    @Override
    public int deleteTEquimentById(Long id)
    {
        return tEquimentMapper.deleteTEquimentById(id);
    }
}
