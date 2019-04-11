package com.cqwo.base.core.domain.users;


import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * @Author: cqnews
 * @Date: 2018-09-29 17:51
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserToken implements Serializable {

    private static final long serialVersionUID = 7075261125215507326L;

    /**
     * 用户uid
     */
    private String uid = "";

    /**
     * 应用Id
     */
    private Integer appId = 0;

    /**
     * 盐值
     */
    private String salt = "";

    /**
     * 过期时间
     */
    private Integer limitTime = 0;

}
