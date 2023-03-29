package com.equipment.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.equipment.common.annotation.Excel;
import com.equipment.common.core.domain.BaseEntity;

/**
 * 设备对象 t_equiment
 *
 * @author equipment
 * @date 2023-02-18
 */
public class TEquiment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String name;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private String type;

    /** 品牌 */
    @Excel(name = "品牌")
    private String brand;

    /** 设备位置 */
    @Excel(name = "设备位置")
    private String position;

    /** 通道号 */
    @Excel(name = "通道号")
    private String channelNo;

    /** 控制编号 */
    @Excel(name = "控制编号")
    private String controlNo;

    /** ip */
    @Excel(name = "ip")
    private String ip;

    /** 负责人 */
    @Excel(name = "负责人")
    private String director;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String qqEmail;

    /** 设备状态 01正常 02预警 */
    @Excel(name = "设备状态 01正常 02预警")
    private String status;

    /** 逻辑删除 */
    private Integer delFlag;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getBrand()
    {
        return brand;
    }
    public void setPosition(String position)
    {
        this.position = position;
    }

    public String getPosition()
    {
        return position;
    }
    public void setChannelNo(String channelNo)
    {
        this.channelNo = channelNo;
    }

    public String getChannelNo()
    {
        return channelNo;
    }
    public void setControlNo(String controlNo)
    {
        this.controlNo = controlNo;
    }

    public String getControlNo()
    {
        return controlNo;
    }
    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public String getIp()
    {
        return ip;
    }
    public void setDirector(String director)
    {
        this.director = director;
    }

    public String getDirector()
    {
        return director;
    }
    public void setQqEmail(String qqEmail)
    {
        this.qqEmail = qqEmail;
    }

    public String getQqEmail()
    {
        return qqEmail;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setDelFlag(Integer delFlag)
    {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag()
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("type", getType())
            .append("brand", getBrand())
            .append("position", getPosition())
            .append("channelNo", getChannelNo())
            .append("controlNo", getControlNo())
            .append("ip", getIp())
            .append("director", getDirector())
            .append("qqEmail", getQqEmail())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
