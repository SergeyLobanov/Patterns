package epam.patterns.flyweight.example;

import java.util.List;
import java.util.ArrayList;

public class FlyweightApp {
	
	public static void main(String[] args) {
		
		ShapeFactory shapeFactory = new ShapeFactory();
		
		List<Shape> shapes = new ArrayList<>();
		
		shapes.add(shapeFactory.getShape("square"));
		shapes.add(shapeFactory.getShape("circle"));
		shapes.add(shapeFactory.getShape("circle"));
		shapes.add(shapeFactory.getShape("point"));
		shapes.add(shapeFactory.getShape("square"));
		shapes.add(shapeFactory.getShape("circle"));
		
		Random rand = new Random();
		for (Shape shape : shapes) {
			int x = rand.nextInt(100);
			int x = rand.nextInt(100);
			shape.draw(x, y);
		}
	}
}

//Flyweight
interface Shape {
	void draw(int x, int y);
}

//Point Flyweight
class Point implements Shape {
	public void draw(int x, int y) {
		System.out.println("x " + x + ",y " + y + " point");
	}
}

//Circle Flyweight
class Circle implements Shape {
	int radius = 5;
	
	public void draw(int x, int y) {
		System.out.println("x " + x + ",y " + y + " circle radius = " + radius);
	}
}

//Square Flyweight
class Square implements Shape {
	int edge = 10;
	
	public void draw(int x, int y) {
		System.out.println("x " + x + ",y " + y + " square edge = " + edge);
	}
}

class ShapeFactory {
	private static final Map<String, Shape> shapes = new HashMap<>();
	
	public Shape getShape(Sting shapeName) {
		Shape shape = shapes.get(shapeName);
		
		if (shape == null) {
			switch (shapeName) {
				case "point" :
					shape = new Point();
					break;
				case "circle" :
					shape = new Circle();
					break;
				case "square" :
					shape = new Square();
					break;
			}
			shape.put(shapeName, shape);
		}
		
		return shape;
	}
}

