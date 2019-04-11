/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.core.log;

import org.apache.commons.logging.Log;

/**
 *
 *@author lzy
 *2013-12-22
 * 
 */
public class MonLog implements ILog{
	 private Log log;
	    public  MonLog(Log log){
	    	this.log = log;
	    }
	    
		@Override
        public void debug(String e) {
			if(log.isDebugEnabled()){
				log.debug(e);
			}	
			
		}
	   
		@Override
        public void debug(String e, Throwable t) {
			if(log.isDebugEnabled()){
				log.debug(e,t);
			}
		}
	   
		@Override
        public void error(String e) {
			if(log.isErrorEnabled()){
				  log.error(e);
			  }
		}
	   
		@Override
        public void error(String e, Throwable t) {
			 if(log.isErrorEnabled()){
				  log.error(e,t);
			  }
		}
	   
		@Override
        public void info(Object e) {
			if(log.isInfoEnabled()){
				log.info(e);
			}
		}
	  
		@Override
        public void info(String e) {
			if(log.isInfoEnabled()){
				log.info(e);
			}
		}
	  
		@Override
        public void info(String e, Throwable t) {
			if(log.isInfoEnabled()){
				log.info(e,t);
			}
			
		}
		

}
