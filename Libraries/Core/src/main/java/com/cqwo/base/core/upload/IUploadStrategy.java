/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.core.upload;

import java.util.List;

/**
 * Created by cqnews on 2017/12/25.
 */
public interface IUploadStrategy {


    /**
     * 文件上传
     * @param fload 路径
     * @return
     * @throws Exception
     */
    List<UploadFileInfo> fileUpload(String fload) throws Exception;

    /**
     * 获取客户端token
     * @return
     */
    String getUpToken() throws Exception;
}
