package com.equipment.system.service;

import java.util.List;
import com.equipment.system.domain.TEquiment;

/**
 * 设备Service接口
 * 
 * @author equipment
 * @date 2023-02-18
 */
public interface ITEquimentService 
{
    /**
     * 查询设备
     * 
     * @param id 设备主键
     * @return 设备
     */
    public TEquiment selectTEquimentById(Long id);

    /**
     * 查询设备列表
     * 
     * @param tEquiment 设备
     * @return 设备集合
     */
    public List<TEquiment> selectTEquimentList(TEquiment tEquiment);

    /**
     * 新增设备
     * 
     * @param tEquiment 设备
     * @return 结果
     */
    public int insertTEquiment(TEquiment tEquiment);

    /**
     * 修改设备
     * 
     * @param tEquiment 设备
     * @return 结果
     */
    public int updateTEquiment(TEquiment tEquiment);

    /**
     * 批量删除设备
     * 
     * @param ids 需要删除的设备主键集合
     * @return 结果
     */
    public int deleteTEquimentByIds(Long[] ids);

    /**
     * 删除设备信息
     * 
     * @param id 设备主键
     * @return 结果
     */
    public int deleteTEquimentById(Long id);
}
