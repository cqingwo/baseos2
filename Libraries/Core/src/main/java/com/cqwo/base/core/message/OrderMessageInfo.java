package com.cqwo.base.core.message;

import java.math.BigDecimal;

/**
 * Created by mayn on 2018/1/26.
 */

public class OrderMessageInfo {


    /**
     * 订单号
     **/
    private Integer oid = 0;

    /**
     * 订单编号
     */
    private String osn = "";


    /**
     * 用户
     **/
    private Integer uid = 0;

    /**
     * 机器唯一Id
     **/
    private Integer machId = 0;
    /**
     * 机器唯一编码
     **/
    private String serialNumber = "";

    /**
     * 订单状态
     */
    private Integer orderState = 1;


    /**
     * 机器支付模式
     **/
    private Integer payMode;

    /**
     * 订单合计
     **/
    private double recordAmount = 0;

    /**
     * 订单合计
     **/
    private double orderAmount = 0;

    /**
     * 支付金额
     **/
    private double surplusMoney = 0;


    public OrderMessageInfo() {

    }

    public OrderMessageInfo(Integer oid) {
        this.oid = oid;
    }

    public OrderMessageInfo(Integer machId, Integer orderState, Integer payMode, double surplusMoney) {
        this.machId = machId;
        this.orderState = orderState;
        this.payMode = payMode;
        this.orderAmount = surplusMoney;
        this.recordAmount = surplusMoney;
        this.surplusMoney = surplusMoney;
    }

    public OrderMessageInfo(Integer oid, String osn, Integer uid, Integer machId, String serialNumber, Integer orderState, Integer payMode, double recordAmount, double orderAmount, double surplusMoney) {
        this.oid = oid;
        this.osn = osn;
        this.uid = uid;
        this.machId = machId;
        this.serialNumber = serialNumber;
        this.orderState = orderState;
        this.payMode = payMode;
        this.recordAmount = recordAmount;
        this.orderAmount = orderAmount;
        this.surplusMoney = surplusMoney;
    }


    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getOsn() {
        return osn;
    }

    public void setOsn(String osn) {
        this.osn = osn;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getMachId() {
        return machId;
    }

    public void setMachId(Integer machId) {
        this.machId = machId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Integer getPayMode() {
        return payMode;
    }

    public void setPayMode(Integer payMode) {
        this.payMode = payMode;
    }

    public double getRecordAmount() {
        return recordAmount;
    }

    public void setRecordAmount(double recordAmount) {
        this.recordAmount = recordAmount;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public double getSurplusMoney() {
        return surplusMoney;
    }

    public void setSurplusMoney(double surplusMoney) {
        this.surplusMoney = surplusMoney;
    }

    @Override
    public String toString() {
        return "OrderMessageInfo{" +
                "oid=" + oid +
                ", osn='" + osn + '\'' +
                ", uid=" + uid +
                ", machId=" + machId +
                ", serialNumber='" + serialNumber + '\'' +
                ", orderState=" + orderState +
                ", payMode=" + payMode +
                ", recordAmount=" + recordAmount +
                ", orderAmount=" + orderAmount +
                ", surplusMoney=" + surplusMoney +
                '}';
    }
}
