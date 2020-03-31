package com.eden.dolphin.core.event;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class EventEngine implements Runnable{


    private BlockingQueue<Event> queue = new LinkedBlockingQueue<>();

    private Map<String, List<EventHandler>> handlerMapper = new HashMap<>();

    public void register(String eventType, EventHandler handler){
        List<EventHandler> handlers = handlerMapper.get(eventType);
        if(handlers == null){
            handlers = new LinkedList<EventHandler>();
            handlerMapper.put(eventType, handlers);
        }
        handlers.add(handler);
    }

    public void unregister(String eventType, EventHandler handler){
        List<EventHandler> handlers = handlerMapper.get(eventType);
        if(handlers != null){
            handlers.remove(handler);
        }
    }

    private void process(Event event){
        List<EventHandler> handlers = handlerMapper.get(event.getType());
        if(handlers != null)
            handlers.stream().forEach(handler-> handler.handle(event));

        handlers = handlerMapper.get(EventType.ALL.toString());
        if(handlers != null)
            handlers.stream().forEach(handler-> handler.handle(event));
    }

    @Override
    public void run() {
        while (true){
            Event event = null;
            try {
                event = queue.take();
                process(event);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    public void put(Event event){
        try {
            queue.put(event);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
