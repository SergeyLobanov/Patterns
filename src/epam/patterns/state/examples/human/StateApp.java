package epam.patterns.state.examples.human;

/**
 * Created by Сергей on 24.05.2016.
 */
public class StateApp {
    public static void main(String[] args) {
        Human human = new Human();
        human.setState(new Work());
        for (int i = 0; i < 20; i++) {
            //System.out.println(i); //any 5th iteration are empty
            human.doSomething();
        }
    }
}
