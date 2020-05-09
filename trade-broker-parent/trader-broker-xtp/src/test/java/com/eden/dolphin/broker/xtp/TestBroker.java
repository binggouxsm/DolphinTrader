package com.eden.dolphin.broker.xtp;

import com.eden.dolphin.core.broker.request.SubscribeRequest;
import com.eden.dolphin.core.entity.enums.Exchange;
import com.eden.dolphin.core.event.EventEngine;

import java.util.HashMap;

public class TestBroker {

    public static void main(String[] args) {
        EventEngine engine = new EventEngine();
        XTPBroker broker = new XTPBroker("xtp",engine);

        broker.connect(new HashMap<>());
        broker.subscribe(new SubscribeRequest("300498", Exchange.HUOBI));
        try {
            Thread.sleep(500000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
