package epam.patterns.state.examples.radio;

/**
 * Created by Сергей on 24.05.2016.
 */
public class StateApp {
    public static void main(String[] args) {
        Radio radio = new Radio();
        radio.setStation(new Radio7());
        for (int i = 0; i < 10; i++) {
            radio.play();
            radio.nextStation();
        }
    }
}
