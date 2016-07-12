package epam.patterns.strategy.task;

import java.util.List;
import java.util.LinkedList;

public class StrategyMain {
    public static void main(String[] args) {
        Human human = new Human();
        human.setPlace(new NearBeast());
        human.doSomething();
        human.addPlace(new Riverside());
        human.doSomething();
        human.setPlace(new MushroomField());
        human.addPlace(new Riverside());
        human.doSomething();
    }
}
// Context
class Human {
    private List<Place> places;

    public void doSomething() {
		for (Place place : places) {
			place.doSomething(this);
		}
    }

    public void setPlace(Place place) {
		this.places = new LinkedList<>();
        this.places.add(place);
    }
	
	public void addPlace(Place place) {
		if (places == null) {
			this.places = new LinkedList<>();			
		}
		this.places.add(place);
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