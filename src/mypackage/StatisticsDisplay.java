package mypackage;

public class StatisticsDisplay implements Observer, DisplayElement {
	
	private float temperature;
	private float minTemp;
	private float maxTemp;
	private float avgTemp;
	private Subject weatherData;
	
	public StatisticsDisplay( Subject weatherData ) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		if (temperature < minTemp) minTemp = temperature;
		if (temperature > maxTemp) maxTemp = temperature;
		avgTemp = (avgTemp + temperature) / 2;
		display();	
		
	}
	
	public void display() {
		System.out.println("Avg/Max/Min Temperature = " + minTemp + "/" + maxTemp + "/" + avgTemp);
	}
	
}
