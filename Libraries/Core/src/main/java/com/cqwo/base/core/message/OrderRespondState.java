package com.cqwo.base.core.message;

/**
 * Created by mayn on 2018/1/26.
 */

public enum OrderRespondState {

    Complete(1, "成功"), Error(0, "失败");


    private Integer index;

    private String name;

    OrderRespondState(Integer index, String name) {
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
     * 获取枚举名称
     *
     * @param index
     * @return
     */
    public String getName(Integer index) {
        OrderRespondState[] respondStates = OrderRespondState.values();
        for (OrderRespondState orderRespondState : respondStates) {

            if (index.equals(orderRespondState.getIndex())) {
                return orderRespondState.getName();
            }
        }

        return null;
    }

    /**
     * 获取枚举名称
     *
     * @param index
     * @return
     */
    public OrderRespondState getOrderRespondState(Integer index) {
        OrderRespondState[] respondStates = OrderRespondState.values();
        for (OrderRespondState orderRespondState : respondStates) {

            if (index.equals(orderRespondState.getIndex())) {
                return orderRespondState;
            }
        }

        return null;
    }


    @Override
    public String toString() {
        return "OrderRespondState{" +
                "index=" + index +
                ", name='" + name + '\'' +
                '}';
    }
}
