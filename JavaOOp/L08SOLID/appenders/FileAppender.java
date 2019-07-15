package JavaOOP.L08SOLID.appenders;

import JavaOOP.L08SOLID.customFile.LogFile;
import JavaOOP.L08SOLID.enumerations.ReportLevel;
import JavaOOP.L08SOLID.customFile.interfaces.CustomFile;
import JavaOOP.L08SOLID.customFile.interfaces.File;
import JavaOOP.L08SOLID.layouts.interfaces.Layout;

import java.io.IOException;

public class FileAppender extends AppenderImpl implements   CustomFile {

    private File file;

    public FileAppender(Layout layout) throws IOException {
        super(layout);
        this.file = new LogFile();
    }


    @Override
    public void append(String dateTime, String message, String reportLevel) {
        if (ReportLevel.valueOf(reportLevel).getValue()>=this.getReportLevel().getValue()) {
            String format = this.getLayout().format(dateTime, reportLevel, message);
            this.file.write(format);
            this.setMessagesAppended(1);
        }
    }



    public File getFile() {
        return file;
    }

    @Override
    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d, File size: %d"
                ,this.getClass().getSimpleName()
                ,this.getLayout().getClass().getSimpleName()
                ,this.getReportLevel().toString()
                ,this.getMessagesAppended()
        ,this.file.size());
    }
}
