package com.equipment.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.equipment.common.annotation.Excel;
import com.equipment.common.core.domain.BaseEntity;

/**
 * 报警信息对象 t_equipment_warn
 *
 * @author equipment
 * @date 2023-02-18
 */
public class TEquipmentWarn extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 用户ID*/
    private Long userId;

    /** 设备ID */
    @Excel(name = "设备ID")
    private Long equipmentId;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String equipmentName;

    /** 设备位置 */
    @Excel(name = "设备位置")
    private String equipmentPostion;

    /** 告警类型 */
    @Excel(name = "告警类型")
    private String type;

    /** 告警类型 */
    @Excel(name = "告警类型")
    private String typeName;

    /** 处理结果 */
    @Excel(name = "处理结果")
    private String handleResult;

    /** 处理人 */
    @Excel(name = "处理人")
    private String handleBy;

    /** 处理时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "处理时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date handleTime;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setEquipmentId(Long equipmentId)
    {
        this.equipmentId = equipmentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEquipmentId()
    {
        return equipmentId;
    }
    public void setEquipmentName(String equipmentName)
    {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentName()
    {
        return equipmentName;
    }
    public void setEquipmentPostion(String equipmentPostion)
    {
        this.equipmentPostion = equipmentPostion;
    }

    public String getEquipmentPostion()
    {
        return equipmentPostion;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setHandleResult(String handleResult)
    {
        this.handleResult = handleResult;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getHandleResult()
    {
        return handleResult;
    }
    public void setHandleBy(String handleBy)
    {
        this.handleBy = handleBy;
    }

    public String getHandleBy()
    {
        return handleBy;
    }
    public void setHandleTime(Date handleTime)
    {
        this.handleTime = handleTime;
    }

    public Date getHandleTime()
    {
        return handleTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("equipmentId", getEquipmentId())
            .append("equipmentName", getEquipmentName())
            .append("equipmentPostion", getEquipmentPostion())
            .append("type", getType())
            .append("handleResult", getHandleResult())
            .append("handleBy", getHandleBy())
            .append("handleTime", getHandleTime())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
