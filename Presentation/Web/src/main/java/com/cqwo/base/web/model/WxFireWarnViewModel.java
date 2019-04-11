package com.cqwo.base.web.model;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

public class WxFireWarnViewModel {

    /**
     * ("报警地址")
     */
    @NotNull()
    @Range(min = 1, max = 999)
    private String address = "";

    /**
     * ("经度")
     */
    private String lng;

    /**
     * ("纬度")
     */
    private String lat;

    /**
     * ("报警人电话")
     */
    private String user_phone;

    /**
     * ("报警人姓名")
     */
    private String user_name;

    /**
     * ("报警时间")
     */
    private Integer create_date;

    /**
     * ("open_id")
     */
    private String open_id;

    /**
     * ("举报类型（1:林火火情，2:侵占林地,3:滥砍滥发，4:病虫害情，5:盗捕滥猎，6:其他）")
     */
    private Integer warn_type;

    /**
     * ("举报内容")
     */
    private String content;

    /**
     * (图片地址)
     */
    private String warn_photo_url;

    /**
     * (语音地址)
     */
    private String warn_video_url;

    /**
     * (高德编码)
     */
    private String gd_code;

    public WxFireWarnViewModel() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Integer create_date) {
        this.create_date = create_date;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public Integer getWarn_type() {
        return warn_type;
    }

    public void setWarn_type(Integer warn_type) {
        this.warn_type = warn_type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWarn_photo_url() {
        return warn_photo_url;
    }

    public void setWarn_photo_url(String warn_photo_url) {
        this.warn_photo_url = warn_photo_url;
    }

    public String getWarn_video_url() {
        return warn_video_url;
    }

    public void setWarn_video_url(String warn_video_url) {
        this.warn_video_url = warn_video_url;
    }

    public String getGd_code() {
        return gd_code;
    }

    public void setGd_code(String gd_code) {
        this.gd_code = gd_code;
    }

    @Override
    public String toString() {
        return "WxFireWarnViewModel{" +
                "address='" + address + '\'' +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_name='" + user_name + '\'' +
                ", create_date=" + create_date +
                ", open_id='" + open_id + '\'' +
                ", warn_type=" + warn_type +
                ", content='" + content + '\'' +
                ", warn_photo_url='" + warn_photo_url + '\'' +
                ", warn_video_url='" + warn_video_url + '\'' +
                ", gd_code='" + gd_code + '\'' +
                '}';
    }


    public Map<String, Object> toHasMap() {

        Map<String, Object> map = new HashMap<>();
        map.put("address", address);


        return map;

    }
}
