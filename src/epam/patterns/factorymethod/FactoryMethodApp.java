package epam.patterns.factorymethod;

import java.util.Date;

/**
 * Created by Сергей on 6/21/2016.
 */
public class FactoryMethodApp {

    public static void main(String[] args) {
        //without pattern
        Watch watch = new DigitalWatch();
        watch.showTime();

        //with pattern
        //WatchCreator creator = new DigitalWatchCreator();
        WatchCreator creator = new RomeWatchCreator();

        Watch watch1 = creator.createWatch();
        watch1.showTime();
    }
}

interface Watch {
    void showTime();
}

class DigitalWatch implements Watch{

    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch{

    @Override
    public void showTime() {
        System.out.println("VII-XX");
    }
}

interface WatchCreator {
    Watch createWatch();
}

class DigitalWatchCreator implements WatchCreator {

    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}


class RomeWatchCreator implements WatchCreator {

    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}
