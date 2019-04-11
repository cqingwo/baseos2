package com.cqwo.base.core.domain.users;

import com.cqwo.base.core.helper.UnixTimeHelper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户token
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Entity
@Table(name = "W_users_token")
public class UserTokenInfo implements Serializable {


    private static final long serialVersionUID = 7223137506659169031L;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id = 0;

    /**
     * 要求唯一
     * uid
     */
    @Column(name = "uid", unique = true, nullable = false)
    private String uid = "";


    /**
     * token
     */
    @Column(name = "token", nullable = false, length = 500)
    private String token = "";

    /**
     * 过期时间
     */
    @Column(name = "limittime", nullable = false)
    private Integer limitTime = 0;

    public UserTokenInfo(String uid, String token) {
        this.uid = uid;
        this.token = token;
        this.limitTime = UnixTimeHelper.getUnixTimeStamp() + 60 * 60;
    }
}
