package JavaOOP.L08SOLID;

import JavaOOP.L08SOLID.appenders.ConsoleAppender;
import JavaOOP.L08SOLID.appenders.FileAppender;
import JavaOOP.L08SOLID.appenders.interfaces.Appender;
import JavaOOP.L08SOLID.enumerations.ReportLevel;
import JavaOOP.L08SOLID.layouts.SimpleLayout;
import JavaOOP.L08SOLID.layouts.XmlLayout;
import JavaOOP.L08SOLID.layouts.interfaces.Layout;
import JavaOOP.L08SOLID.logger.MessageLogger;
import JavaOOP.L08SOLID.logger.interfaces.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine());
    Appender[] appenders = new Appender[n];

    for (int i = 0; i < n; i++) {
        String[] tokens = reader.readLine().split("\\s+");
        Appender appender = null;

        Layout layout = null;

        if (tokens[1].equalsIgnoreCase("SimpleLayout")){
            layout = new SimpleLayout();
        }else{
            layout = new XmlLayout();
        }
        if (tokens[0].equalsIgnoreCase("ConsoleAppender")){
            appender = new ConsoleAppender(layout);
        }else {
            appender = new FileAppender(layout);
        }

        if (tokens.length==3){
            appender.setReportLevel(ReportLevel.valueOf(tokens[2]));
        }
        appenders[i] = appender;
    }

    Logger logger = new MessageLogger(appenders);

        String message = "";
        while (!"END".equals(message= reader.readLine())){
            String[] tokens = message.split("\\|+");

            switch (ReportLevel.valueOf(tokens[0])){
                case INFO:
                    logger.logInfo(tokens[1],tokens[2]);
                    break;
                case ERROR:
                    logger.logError(tokens[1],tokens[2]);
                    break;
                case FATAL:
                    logger.logFatal(tokens[1],tokens[2]);
                    break;
                case WARNING:
                    logger.logWarning(tokens[1],tokens[2]);
                    break;
                case CRITICAL:
                    logger.logCritical(tokens[1],tokens[2]);
                    break;
                    default:
                        break;
            }
        }
        System.out.println("Logger info");
        logger.getAppenders().forEach(e-> System.out.println(e.toString()));

    }
}
