package com.equipment.system.domain.vo;

/**
 * @Author: weisong
 * @CreateTime: 2023-02-19  18:22
 * @Description: TODO
 * @Version: 1.0
 */
public class StatisticsVO {
    private Integer count;
    private String type;
    private String typeName;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
