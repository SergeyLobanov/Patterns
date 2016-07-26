package epam.patterns.command;

/**
 * Created by Сергей on 26.07.2016.
 */
public class CommandApp {

    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User(new StartCommand(computer),
                new StopCommand(computer), new ResetCommand(computer));
        user.startComputer();
        user.stopComputer();
        user.sresetComputer();
    }
}

class Computer {

    void start() {
        System.out.println("Start");
    }
    void stop() {
        System.out.println("Stop");
    }
    void reset() {
        System.out.println("Reset");
    }
}
//command
interface Command {
    void execute();
}

//concrete command
class StartCommand implements Command {
    private Computer computer;

    public StartCommand(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.start();
    }
}

class StopCommand implements Command {
    private Computer computer;

    public StopCommand(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.stop();
    }
}

class ResetCommand implements Command {
    private Computer computer;

    public ResetCommand(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.reset();
    }
}

class User {
    private Command start;
    private Command stop;
    private Command reset;

    public User(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }

    void startComputer() {
        start.execute();
    }

    void stopComputer() {
        stop.execute();
    }

    void sresetComputer() {
        reset.execute();
    }
}
