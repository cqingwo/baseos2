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

import org.apache.commons.collections.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 校验工具类
 *
 * @author wdmcygah
 */
public class ValidateModel {




    private static Validator validator=Validation.buildDefaultValidatorFactory().getValidator();

    public static <T> ValidationResult validateEntity(T obj) {

        ValidationResult result=new ValidationResult();
        Set<ConstraintViolation<T>> set=validator.validate(obj, Default.class);
        if (CollectionUtils.isNotEmpty(set)) {
            Map<String, String> errorMsg=new HashMap<String, String>();
            for (ConstraintViolation<T> cv : set) {
                errorMsg.put(cv.getPropertyPath().toString(), cv.getMessage());
            }
            result.setErrorMsg(errorMsg);
        }


        if (result.getErrorMsg() != null && result.getErrorMsg().size() >= 1) {
            result.setHasErrors(true);
        } else {
            result.setHasErrors(false);
        }

        return result;
    }

    public static <T> ValidationResult validateProperty(T obj, String propertyName) {
        ValidationResult result=new ValidationResult();
        Set<ConstraintViolation<T>> set=validator.validateProperty(obj, propertyName, Default.class);
        if (CollectionUtils.isNotEmpty(set)) {
            result.setHasErrors(true);
            Map<String, String> errorMsg=new HashMap<String, String>();
            for (ConstraintViolation<T> cv : set) {
                errorMsg.put(propertyName, cv.getMessage());
            }
            result.setErrorMsg(errorMsg);
        }
        return result;
    }
}
