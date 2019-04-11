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
 *
 *@author Administrator
 *2013-12-22
 * 
 */
public interface ILog {
	void debug(String e);
	  void debug(String e, Throwable t);
	  void info(Object e);
	  void info(String e);
	  void info(String e, Throwable t);
	  void error(String e);
	  void error(String e, Throwable t);
}
