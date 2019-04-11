/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.core.model;

/**
 * Created by cqnews on 2017/12/20.
 */
public class SelectListItem {

    /**
     * 如果选定此项，则为 true；否则为 false。
     */
    public boolean selected=false;

    /**
     * 文本
     */
    public String text="";

    /**
     * 值
     */
    public String value="";

    /**
     * 颜色
     */
    public String color = "";

    public SelectListItem() {
    }

    public SelectListItem(boolean selected, String text, String value) {
        this.selected=selected;
        this.text=text;
        this.value=value;
    }

    public SelectListItem(boolean selected, String text, String value, String color) {
        this.selected = selected;
        this.text = text;
        this.value = value;
        this.color = color;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected=selected;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text=text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value=value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}


