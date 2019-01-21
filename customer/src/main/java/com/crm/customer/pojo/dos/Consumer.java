package com.crm.customer.pojo.dos;

import java.util.Date;

public class Consumer {
    private Integer id;

    private Integer parentId;

    private String name;

    private String idCard;

    private String number;

    private Integer statusId;

    private Integer levelId;

    private Integer consumerTradeId;

    private Date nextContactDatetime;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public Integer getConsumerTradeId() {
        return consumerTradeId;
    }

    public void setConsumerTradeId(Integer consumerTradeId) {
        this.consumerTradeId = consumerTradeId;
    }

    public Date getNextContactDatetime() {
        return nextContactDatetime;
    }

    public void setNextContactDatetime(Date nextContactDatetime) {
        this.nextContactDatetime = nextContactDatetime;
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