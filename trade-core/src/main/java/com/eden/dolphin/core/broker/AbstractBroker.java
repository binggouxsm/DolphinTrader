package com.eden.dolphin.core.broker;

import com.eden.dolphin.core.broker.request.CancelRequest;
import com.eden.dolphin.core.broker.request.OrderRequest;
import com.eden.dolphin.core.broker.request.SubscribeRequest;
import com.eden.dolphin.core.entity.*;
import com.eden.dolphin.core.event.Event;
import com.eden.dolphin.core.event.EventEngine;
import com.eden.dolphin.core.event.EventType;


import java.util.Map;

public abstract class AbstractBroker implements Broker{

    protected String name;

    protected EventEngine eventEngine;

    public AbstractBroker(String name, EventEngine eventEngine) {
        this.name = name;
        this.eventEngine = eventEngine;
    }

    public void pushEvent(String type, Object data){
        eventEngine.put(new Event(type, data));
    }

    public void onTick(Tick data){
        pushEvent(EventType.TICK.toString(), data);
        pushEvent(EventType.TICK.toString() + data.getVTSymbol(), data);
    }

    public void onTrade(Trade data){
        pushEvent(EventType.TRADE.toString(), data);
        pushEvent(EventType.TRADE + data.getVTSymbol(), data);
    }

    public void onOrder(Order data) {
        pushEvent(EventType.ORDER.toString(), data);
        pushEvent(EventType.ORDER + data.getVTSymbol(), data);
    }

    public void onPosition(Position data){
        pushEvent(EventType.POSITION.toString(), data);
        pushEvent(EventType.POSITION + data.getVTSymbol(), data);
    }

    public void onAccount(Account data) {
        pushEvent(EventType.ACCOUNT.toString(), data);
        pushEvent(EventType.ACCOUNT + name + "." + data.getAccountId(), data);
    }


    @Override
    public abstract void connect(Map<String, String> settings);

    @Override
    public abstract void close();

    @Override
    public abstract void subscribe(SubscribeRequest request);

    @Override
    public abstract String sendOrder(OrderRequest request);

    @Override
    public abstract void cancelOrder(CancelRequest request);

    @Override
    public void queryBar() {

    }

    @Override
    public void queryAccount() {

    }

    @Override
    public void queryPosition() {

    }
}
