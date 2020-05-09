package com.eden.dolphin.core.broker;

import com.eden.dolphin.core.broker.request.CancelRequest;
import com.eden.dolphin.core.broker.request.OrderRequest;
import com.eden.dolphin.core.broker.request.SubscribeRequest;

import java.util.Map;

public interface Broker {

    public void connect(Map<String,String> settings);

    public void close();

    /**
     * 采集各类信息 Tick, Order, Trade等等
     * @param request
     */
    public void subscribe(SubscribeRequest request);

    public String sendOrder(OrderRequest request);

    public void cancelOrder(CancelRequest request);

    public void queryBar();

    public void queryAccount();

    public void queryPosition();


}
