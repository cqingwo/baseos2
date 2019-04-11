package com.cqwo.base.core.wechat;


import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.EntPayService;

public interface IWechatPayStrategy {


    /**
     * 获取支付服务
     *
     * @return
     */
    EntPayService getEntPayService();


    /**
     * 配置参数,预留
     *
     * @return
     */
    boolean setConfig();

    /**
     * 创建订单
     *
     * @param orderRequest
     * @return
     */
    <T> T createOrder(WxPayUnifiedOrderRequest orderRequest) throws WxPayException;

    /**
     * 解析回调
     *
     * @param xmlResult
     * @return
     */
    WxPayOrderNotifyResult parseOrderNotifyResult(String xmlResult) throws WxPayException;
}
