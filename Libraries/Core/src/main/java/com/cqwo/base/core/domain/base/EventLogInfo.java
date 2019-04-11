/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.core.domain.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;

//定时器日志
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "w_commom_eventlogs")
public class EventLogInfo implements Serializable {


    private static final long serialVersionUID = 4258781435710140006L;
    /**
     * 定时器Id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id = 0;

    /**
     * 关键字
     **/
    @Column(name = "key", nullable = false, length = 30)
    @ColumnDefault(value = "''")
    private String key = "";

    /**
     * 标题
     **/
    @Column(name = "title", nullable = false, length = 50)
    @ColumnDefault(value = "''")
    private String title = "";

    /**
     * 服务
     **/
    @Column(name = "server", nullable = false, length = 50)
    @ColumnDefault(value = "''")
    private String server = "";

    /**
     * 执行时间
     **/
    @Column(name = "executetime", nullable = false)
    @ColumnDefault(value = "0")
    private Integer executeTime = 0;

}