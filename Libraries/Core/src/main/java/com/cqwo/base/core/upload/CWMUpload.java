/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.core.upload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by cqnews on 2017/12/25.
 */
@Component(value = "CWMUpload")
public class CWMUpload {

    /**
     * 上传模块策略
     */
    @Autowired(required = false)
    private IUploadStrategy iUploadStrategy;

    public CWMUpload() {
    }

    public CWMUpload(IUploadStrategy iUploadStrategy) {
        this.iUploadStrategy = iUploadStrategy;
    }

    public IUploadStrategy getiUploadStrategy() {
        return iUploadStrategy;
    }

    public void setiUploadStrategy(IUploadStrategy iUploadStrategy) {
        this.iUploadStrategy = iUploadStrategy;
    }

    @Override
    public String toString() {
        return "CWMUpload{" +
                "iUploadStrategy=" + iUploadStrategy +
                '}';
    }

}
