package epam.patterns.state.task;

/**
 * Created by Сергей on 24.05.2016.
 */
public class StateMain {
    public static void main(String[] args) {
        Human human = new Human();
        human.setPlace(new NearBeast());
        human.doSomething();
        human.setPlace(new Riverside());
        human.doSomething();
        human.setPlace(new MushroomField());
        human.doSomething();
    }
}
