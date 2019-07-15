package JavaOOP.L08SOLID.layouts;

import JavaOOP.L08SOLID.layouts.interfaces.Layout;

public class XmlLayout implements Layout {
    @Override
    public String format(String dataTime, String reportLevel, String message) {
        return String.format("<log>%n" +
                "   <date>%s</date>%n" +
                "   <level>%s</level>%n" +
                "   <message>%s</message>%n" +
                "</log>", dataTime, reportLevel, message);
    }
}
