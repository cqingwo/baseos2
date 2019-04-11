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

//禁用Ip
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "w_commom_bannedips")
public class BannedIPInfo implements Serializable {

    private static final long serialVersionUID = -7924205615914753847L;

    /**
     * 禁用Id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id = 0;

    /**
     * IP
     **/
    @Column(name = "ip", nullable = false, length = 30)
    @ColumnDefault(value = "''")
    private String ip = "";

    /**
     * 禁止过期时间
     **/
    @Column(name = "liftbantime", nullable = false)
    @ColumnDefault(value = "0")
    private Integer liftBanTime = 0;

}