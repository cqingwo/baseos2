/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.core.data;


import com.cqwo.base.core.data.rdbs.IBaseStrategy;
import com.cqwo.base.core.data.rdbs.IUserStrategy;
import com.cqwo.base.core.data.rdbs.IAuthorStrategy;
import com.cqwo.base.core.data.rdbs.ILog2Strategy;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cqnews on 2017/4/10.
 */
@Service(value = "CWMData")
@Setter
@Getter
public class CWMData {

    @Autowired(required = false)
    IUserStrategy iUserStrategy;

    @Autowired(required = false)
    IAuthorStrategy iAuthorStrategy;

    @Autowired(required = false)
    ILog2Strategy iLog2Strategy;

    @Autowired(required = false)
    IBaseStrategy iBaseStrategy;

}
