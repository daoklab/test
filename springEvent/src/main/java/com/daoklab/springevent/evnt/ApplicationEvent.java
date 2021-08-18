package com.daoklab.springevent.evnt;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.EventObject;

/**
 * @Project: test
 * @Pacakge: com.daoklab.springevent
 * @Author: liuxianglin
 * @Description: TODO
 * @Date: Created in 12:56 2021/7/24
 */
public class ApplicationEvent extends EventObject {

    private final long timestamp = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

}
