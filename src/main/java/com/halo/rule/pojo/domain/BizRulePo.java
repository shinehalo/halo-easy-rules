package com.halo.rule.pojo.domain;

import java.util.Date;

/**
 * @author halo
 * @description 业务规则
 * @date 2022/03/11
 */
public class BizRulePo {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 规则名称
     */
    private String name;
    /**
     * 描述
     */
    private String description;
    /**
     * 优先级
     */
    private Integer priority;
    /**
     * 组合类型 {@link com.halo.rule.enums.CompositeRuleTypeEnum}
     */
    private Integer compositeType;
    /**
     * 数据状态 0-有效 1-无效
     */
    private Integer state;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getCompositeType() {
        return compositeType;
    }

    public void setCompositeType(Integer compositeType) {
        this.compositeType = compositeType;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
