package com.equipment.system.mapper;

import java.util.List;
import com.equipment.system.domain.TEquipmentWarn;
import com.equipment.system.domain.vo.StatisticsVO;

/**
 * 报警信息Mapper接口
 *
 * @author equipment
 * @date 2023-02-18
 */
public interface TEquipmentWarnMapper
{
    /**
     * 查询报警信息
     *
     * @param id 报警信息主键
     * @return 报警信息
     */
    public TEquipmentWarn selectTEquipmentWarnById(Long id);

    /**
     * 查询报警信息列表
     *
     * @param tEquipmentWarn 报警信息
     * @return 报警信息集合
     */
    public List<TEquipmentWarn> selectTEquipmentWarnList(TEquipmentWarn tEquipmentWarn);

    /**
     * 新增报警信息
     *
     * @param tEquipmentWarn 报警信息
     * @return 结果
     */
    public int insertTEquipmentWarn(TEquipmentWarn tEquipmentWarn);

    /**
     * 修改报警信息
     *
     * @param tEquipmentWarn 报警信息
     * @return 结果
     */
    public int updateTEquipmentWarn(TEquipmentWarn tEquipmentWarn);

    /**
     * 删除报警信息
     *
     * @param id 报警信息主键
     * @return 结果
     */
    public int deleteTEquipmentWarnById(Long id);

    /**
     * 批量删除报警信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTEquipmentWarnByIds(Long[] ids);

    List<StatisticsVO> statistics(String userName);
}
