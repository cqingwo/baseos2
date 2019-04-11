/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.core.domain.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

//用户细节
@Data
@Entity
@Table(name = "w_user_userdetails")
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailInfo implements Serializable {

    private static final long serialVersionUID = 2785982437694600133L;
    /**
     * 记录Id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id = 0;
    /**
     * Uid
     **/
    @Column(name = "uid", nullable = false)
    private String uid = "";
    /**
     * 最后访问时间
     **/
    @Column(name = "lastvisittime", nullable = false)
    private Integer lastVisitTime = 0;
    /**
     * 最后访问ip
     **/
    @Column(name = "lastvisitip", nullable = false, length = 30)
    private String lastVisitIP = "";
    /**
     * 最后访问区域id
     **/
    @Column(name = "lastvisitrgid", nullable = false)
    private Integer lastVisitRgid = 0;
    /**
     * 用户注册时间
     **/
    @Column(name = "registertime", nullable = false)
    private Integer registerTime = 0;
    /**
     * 用户注册ip
     **/
    @Column(name = "registerip", nullable = false, length = 30)
    private String registerIP = "";
    /**
     * 用户注册区域id
     **/
    @Column(name = "registerrgid", nullable = false)
    private Integer registerRgid = 0;
    /**
     * 用户性别(0代表未知，1代表男，2代表女)
     **/
    @Column(name = "gender", nullable = false)
    private Integer gender = 0;
    /**
     * 生日
     **/
    @Column(name = "birthday", nullable = false)
    private Integer birthday = 0;
    /**
     * 身份证号
     **/
    @Column(name = "idcard", nullable = false, length = 30)
    private String idCard = "";
    /**
     * bio
     **/
    @Column(name = "bio", nullable = false, length = 500)
    private String bio = "";


}