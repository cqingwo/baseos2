/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.core.domain.sms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by cqnews on 2017/3/23.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "w_sms")
public class SMSInfo implements Serializable {

    private static final long serialVersionUID = -2181654979352120507L;
    /**
     * 短信ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id = 0; // 短信ID
    /**
     * 用户ID
     */
    @Column(name = "uid", nullable = false)
    @ColumnDefault(value = "1")
    private Integer uid = 1; // 用户ID
    /**
     * 短信类型
     */
    @Column(name = "type", nullable = false)
    @ColumnDefault(value = "0")
    private Integer type = 0; // 短信类型
    /**
     * Code
     */
    @Column(name = "code", nullable = false, length = 10)
    @ColumnDefault(value = "''")
    private String code = ""; // Code
    /**
     * 发送的地址
     */
    @Column(name = "mobile", nullable = false, length = 12)
    @ColumnDefault(value = "''")
    private String mobile = ""; // 发送的地址
    /**
     * 发送内容
     */
    @Column(name = "body", nullable = false, length = 80)
    @ColumnDefault(value = "''")
    private String body = ""; // 发送内容
    /**
     * 手机发送短信时间
     */
    @Column(name = "sendtime", nullable = false)
    @ColumnDefault(value = "0")
    private Integer sendTime = 0; // 手机发送短信时间

}
