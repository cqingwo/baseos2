/*
 *  *  Copyright  2019.
 *  *  用于JAVA项目开发
 *  *  重庆英卡电子有限公司 版权所有
 *  *  Copyright  2019.  510Link.com Iniot All rights reserved.
 */

package com.cqwo.base.core.enums.authors;

public enum LoginType {

    /**
     * 用户登录
     */
    AdminLogin(0, "AdminLogin"),
    /**
     * Token登录
     */
    ApiLogin(1, "ApiLogin"),
    /**
     * Token登录
     */
    TokenLogin(2, "TokenLogin"),

    /**
     * 开发接口登录
     */
    OauthsLogin(3, "OauthsLogin");

    private Integer index;

    private String name;

    LoginType(Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /**
     * 获取登录类型
     *
     * @param name 名称
     * @return
     */
    public static LoginType getLoginType(String name) {

        for (LoginType type : LoginType.values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }

        return AdminLogin;
    }

}
