package JavaOOP.L08SOLID.layouts;

import JavaOOP.L08SOLID.layouts.interfaces.Layout;

public class SimpleLayout implements Layout {
    @Override
    public String format(String dataTime,String reportLevel,String message) {
        return String.format("%s - %s - %s",dataTime,reportLevel,message);
    }
}
