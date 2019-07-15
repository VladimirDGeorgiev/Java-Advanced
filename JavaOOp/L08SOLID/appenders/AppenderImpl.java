package JavaOOP.L08SOLID.appenders;

import JavaOOP.L08SOLID.appenders.interfaces.Appender;
import JavaOOP.L08SOLID.enumerations.ReportLevel;
import JavaOOP.L08SOLID.layouts.interfaces.Layout;

public abstract class AppenderImpl implements Appender {
    private Layout layout;
    private ReportLevel reportLevel;
    private int messagesAppended ;

    public AppenderImpl(Layout layout) {
        this.layout = layout;
        this.reportLevel=ReportLevel.INFO;
        this.messagesAppended = 0;
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel= reportLevel;

    }

    public Layout getLayout() {
        return layout;
    }

    public ReportLevel getReportLevel() {
        return reportLevel;
    }

    public int getMessagesAppended() {
        return messagesAppended;
    }

    public void setMessagesAppended(int messagesAppended) {
        this.messagesAppended += messagesAppended;
    }
}
