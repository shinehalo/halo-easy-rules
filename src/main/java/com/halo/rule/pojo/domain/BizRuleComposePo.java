package com.halo.rule.pojo.domain;

import java.util.Date;

/**
 * @author halo
 * @description 规则组合
 * @date 2022/03/11
 */
public class BizRuleComposePo {
    /**
     * 主键
     */
    private Long id;
    /**
     * 规则ID
     */
    private Long ruleId;
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
     * 条件
     */
    private String condition;
    /**
     * 执行动作
     */
    private String actions;
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

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
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

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
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
