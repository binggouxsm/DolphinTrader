package com.eden.dolphin.core.event;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventEngineTest {

    @Autowired
    private EventEngine engine;

    @Before
    public void init(){
        for (int i = 0; i < 10; i++) {
            Event e1 = new Event("EventA", "EventA-"+i);

            Event e2 = new Event("EventB", "EventB-"+i);
            engine.put(e1);
            engine.put(e2);
        }
    }

    @Test
    public void testHandler(){
        engine.register("EventA",new HandlerA());
        engine.register("EventB",new HandlerB());
        engine.register(EventType.ALL.toString(),new HandlerC());

        new Thread(engine).start();
    }

}


class HandlerB implements EventHandler{

    @Override
    public void handle(Event e) {
        System.out.println("handlerB process"+e.getData());
    }
}

class HandlerA implements EventHandler{

    @Override
    public void handle(Event e) {
        System.out.println("handlerA process"+e.getData());
    }
}

class HandlerC implements EventHandler{

    @Override
    public void handle(Event e) {
        System.out.println("handlerC process"+e.getData());
    }
}