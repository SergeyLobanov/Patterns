package epam.patterns.delegate;

/**
 * Created by Сергей on 14.07.2016.
 */
public class DelegateApp {
    public static void main(String[] args) {

        Painter painter = new Painter();
        painter.setGraphics(new Circle());
        painter.draw();//Circle

        painter.setGraphics(new Square());
        painter.draw();//Square

    }
}

interface Graphics {
    void draw();
}

class Triangle implements Graphics {

    @Override
    public void draw() {
        System.out.println("Triangle");
    }
}

class Square implements Graphics {

    @Override
    public void draw() {
        System.out.println("Square");
    }
}

class Circle implements Graphics {

    @Override
    public void draw() {
        System.out.println("Circle");
    }
}

class Painter {
    private Graphics graphics;

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public void draw() {
        graphics.draw();
    }
}