package com.cqwo.base.web.framework.model;

import com.cqwo.base.core.enums.authors.LoginType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.shiro.authc.UsernamePasswordToken;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserTokenPasswordToken extends UsernamePasswordToken {

    private static final long serialVersionUID = 644353652275378471L;

    /**
     * token
     */
    private String token = "token";


    /**
     * 类型
     */
    private LoginType loginType = LoginType.AdminLogin;


    public UserTokenPasswordToken(String account, String password) {
        super(account, password);
    }


    public UserTokenPasswordToken(String token, LoginType loginType) {
        super("", "0");
        this.token = token;
        this.loginType = loginType;
    }
}
