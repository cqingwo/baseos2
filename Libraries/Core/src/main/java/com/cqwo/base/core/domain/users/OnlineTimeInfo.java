/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.core.domain.users;

import javax.persistence.*;
import java.io.Serializable;

//在线时间统计
@Entity
@Table(name = "w_user_onlinetime")
public class OnlineTimeInfo implements Serializable {

    private static final long serialVersionUID = 8712096278634674842L;
    /**
     * 在线时间统计
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    /**
     * Uid
     **/
    @Column(name = "uid")
    private Integer uid = -1;
    /**
     * 总计在线
     **/
    @Column(name = "total")
    private Integer total = 0;
    /**
     * 年
     **/
    @Column(name = "year")
    private Integer year = 0;
    /**
     * 月
     **/
    @Column(name = "month")
    private Integer month = 0;
    /**
     * 周
     **/
    @Column(name = "week")
    private Integer week = 0;
    /**
     * 日
     **/
    @Column(name = "day")
    private Integer day = 0;
    /**
     * 更新时间
     **/
    @Column(name = "updatetime")
    private Integer updateTime = 0;

    public OnlineTimeInfo() {
    }

    public OnlineTimeInfo(Integer id) {
        this.id = id;
    }

    public OnlineTimeInfo(Integer uid, Integer total, Integer year, Integer month, Integer week, Integer day, Integer updateTime) {
        this.uid = uid;
        this.total = total;
        this.year = year;
        this.month = month;
        this.week = week;
        this.day = day;
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "OnlineTimeInfo{" +
                "id=" + id +
                ", uid=" + uid +
                ", total=" + total +
                ", year=" + year +
                ", month=" + month +
                ", week=" + week +
                ", day=" + day +
                ", updateTime=" + updateTime +
                '}';
    }
}