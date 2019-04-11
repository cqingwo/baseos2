/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.web.framework.validate;

/**
 * Created by cqnews on 2017/12/15.
 */

import java.text.MessageFormat;
import java.util.Map;

/**
 * 校验结果
 *
 * @author wdmcygah
 */
public class ValidationResult {

    //校验结果是否有错
    private boolean hasErrors=false;

    //校验错误信息
    private Map<String, String> errorMsg;

    public boolean isHasErrors() {
        return hasErrors;
    }

    public boolean isNotErrors(){
        return !hasErrors;
    }

    public void setHasErrors(boolean hasErrors) {
        this.hasErrors=hasErrors;
    }

    public Map<String, String> getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(Map<String, String> errorMsg) {
        this.errorMsg=errorMsg;
    }

    @Override
    public String toString() {

        StringBuilder str=new StringBuilder();

        if(errorMsg == null) {
            return "";
        }

        for (String v : errorMsg.values()) {
            str.append(MessageFormat.format(",{0}", v));
        }

        if (str.length() >= 1) {
            str.delete(0, 1);
        }

        return str.toString();
    }

}
