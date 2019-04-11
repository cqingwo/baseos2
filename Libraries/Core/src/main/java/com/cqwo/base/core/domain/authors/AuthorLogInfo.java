/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.core.domain.authors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;

//管理日志
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "w_author_adminlogs")
public class AuthorLogInfo implements Serializable {

    private static final long serialVersionUID = 2844597345561609020L;
    /**
     * 日志Id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "logid")
    private Integer logId = 0;
    /**
     * 用户Id
     **/
    @Column(name = "uid", nullable = false)
    @ColumnDefault(value = "0")
    private Integer uid = 0;
    /**
     * 昵称
     **/
    @Column(name = "nickname", nullable = false, length = 30)
    @ColumnDefault(value = "''")
    private String nickName = "";
    /**
     * 管理组Id
     **/
    @Column(name = "admingid", nullable = false)
    @ColumnDefault(value = "0")
    private Integer adminGid = 0;
    /**
     * 管理组标题
     **/
    @Column(name = "admingtitle", nullable = false, length = 50)
    @ColumnDefault(value = "''")
    private String adminGtitle = "";
    /**
     * 操作标题
     **/
    @Column(name = "operation", nullable = false, length = 50)
    @ColumnDefault(value = "''")
    private String operation = "";
    /**
     * 描述
     **/
    @Column(name = "description", nullable = false, length = 150)
    @ColumnDefault(value = "''")
    private String description = "";
    /**
     * IP
     **/
    @Column(name = "ip", nullable = false, length = 32)
    @ColumnDefault(value = "''")
    private String ip = "";
    /**
     * 操作时间
     **/
    @Column(name = "operatetime", nullable = false, updatable = false)
    @ColumnDefault(value = "0")
    private Integer operateTime = 0;

}