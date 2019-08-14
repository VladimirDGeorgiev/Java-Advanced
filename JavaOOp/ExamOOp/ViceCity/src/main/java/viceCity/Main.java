package viceCity;

import viceCity.core.ControllerImpl;
import viceCity.core.EngineImpl;
import viceCity.core.interfaces.Controller;
import viceCity.core.interfaces.Engine;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Rifle;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl(); // TODO
        Engine engine = new EngineImpl(controller);
        engine.run();


    }
}
