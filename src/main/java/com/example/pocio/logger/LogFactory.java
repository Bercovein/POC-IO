package com.example.pocio.logger;

public class LogFactory {

    public static Log getLog(Class<?> clazz) {
        return new Log4jWrapper(clazz);
    }


}