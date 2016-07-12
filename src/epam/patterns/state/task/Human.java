package epam.patterns.state.task;

/**
 * Created by Сергей on 24.05.2016.
 */
// Context
public class Human {
    Place place;

    public void doSomething() {
        place.doSomething(this);
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    void printActivity(){}
}

class Fisher extends Human {

    void printActivity() {
        System.out.println("I am fisher");
    }
}

class Mushroomer extends Human {

    void printActivity() {
        System.out.println("I am mushroomer");
    }
}

class Hunter extends Human {

    void printActivity() {
        System.out.println("I am hunter");
    }
}

// State
interface Place {
    void doSomething(Human context);
}

class Riverside implements Place {

    @Override
    public void doSomething(Human context) {
        context = new Fisher();
        System.out.println("At the river");
        context.printActivity();
    }
}

class MushroomField implements Place {

    @Override
    public void doSomething(Human context) {
        context = new Mushroomer();
        System.out.println("At the mushroom field");
        context.printActivity();
    }
}

class NearBeast implements Place {

    @Override
    public void doSomething(Human context) {
        context = new Hunter();
        System.out.println("Near the beast");
        context.printActivity();
    }
}
