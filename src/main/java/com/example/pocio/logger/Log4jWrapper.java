package com.example.pocio.logger;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.SimpleMessage;
import org.apache.logging.log4j.spi.ExtendedLogger;
import org.apache.logging.log4j.spi.ExtendedLoggerWrapper;

class Log4jWrapper implements Log {

    private static final String WRAP_CLASS_NAME = Log4jWrapper.class.getName();
    private ExtendedLoggerWrapper log;

    public Log4jWrapper(Class<?> clazz) {
        Logger logger = LogManager.getLogger(clazz);
        log = new ExtendedLoggerWrapper((ExtendedLogger) logger,
                logger.getName(), logger.getMessageFactory());
    }

    public boolean isInfoEnabled() {
        return log.isInfoEnabled();
    }

    public void info(String str) {
        log.logIfEnabled(WRAP_CLASS_NAME, Level.INFO, null, (CharSequence) new SimpleMessage(str), null);
    }

    public void info(String str, Throwable t) {
        log.logIfEnabled(WRAP_CLASS_NAME, Level.INFO, null, (CharSequence) new SimpleMessage(str), t);
    }

}