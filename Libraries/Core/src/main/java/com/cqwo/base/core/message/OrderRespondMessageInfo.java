package com.cqwo.base.core.message;

/**
 * Created by mayn on 2018/1/26.
 */

/**
 * 订单消息回调
 */
public class OrderRespondMessageInfo {

    /**
     * 订单id
     */
    Integer oid = -1;

    /**
     * 机器id
     */
    Integer machId = 0;

    /**
     * 订单状态
     */
    Integer state = 0;

    public OrderRespondMessageInfo() {
    }

    public OrderRespondMessageInfo(Integer oid, Integer machId, Integer state) {
        this.oid = oid;
        this.machId = machId;
        this.state = state;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getMachId() {
        return machId;
    }

    public void setMachId(Integer machId) {
        this.machId = machId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "OrderRespondMessageInfo{" +
                "oid=" + oid +
                ", machId=" + machId +
                ", state=" + state +
                '}';
    }
}
