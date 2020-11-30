package designpattern;

import java.util.ArrayList;
import java.util.Random;

interface Subject {
	public void registerObserver(Observer ob);

	void removeObserver(Observer ob);

	void notifyObserver();
}

interface Observer {
	public void update(float temp, float humidity, float pressure);
}

interface DisplayElement {
	public void display();
}

class WeatherData implements Subject {
	private ArrayList<Observer> observers;
	private float temperature;
	private float pressure;
	private float humidity;

	public WeatherData() {
		this.observers = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(Observer ob) {
		// TODO Auto-generated method stub
		observers.add(ob);

	}

	@Override
	public void removeObserver(Observer ob) {
		// TODO Auto-generated method stub
		int index = observers.indexOf(ob);
		if (index >= 0)
			observers.remove(index);

	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for (int i = 0; i < observers.size(); i++) {
			Observer ob = (Observer) observers.get(i);
			ob.update(temperature, humidity, pressure);
		}

	}

	public void measurementsChanged() {
		notifyObserver();
	}

	public void setMeasurement(float temperature, float pressure, float humidity) {
		this.temperature = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
		measurementsChanged();
	}

}

class CurrentConditionDisplay implements Observer, DisplayElement {

	private float temperature;
	private float pressure;
	private float himidity;
	private Subject weatherData;

	public CurrentConditionDisplay(Subject weatherData) {
		// TODO Auto-generated constructor stub
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("current display is displaying");
		System.out.println("Current conditions " + temperature + "humidity " + himidity + " pressure " + pressure);

	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		// TODO Auto-generated method stub
		this.temperature = temp;
		this.himidity = humidity;
		this.pressure = pressure;
		display();
	}

}

class CustomDisplay implements Observer, DisplayElement {

	private float temperature;
	private float pressure;
	private float himidity;
	private Subject weatherData;

	public CustomDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("custom display is displaying \nvalues humidity" + himidity + " temperature " + temperature
				+ " pressure " + pressure);

	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		// TODO Auto-generated method stub
		this.temperature = temp;
		this.himidity = humidity;
		this.pressure = pressure;

	}

}

public class WeatherStation {

	public static void main(String[] args) {

		WeatherData weatherData = new WeatherData();
		
		CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
		
		System.out.println("\n\nchange mesurements for current condition display observer\n");
		
		weatherData.setMeasurement(10, 10, 10);
		
		System.out.println("\n\nnew observer registered\n");
		
		CustomDisplay customDisplay = new CustomDisplay(weatherData);
		
		
		
		weatherData.setMeasurement(20, 20, 20);
		
		customDisplay.display();
		
		System.out.println("\nremoved observer from list\n");
		
		weatherData.removeObserver(customDisplay);
		
		
		weatherData.setMeasurement(30, 30, 30);
		customDisplay.display();
		currentConditionDisplay.display();
		
		System.out.println("\nAgain register and display observer list\n");
		
		weatherData.registerObserver(customDisplay);
		
		weatherData.setMeasurement(40, 40, 40);
		customDisplay.display();
		currentConditionDisplay.display();
	}

}
