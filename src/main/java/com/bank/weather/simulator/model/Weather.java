package com.bank.weather.simulator.model;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

/**
 * @author ArunKumar POJO contains all the weather attributes.
 * 
 */
public class Weather {

	private String location;
	private String position;
	private LocalDateTime localTime;
	private String condition;
	private Double temperature;
	private Double pressure;
	private Integer Humidity;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public LocalDateTime getLocalTime() {
		return localTime;
	}

	public void setLocalTime(LocalDateTime localTime) {
		this.localTime = localTime;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Double getPressure() {
		return pressure;
	}

	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}

	public Integer getHumidity() {
		return Humidity;
	}

	public void setHumidity(Integer humidity) {
		Humidity = humidity;
	}

	@Override
	public String toString() {
		DecimalFormat decimalformat = new DecimalFormat(".#");
		return String.format(location + "|" + position + "|" + localTime + "|" + condition + "|"
				+ decimalformat.format(temperature) + "|" + decimalformat.format(pressure) + "|" + Humidity);
	}

}
