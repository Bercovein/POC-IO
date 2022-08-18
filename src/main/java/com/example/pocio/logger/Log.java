package com.example.pocio.logger;

public interface Log {

    boolean isInfoEnabled();
    void info(String str);
    void info(String str, Throwable t);

}