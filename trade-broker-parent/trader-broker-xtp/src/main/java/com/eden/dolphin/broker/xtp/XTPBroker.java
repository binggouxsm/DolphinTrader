package com.eden.dolphin.broker.xtp;


import com.eden.dolphin.core.broker.AbstractBroker;
import com.eden.dolphin.core.broker.request.CancelRequest;
import com.eden.dolphin.core.broker.request.OrderRequest;
import com.eden.dolphin.core.broker.request.SubscribeRequest;
import com.eden.dolphin.core.event.EventEngine;
import com.zts.xtp.quote.api.QuoteApi;

import java.util.Map;

public class XTPBroker extends AbstractBroker {

    private QuoteApi quoteApi;

    public XTPBroker(String name, EventEngine eventEngine) {
        super(name, eventEngine);
//        quoteApi = new QuoteApi()
    }



    @Override
    public void connect(Map<String, Object> settings) {



    }

    @Override
    public void close() {

    }

    @Override
    public void subscribe(SubscribeRequest request) {

    }

    @Override
    public String sendOrder(OrderRequest request) {
        return null;
    }

    @Override
    public void cancelOrder(CancelRequest request) {

    }
}
