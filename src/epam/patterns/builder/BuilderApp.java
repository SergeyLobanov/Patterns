package epam.patterns.builder;

public class BuilderApp {
	
	public static void main(String[] args) {
//		Car car = new CarBuilder()
//				.buildMake("BMV")
//				.buildMaxSpeed(200)
//				.build();
//		System.out.println(car);

		Director director = new Director();
		director.setCarBuilder(new FordBuilder());
		Car car = director.buildCar();
		System.out.println(car);
	}
}

enum Transmission {
	MANUAL, AUTO
}

class Car {
	private String make;
	private Transmission transmission;
	private int maxSpeed;
	
	public void setMake(String make) {
		this.make = make;
	}

	public void setTransmission(Transmission transmission) {
		this.transmission = transmission;
	}
	
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	@Override
	public String toString() {
		return "Car{" +
				"make='" + make + '\'' +
				", transmission=" + transmission +
				", maxSpeed=" + maxSpeed +
				'}';
	}
}

abstract class CarBuilder {
	protected Car car;

	public void createCar() {
		this.car = new Car();
	}

	public abstract void buildMake();

	public abstract void buildTransmission();

	public abstract void buildMaxSpeed();

	public Car getCar() {
		return car;
	}
}

class MercedesBuilder extends CarBuilder {

	@Override
	public void buildMake() {
		car.setMake("Mercedes");
	}

	@Override
	public void buildTransmission() {
		car.setTransmission(Transmission.AUTO);
	}

	@Override
	public void buildMaxSpeed() {
		car.setMaxSpeed(300);
	}
}

class FordBuilder extends CarBuilder {

	@Override
	public void buildMake() {
		car.setMake("Ford");
	}

	@Override
	public void buildTransmission() {
		car.setTransmission(Transmission.MANUAL);
	}

	@Override
	public void buildMaxSpeed() {
		car.setMaxSpeed(200);
	}
}

class Director {
	private CarBuilder carBuilder;

	public void setCarBuilder(CarBuilder carBuilder) {
		this.carBuilder = carBuilder;
	}

	public Car buildCar() {
		carBuilder.createCar();
		carBuilder.buildMake();
		carBuilder.buildTransmission();
		carBuilder.buildMaxSpeed();
		return carBuilder.getCar();
	}
}
//class CarBuilder {
//	private String m = "Default";
//	private Transmission t = Transmission.MANUAL;
//	private int s = 90;
//
//	public CarBuilder buildMake(String m){
//		this.m = m;
//		return this;
//	}
//	public CarBuilder buildTransmission(Transmission t){
//		this.t = t;
//		return this;
//	}
//	public CarBuilder buildMaxSpeed(int s){
//		this.s = s;
//		return this;
//	}
//
//	public Car build() {
//		Car car = new Car();
//		car.setMake(m);
//		car.setTransmission(t);
//		car.setMaxSpeed(s);
//		return car;
//	}
//
//}
	
	
	