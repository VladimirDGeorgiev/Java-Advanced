package JavaOOP.L08SOLID.logger.interfaces;

import JavaOOP.L08SOLID.appenders.interfaces.Appender;

import java.util.List;

public interface Logger {
    void logError(String dateTime, String message);

    void logInfo(String dateTime, String message);

    void logFatal(String dateTime, String message);

    void logCritical(String dateTime, String message);

    void logWarning(String dateTime, String message);

    List<Appender> getAppenders();
}
