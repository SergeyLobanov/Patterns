package epam.patterns.state.examples.human;

/**
 * Created by Сергей on 24.05.2016.
 */
// Context
public class Human {
    Activity state;

    public void setState(Activity state) {
        this.state = state;
    }

    public void doSomething() {
        state.doSomething(this);
    }

}

// State
interface Activity {
    void doSomething(Human context);
}

class Work implements Activity {

    @Override
    public void doSomething(Human context) {
        System.out.println("I am working");
        context.setState(new Weekend()); // state changes context
    }
}

class Weekend implements Activity {
    int count = 0;

    @Override
    public void doSomething(Human context) {
        if (count < 3) {
            System.out.println("Legal weekends");
            count++;
        } else {
            context.setState(new Work()); //set state Work and do nothing
        }
    }
}