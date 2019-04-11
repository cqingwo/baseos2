package com.cqwo.base.core.domain.base;


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
@DynamicUpdate
public class AccessToken implements Serializable {

    private static final long serialVersionUID = 7075261125215507326L;

    /**
     * 用户uid
     */
    private String uid = "";

    /**
     * 盐值
     */
    private String salt = "";

    /**
     * 过期时间
     */
    private Integer creatTime = 0;

}