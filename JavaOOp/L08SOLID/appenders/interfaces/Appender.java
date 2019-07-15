package JavaOOP.L08SOLID.appenders.interfaces;


import JavaOOP.L08SOLID.enumerations.ReportLevel;

public interface Appender {
    void append(String dateTime, String message,String reportLevel);

    void setReportLevel(ReportLevel reportLevel);
}
