package JavaOOP.L08SOLID.logger;

import JavaOOP.L08SOLID.appenders.interfaces.Appender;
import JavaOOP.L08SOLID.logger.interfaces.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MessageLogger implements Logger {
    private List<Appender> appenders;


    public MessageLogger(Appender... appender) {
        this.appenders = new ArrayList<>();
        appenders.addAll(Arrays.asList(appender));
    }

    public List<Appender> getAppenders() {
        return Collections.unmodifiableList(this.appenders);
    }

    @Override
    public void logError(String dateTime, String message) {
        appendCollection(dateTime, message, "ERROR");
    }

    @Override
    public void logInfo(String dateTime, String message) {
        appendCollection(dateTime, message, "INFO");
    }


    @Override
    public void logFatal(String dateTime, String message) {
        appendCollection(dateTime, message, "FATAL");
    }

    @Override
    public void logCritical(String dateTime, String message) {
        appendCollection(dateTime, message, "CRITICAL");
    }

    @Override
    public void logWarning(String dateTime, String message) {
        appendCollection(dateTime, message, "WARNING");
    }

    private void appendCollection(String dateTime, String message, String info) {
        this.appenders.forEach(e -> e.append(dateTime, message, info));
    }
}
