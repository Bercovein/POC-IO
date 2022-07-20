package com.example.pocio.patterns.observer;

import javax.security.auth.Subject;
import java.io.File;

public interface IEventManager { //Subject

    void subscribe(String eventType, EventListener listener);
    void unsubscribe(String eventType, EventListener listener);
    void notify(String eventType, File file);
}
