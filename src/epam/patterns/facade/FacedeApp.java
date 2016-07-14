package epam.patterns.facade;

/**
 * Created by Сергей on 14.07.2016.
 */
public class FacedeApp {

    public static void main(String[] args) {

//        Power power = new Power();
//        power.on();
//
//        DVDRom dvdRom = new DVDRom();
//        dvdRom.load();
//        dvdRom.unload();
//
//        HDD hdd = new HDD();
//        hdd.copyFromDVD(dvdRom);

        Computer computer = new Computer();
        computer.copy();
    }
}

//facade class
class Computer {
    Power power = new Power();
    DVDRom dvdRom = new DVDRom();
    HDD hdd = new HDD();

    public void copy() {
        power.on();
        dvdRom.load();
        hdd.copyFromDVD(dvdRom);
    }
}

class Power {

    public void on() {
        System.out.println("Power on");
    }

    public void off() {
        System.out.println("Power off");
    }
}

class DVDRom {
    private boolean data = false;

    public boolean hasData() {
        return data;
    }

    public void load() {
        data = true;
    }

    public void unload() {
        data = false;
    }
}

class HDD {

    public void copyFromDVD(DVDRom dvdRom) {
        if (dvdRom.hasData()) {
            System.out.println("Coping");
        } else {
            System.out.println("No dvd rom");
        }
    }
}
