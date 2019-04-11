/*
 *
 *  *
 *  *  * Copyright (C) 2018.
 *  *  * 用于JAVA项目开发
 *  *  * 重庆青沃科技有限公司 版权所有
 *  *  * Copyright (C)  2018.  CqingWo Systems Incorporated. All rights reserved.
 *  *
 *
 */

package com.cqwo.base.core.plugin;

import java.io.Serializable;

public class PluginInfo implements Serializable {

    /**
     * 插件Id
     */
    private Integer pluginId = 0;

    /**
     * 插件系统名称(必须具有唯一性)
     */
    private String systemName = "";//插件系统名称(必须具有唯一性)

    /**
     * 插件友好名称
     */
    private String friendlyName = "";//插件友好名称


    /**
     * 插件描述
     */
    private String description = "";//插件描述
    /**
     * 插件类型(0代表开放授权插件，1代表支付插件)
     */
    private Integer type = 0;//插件类型(0代表开放授权插件，1代表支付插件)

    /**
     * 插件作者
     */
    private String author = "";//插件作者
    /**
     * 插件版本
     */
    private String version = "";//插件版本
    /**
     * 插件支持的版本
     */
    private String supVersion = "";//插件支持的版本

    /**
     * 插件顺序
     */
    private Integer displayOrder = 0;//插件顺序

    /**
     * 是否是默认插件
     */
    private Integer isDefault = 0;//是否是默认插件


    public PluginInfo() {
    }


    public PluginInfo(Integer pluginId, String systemName, String friendlyName, String description, Integer type, String author, String version, String supVersion, Integer displayOrder, Integer isDefault) {
        this.pluginId = pluginId;
        this.systemName = systemName;
        this.friendlyName = friendlyName;
        this.description = description;
        this.type = type;
        this.author = author;
        this.version = version;
        this.supVersion = supVersion;
        this.displayOrder = displayOrder;
        this.isDefault = isDefault;
    }

    public Integer getPluginId() {
        return pluginId;
    }

    public void setPluginId(Integer pluginId) {
        this.pluginId = pluginId;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSupVersion() {
        return supVersion;
    }

    public void setSupVersion(String supVersion) {
        this.supVersion = supVersion;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public String toString() {
        return "PluginInfo{" +
                "systemName='" + systemName + '\'' +
                ", friendlyName='" + friendlyName + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", author='" + author + '\'' +
                ", version='" + version + '\'' +
                ", supVersion='" + supVersion + '\'' +
                ", displayOrder=" + displayOrder +
                ", isDefault=" + isDefault +
                '}';
    }
}
