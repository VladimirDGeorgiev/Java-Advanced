package JavaOOP.L08SOLID.appenders;

import JavaOOP.L08SOLID.enumerations.ReportLevel;
import JavaOOP.L08SOLID.layouts.interfaces.Layout;

public class ConsoleAppender extends AppenderImpl {


    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String dateTime, String message, String reportLevel) {
        if (ReportLevel.valueOf(reportLevel).getValue()>=this.getReportLevel().getValue()) {
            System.out.println(this.getLayout().format(dateTime, reportLevel, message));
            this.setMessagesAppended(1);
        }
    }



    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d"
        ,this.getClass().getSimpleName()
        ,this.getLayout().getClass().getSimpleName()
        ,this.getReportLevel().toString()
        ,this.getMessagesAppended());
    }
}
