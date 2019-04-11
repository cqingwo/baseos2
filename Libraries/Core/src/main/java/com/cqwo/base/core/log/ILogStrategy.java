/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.core.log;

/**
 * Created by cqnews on 2017/4/15.
 */
public interface ILogStrategy {

    /**
     * 写入日志
     * @param message 消息
     */
    void write(String message);

    /**
     * debug输出
     *
     * @param message
     */
    void debug(String message);

    /**
     * info输出
     *
     * @param message
     */
    void info(String message);

    /**
     * warn输出
     *
     * @param message
     */
    void warn(String message);

    /**
     * error输出
     *
     * @param message
     */
    void error(String message);

    /**
     * fatal输出
     *
     * @param message
     */
    void fatal(String message);
}
