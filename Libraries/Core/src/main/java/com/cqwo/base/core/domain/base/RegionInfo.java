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

//区域信息

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "w_commom_regions")
public class RegionInfo implements Serializable {

    private static final long serialVersionUID = -6747778980750175138L;
    /**
     * 区域id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "regionid")
    private Integer regionId = 0;


    /**
     * 名称
     **/
    @Column(name = "name", nullable = false, length = 30)
    @ColumnDefault(value = "''")
    private String name = "";

    /**
     * 名称
     **/
    @Column(name = "engname", nullable = false, length = 30)
    @ColumnDefault(value = "''")
    private String engName = "";


    /**
     * 拼写
     **/
    @Column(name = "spell", nullable = false, length = 30)
    @ColumnDefault(value = "''")
    private String spell = "";


    /**
     * 简拼
     **/
    @Column(name = "shortspell", nullable = false, length = 20)
    @ColumnDefault(value = "''")
    private String shortSpell = "";


    /**
     * 排序
     **/
    @Column(name = "displayorder", nullable = false)
    @ColumnDefault(value = "0")
    private Integer displayOrder = 0;


    /**
     * 父id
     **/
    @Column(name = "parentid", nullable = false)
    @ColumnDefault(value = "0")
    private Integer parentId = 0;


    /**
     * 级别
     **/
    @Column(name = "layer", nullable = false)
    @ColumnDefault(value = "0")
    private Integer layer = 0;


    /**
     * 省id
     **/
    @Column(name = "provinceid", nullable = false)
    @ColumnDefault(value = "0")
    private Integer provinceId = 0;


    /**
     * 省名称
     **/
    @Column(name = "provincename", nullable = false, length = 20)
    @ColumnDefault(value = "''")
    private String provinceName = "";


    /**
     * 市id
     **/
    @Column(name = "cityid", nullable = false)
    @ColumnDefault(value = "0")
    private Integer cityId = 0;


    /**
     * 市名称
     **/
    @Column(name = "cityname", nullable = false, length = 20)
    @ColumnDefault(value = "''")
    private String cityName = "";


}