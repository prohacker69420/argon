package dev.lvstrng.argon.event.events;

import dev.lvstrng.argon.event.Event;
import dev.lvstrng.argon.event.EventListener;
import dev.lvstrng.argon.event.listeners.TickListener;

import java.util.ArrayList;

public class TickEvent extends Event {
    @Override
    public void callListeners(final ArrayList<EventListener> listeners) {
        System.out.println("call tick event: " + listeners.stream().map(l -> (l.getClass().getSimpleName() + "|" + (l instanceof TickListener))).toList());
        listeners.stream().filter(listener -> listener instanceof TickListener).map(listener -> (TickListener) listener).forEach(TickListener::onTick);
    }

    @Override
    public Class<?> getClazz() {
        return TickListener.class;
    }
}