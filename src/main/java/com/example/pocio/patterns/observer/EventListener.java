package com.example.pocio.patterns.observer;

import java.io.File;

public interface EventListener { //Observer
    void update(String eventType, File file);
}