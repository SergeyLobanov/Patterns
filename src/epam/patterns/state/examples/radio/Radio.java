package epam.patterns.state.examples.radio;

/**
 * Created by Сергей on 24.05.2016.
 */
// Context
public class Radio {
    Station station;

    public void setStation(Station station) {
        this.station = station;
    }

    public void nextStation() { //
        if (station instanceof Radio7) {
            setStation(new RadioFM());
        } else if (station instanceof RadioFM) {
            setStation(new RadioRox());
        } else if (station instanceof RadioRox) {
            setStation(new Radio7());
        }
    }

    public void play() {
        station.play();
    }
}

// State
interface Station {
    void play();
}

class Radio7 implements Station {

    @Override
    public void play() {
        System.out.println("Radio 7 is playing");
    }
}

class RadioFM implements Station {

    @Override
    public void play() {
        System.out.println("Radio FM is playing");
    }
}

class RadioRox implements Station {

    @Override
    public void play() {
        System.out.println("Radio Rox is playing");
    }
}
