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

package com.cqwo.base.core.message;

public enum MessageType {

    /**
     * 消息类型
     */
    Error("错误抛弃", 0), Heart("心跳", 1), UpdateMachineInfo("更新游戏配置", 2), UpdateGameList("更新游戏列表", 3), Recharge("充值", 4), Coin("投币", 5), Respond("消息回调", 6), Message("消息", 7), Command("Liunx命令", 8);

    // 成员变量
    private String name;
    private Integer index;

    // 构造方法
    private MessageType(String name, Integer index) {
        this.name = name;
        this.index = index;
    }


    // 普通方法
    public static String getName(Integer index) {
        MessageType[] types = MessageType.values();
        for (MessageType m : types) {
            if (m.getIndex().equals(index)) {
                return m.name;
            }
        }
        return null;
    }

    // get set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }


}
