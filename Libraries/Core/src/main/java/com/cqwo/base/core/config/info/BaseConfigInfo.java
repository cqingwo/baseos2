/*
 * Copyright (C) 2017.
 * 用于配置信息
 * 重庆青沃科技有限公司 版权所有
 * Copyright © 2017.  CqingWo Systems Incorporated. All rights reserved.
 */

package com.cqwo.base.core.config.info;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by cqnews on 2017/4/13.
 */

@XmlAccessorType(XmlAccessType.PROPERTY)
// XML文件中的根标识
@XmlRootElement(name = "BaseConfigInfo")
public class BaseConfigInfo implements IConfigInfo {

    //region 站点信息

    /**
     * 项目名称
     */
    private String mallname = "英卡电子";

    /**
     * 网站网址
     */
    private String siteurl = "http://www.cqwo.com";
    /**
     * 网站标题
     */
    private String sitetitle = "英卡电子";
    /**
     * seo关键字
     */
    private String seokeyword = "英卡电子";
    /**
     * seo描述
     */
    private String seodescription = "英卡电子";
    /**
     * 备案编号
     */
    private String icp = "渝ICP备15003647号";
    /**
     * 脚本
     */
    private String script = "";
    /**
     * 是否显示版权(0代表不显示，1代表显示)
     */
    private Integer islicensed = 1;

    public String getMallname() {
        return mallname;
    }

    public void setMallname(String mallname) {
        this.mallname = mallname;
    }

    public String getSiteurl() {
        return siteurl;
    }

    public void setSiteurl(String siteurl) {
        this.siteurl = siteurl;
    }

    public String getSitetitle() {
        return sitetitle;
    }

    public void setSitetitle(String sitetitle) {
        this.sitetitle = sitetitle;
    }

    public String getSeokeyword() {
        return seokeyword;
    }

    public void setSeokeyword(String seokeyword) {
        this.seokeyword = seokeyword;
    }

    public String getSeodescription() {
        return seodescription;
    }

    public void setSeodescription(String seodescription) {
        this.seodescription = seodescription;
    }

    public String getIcp() {
        return icp;
    }

    public void setIcp(String icp) {
        this.icp = icp;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public Integer getIslicensed() {
        return islicensed;
    }

    public void setIslicensed(Integer islicensed) {
        this.islicensed = islicensed;
    }
//endregion

    //region 账号设置

    /**
     * 注册类型(1代表用户名注册，2代表邮箱注册，3代表手机注册，空字符串代表不允许注册)
     */
    private String regtype = "3";
    /**
     * 保留用户名
     */
    private String reservedname = "cqnews,admin,master,administrator,yjwwtu,liuyang,laijie";
    /**
     * 注册时间间隔(单位为秒，0代表无限制)
     */
    private Integer regtimespan = 0;
    /**
     * 是否发送欢迎信息(0代表不发送，1代表发送)
     */
    private Integer iswebcomemsg = 0;
    /**
     * 欢迎信息
     */
    private String webcomemsg = "欢迎来到我们的网站";
    /**
     * 登陆类型(1代表用户名登陆，2代表邮箱登陆，3代表手机登陆，空字符串代表不允许登陆)
     */
    private String logintype = "3";
    /**
     * 影子登录名
     */
    private String shadowname = "shadname";
    /**
     * 是否记住密码(0代表不记住，1代表记住)
     */
    private Integer isremember = 1;
    /**
     * 登陆失败次数
     */
    private Integer loginfailtimes = 0;

    public String getRegtype() {
        return regtype;
    }

    public void setRegtype(String regtype) {
        this.regtype = regtype;
    }

    public String getReservedname() {
        return reservedname;
    }

    public void setReservedname(String reservedname) {
        this.reservedname = reservedname;
    }

    public Integer getRegtimespan() {
        return regtimespan;
    }

    public void setRegtimespan(Integer regtimespan) {
        this.regtimespan = regtimespan;
    }

    public Integer getIswebcomemsg() {
        return iswebcomemsg;
    }

    public void setIswebcomemsg(Integer iswebcomemsg) {
        this.iswebcomemsg = iswebcomemsg;
    }

    public String getWebcomemsg() {
        return webcomemsg;
    }

    public void setWebcomemsg(String webcomemsg) {
        this.webcomemsg = webcomemsg;
    }

    public String getLogintype() {
        return logintype;
    }

    public void setLogintype(String logintype) {
        this.logintype = logintype;
    }

    public String getShadowname() {
        return shadowname;
    }

    public void setShadowname(String shadowname) {
        this.shadowname = shadowname;
    }

    public Integer getIsremember() {
        return isremember;
    }

    public void setIsremember(Integer isremember) {
        this.isremember = isremember;
    }

    public Integer getLoginfailtimes() {
        return loginfailtimes;
    }

    public void setLoginfailtimes(Integer loginfailtimes) {
        this.loginfailtimes = loginfailtimes;
    }

    //endregion

    //region 上传设置

    /**
     * 上传服务器
     */
    private String uploadserver = "";
    /**
     * 上传的图片类型,例如".jpg"
     */
    private String uploadimgtype = "";
    /**
     * 上传图片的大小(单位为字节)
     */
    private Integer uploadimgsize = 22;
    /**
     * 上传附件的类型,例如".zip"
     */
    private String uploadfiletype = "";
    /**
     * 上传附件的大小(单位为字节)
     */
    private Integer uploadfilesize = 22;
    /**
     * 水印类型(0代表没有水印，1代表文字水印，2代表图片水印)
     */
    private Integer watermarktype = 0;
    /**
     * 水印质量(必须位于0到100之间)
     */
    private Integer watermarkquality = 0;
    /**
     * 水印位置(1代表上左，2代表上中，3代表上右，4代表中左，5代表中中，6代表中右，7代表下左，8代表下中，9代表下右)
     */
    private Integer watermarkposition = 9;
    /**
     * 水印图片
     */
    private String watermarkimg = "watermark.png";
    /**
     * 水印图片透明度(必须位于1到10之间)
     */
    private Integer watermarkimgopacity = 0;
    /**
     * 水印文字
     */
    private String watermarktext = "英卡电子";
    /**
     * 水印文字字体
     */
    private String watermarktextfont = "Microsoft Yahei";
    /**
     * 水印文字大小
     */
    private Integer watermarktextsize = 14;

    public String getUploadserver() {
        return uploadserver;
    }

    public void setUploadserver(String uploadserver) {
        this.uploadserver = uploadserver;
    }

    public String getUploadimgtype() {
        return uploadimgtype;
    }

    public void setUploadimgtype(String uploadimgtype) {
        this.uploadimgtype = uploadimgtype;
    }

    public Integer getUploadimgsize() {
        return uploadimgsize;
    }

    public void setUploadimgsize(Integer uploadimgsize) {
        this.uploadimgsize = uploadimgsize;
    }

    public String getUploadfiletype() {
        return uploadfiletype;
    }

    public void setUploadfiletype(String uploadfiletype) {
        this.uploadfiletype = uploadfiletype;
    }

    public Integer getUploadfilesize() {
        return uploadfilesize;
    }

    public void setUploadfilesize(Integer uploadfilesize) {
        this.uploadfilesize = uploadfilesize;
    }

    public Integer getWatermarktype() {
        return watermarktype;
    }

    public void setWatermarktype(Integer watermarktype) {
        this.watermarktype = watermarktype;
    }

    public Integer getWatermarkquality() {
        return watermarkquality;
    }

    public void setWatermarkquality(Integer watermarkquality) {
        this.watermarkquality = watermarkquality;
    }

    public Integer getWatermarkposition() {
        return watermarkposition;
    }

    public void setWatermarkposition(Integer watermarkposition) {
        this.watermarkposition = watermarkposition;
    }

    public String getWatermarkimg() {
        return watermarkimg;
    }

    public void setWatermarkimg(String watermarkimg) {
        this.watermarkimg = watermarkimg;
    }

    public Integer getWatermarkimgopacity() {
        return watermarkimgopacity;
    }

    public void setWatermarkimgopacity(Integer watermarkimgopacity) {
        this.watermarkimgopacity = watermarkimgopacity;
    }

    public String getWatermarktext() {
        return watermarktext;
    }

    public void setWatermarktext(String watermarktext) {
        this.watermarktext = watermarktext;
    }

    public String getWatermarktextfont() {
        return watermarktextfont;
    }

    public void setWatermarktextfont(String watermarktextfont) {
        this.watermarktextfont = watermarktextfont;
    }

    public Integer getWatermarktextsize() {
        return watermarktextsize;
    }

    public void setWatermarktextsize(Integer watermarktextsize) {
        this.watermarktextsize = watermarktextsize;
    }

    //endregion

    //region 性能设置

    /**
     * 图片cdn(不能以"/"结尾)
     */
    private String imagecdn = "";
    /**
     * csscdn(不能以"/"结尾)
     */
    private String csscdn = "";
    /**
     * 脚本cdn(不能以"/"结尾)
     */
    private String scriptcdn = "";
    /**
     * 在线用户过期时间(单位为分钟)
     */
    private Integer onlineuserexpire = 10;
    /**
     * 最大在线人数
     */
    private Integer maxonlinecount = 1000;
    /**
     * 在线人数缓存时间(单位为分钟,0代表即时数量)
     */
    private Integer onlinecountexpire = 5;
    /**
     * 更新用户在线时间间隔(单位为分钟,0代表不更新)
     */
    private Integer updateonlinetimespan = 5;
    /**
     * 是否统计浏览器(0代表不统计，1代表统计)
     */
    private Integer isstatbrowser = 1;
    /**
     * 是否统计操作系统(0代表不统计，1代表统计)
     */
    private Integer isstatos = 1;
    /**
     * 是否统计区域(0代表不统计，1代表统计)
     */
    private Integer isstatregion = 1;

    public String getImagecdn() {
        return imagecdn;
    }

    public void setImagecdn(String imagecdn) {
        this.imagecdn = imagecdn;
    }

    public String getCsscdn() {
        return csscdn;
    }

    public void setCsscdn(String csscdn) {
        this.csscdn = csscdn;
    }

    public String getScriptcdn() {
        return scriptcdn;
    }

    public void setScriptcdn(String scriptcdn) {
        this.scriptcdn = scriptcdn;
    }

    public Integer getOnlineuserexpire() {
        return onlineuserexpire;
    }

    public void setOnlineuserexpire(Integer onlineuserexpire) {
        this.onlineuserexpire = onlineuserexpire;
    }

    public Integer getMaxonlinecount() {
        return maxonlinecount;
    }

    public void setMaxonlinecount(Integer maxonlinecount) {
        this.maxonlinecount = maxonlinecount;
    }

    public Integer getOnlinecountexpire() {
        return onlinecountexpire;
    }

    public void setOnlinecountexpire(Integer onlinecountexpire) {
        this.onlinecountexpire = onlinecountexpire;
    }

    public Integer getUpdateonlinetimespan() {
        return updateonlinetimespan;
    }

    public void setUpdateonlinetimespan(Integer updateonlinetimespan) {
        this.updateonlinetimespan = updateonlinetimespan;
    }

    public Integer getIsstatbrowser() {
        return isstatbrowser;
    }

    public void setIsstatbrowser(Integer isstatbrowser) {
        this.isstatbrowser = isstatbrowser;
    }

    public Integer getIsstatos() {
        return isstatos;
    }

    public void setIsstatos(Integer isstatos) {
        this.isstatos = isstatos;
    }

    public Integer getIsstatregion() {
        return isstatregion;
    }

    public void setIsstatregion(Integer isstatregion) {
        this.isstatregion = isstatregion;
    }

    //endregion

    //region 访问控制

    /**
     * 是否关闭项目(0代表打开，1代表关闭)
     */
    private Integer isclosed = 0;
    /**
     * 商城关闭原因
     */
    private String closereason = "";
    /**
     * 禁止访问时间
     */
    private String banaccesstime = "";
    /**
     * 禁止访问ip
     */
    private String banaccessip = "";
    /**
     * 允许访问ip
     */
    private String allowaccessip = "";
    /**
     * 后台允许访问ip
     */
    private String adminallowaccessip = "";
    /**
     * 密钥
     */
    private String secretkey = "12345678";
    /**
     * cookie的有效域
     */
    private String cookiedomain = "";
    /**
     * 随机库
     */
    private String randomlibrary = "";
    /**
     * 使用验证码的页面
     */
    private String verifypages = "";
    /**
     * 忽略词
     */
    private String ignorewords = "";
    /**
     * 允许的邮箱提供者
     */
    private String allowemailprovider = "";
    /**
     * 禁止的邮箱提供者
     */
    private String banemailprovider = "";

    public Integer getIsclosed() {
        return isclosed;
    }

    public void setIsclosed(Integer isclosed) {
        this.isclosed = isclosed;
    }

    public String getClosereason() {
        return closereason;
    }

    public void setClosereason(String closereason) {
        this.closereason = closereason;
    }

    public String getBanaccesstime() {
        return banaccesstime;
    }

    public void setBanaccesstime(String banaccesstime) {
        this.banaccesstime = banaccesstime;
    }

    public String getBanaccessip() {
        return banaccessip;
    }

    public void setBanaccessip(String banaccessip) {
        this.banaccessip = banaccessip;
    }

    public String getAllowaccessip() {
        return allowaccessip;
    }

    public void setAllowaccessip(String allowaccessip) {
        this.allowaccessip = allowaccessip;
    }

    public String getAdminallowaccessip() {
        return adminallowaccessip;
    }

    public void setAdminallowaccessip(String adminallowaccessip) {
        this.adminallowaccessip = adminallowaccessip;
    }

    public String getSecretkey() {
        return secretkey;
    }

    public void setSecretkey(String secretkey) {
        this.secretkey = secretkey;
    }

    public String getCookiedomain() {
        return cookiedomain;
    }

    public void setCookiedomain(String cookiedomain) {
        this.cookiedomain = cookiedomain;
    }

    public String getRandomlibrary() {
        return randomlibrary;
    }

    public void setRandomlibrary(String randomlibrary) {
        this.randomlibrary = randomlibrary;
    }

    public String getVerifypages() {
        return verifypages;
    }

    public void setVerifypages(String verifypages) {
        this.verifypages = verifypages;
    }

    public String getIgnorewords() {
        return ignorewords;
    }

    public void setIgnorewords(String ignorewords) {
        this.ignorewords = ignorewords;
    }

    public String getAllowemailprovider() {
        return allowemailprovider;
    }

    public void setAllowemailprovider(String allowemailprovider) {
        this.allowemailprovider = allowemailprovider;
    }

    public String getBanemailprovider() {
        return banemailprovider;
    }

    public void setBanemailprovider(String banemailprovider) {
        this.banemailprovider = banemailprovider;
    }


    //endregion


    public BaseConfigInfo() {
    }

    public BaseConfigInfo(String mallname, String siteurl, String sitetitle, String seokeyword, String seodescription, String icp, String script, Integer islicensed, String regtype, String reservedname, Integer regtimespan, Integer iswebcomemsg, String webcomemsg, String logintype, String shadowname, Integer isremember, Integer loginfailtimes, String uploadserver, String uploadimgtype, Integer uploadimgsize, String uploadfiletype, Integer uploadfilesize, Integer watermarktype, Integer watermarkquality, Integer watermarkposition, String watermarkimg, Integer watermarkimgopacity, String watermarktext, String watermarktextfont, Integer watermarktextsize, String imagecdn, String csscdn, String scriptcdn, Integer onlineuserexpire, Integer maxonlinecount, Integer onlinecountexpire, Integer updateonlinetimespan, Integer isstatbrowser, Integer isstatos, Integer isstatregion, Integer isclosed, String closereason, String banaccesstime, String banaccessip, String allowaccessip, String adminallowaccessip, String secretkey, String cookiedomain, String randomlibrary, String verifypages, String ignorewords, String allowemailprovider, String banemailprovider) {
        this.mallname = mallname;
        this.siteurl = siteurl;
        this.sitetitle = sitetitle;
        this.seokeyword = seokeyword;
        this.seodescription = seodescription;
        this.icp = icp;
        this.script = script;
        this.islicensed = islicensed;
        this.regtype = regtype;
        this.reservedname = reservedname;
        this.regtimespan = regtimespan;
        this.iswebcomemsg = iswebcomemsg;
        this.webcomemsg = webcomemsg;
        this.logintype = logintype;
        this.shadowname = shadowname;
        this.isremember = isremember;
        this.loginfailtimes = loginfailtimes;
        this.uploadserver = uploadserver;
        this.uploadimgtype = uploadimgtype;
        this.uploadimgsize = uploadimgsize;
        this.uploadfiletype = uploadfiletype;
        this.uploadfilesize = uploadfilesize;
        this.watermarktype = watermarktype;
        this.watermarkquality = watermarkquality;
        this.watermarkposition = watermarkposition;
        this.watermarkimg = watermarkimg;
        this.watermarkimgopacity = watermarkimgopacity;
        this.watermarktext = watermarktext;
        this.watermarktextfont = watermarktextfont;
        this.watermarktextsize = watermarktextsize;
        this.imagecdn = imagecdn;
        this.csscdn = csscdn;
        this.scriptcdn = scriptcdn;
        this.onlineuserexpire = onlineuserexpire;
        this.maxonlinecount = maxonlinecount;
        this.onlinecountexpire = onlinecountexpire;
        this.updateonlinetimespan = updateonlinetimespan;
        this.isstatbrowser = isstatbrowser;
        this.isstatos = isstatos;
        this.isstatregion = isstatregion;
        this.isclosed = isclosed;
        this.closereason = closereason;
        this.banaccesstime = banaccesstime;
        this.banaccessip = banaccessip;
        this.allowaccessip = allowaccessip;
        this.adminallowaccessip = adminallowaccessip;
        this.secretkey = secretkey;
        this.cookiedomain = cookiedomain;
        this.randomlibrary = randomlibrary;
        this.verifypages = verifypages;
        this.ignorewords = ignorewords;
        this.allowemailprovider = allowemailprovider;
        this.banemailprovider = banemailprovider;
    }


    @Override
    public String toString() {
        return "BaseConfigInfo{" + "mallname='" + mallname + '\'' + ", siteurl='" + siteurl + '\'' + ", sitetitle='" + sitetitle + '\'' + ", seokeyword='" + seokeyword + '\'' + ", seodescription='" + seodescription + '\'' + ", icp='" + icp + '\'' + ", script='" + script + '\'' + ", islicensed=" + islicensed + ", regtype='" + regtype + '\'' + ", reservedname='" + reservedname + '\'' + ", regtimespan=" + regtimespan + ", iswebcomemsg=" + iswebcomemsg + ", webcomemsg='" + webcomemsg + '\'' + ", logintype='" + logintype + '\'' + ", shadowname='" + shadowname + '\'' + ", isremember=" + isremember + ", loginfailtimes=" + loginfailtimes + ", uploadserver='" + uploadserver + '\'' + ", uploadimgtype='" + uploadimgtype + '\'' + ", uploadimgsize=" + uploadimgsize + ", uploadfiletype='" + uploadfiletype + '\'' + ", uploadfilesize=" + uploadfilesize + ", watermarktype=" + watermarktype + ", watermarkquality=" + watermarkquality + ", watermarkposition=" + watermarkposition + ", watermarkimg='" + watermarkimg + '\'' + ", watermarkimgopacity=" + watermarkimgopacity + ", watermarktext='" + watermarktext + '\'' + ", watermarktextfont='" + watermarktextfont + '\'' + ", watermarktextsize=" + watermarktextsize + ", imagecdn='" + imagecdn + '\'' + ", csscdn='" + csscdn + '\'' + ", scriptcdn='" + scriptcdn + '\'' + ", onlineuserexpire=" + onlineuserexpire + ", maxonlinecount=" + maxonlinecount + ", onlinecountexpire=" + onlinecountexpire + ", updateonlinetimespan=" + updateonlinetimespan + ", isstatbrowser=" + isstatbrowser + ", isstatos=" + isstatos + ", isstatregion=" + isstatregion + ", isclosed=" + isclosed + ", closereason='" + closereason + '\'' + ", banaccesstime='" + banaccesstime + '\'' + ", banaccessip='" + banaccessip + '\'' + ", allowaccessip='" + allowaccessip + '\'' + ", adminallowaccessip='" + adminallowaccessip + '\'' + ", secretkey='" + secretkey + '\'' + ", cookiedomain='" + cookiedomain + '\'' + ", randomlibrary='" + randomlibrary + '\'' + ", verifypages='" + verifypages + '\'' + ", ignorewords='" + ignorewords + '\'' + ", allowemailprovider='" + allowemailprovider + '\'' + ", banemailprovider='" + banemailprovider + '\'' + '}';
    }
}
