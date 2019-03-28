package com.bank.weather.simulator.model;

import java.util.HashMap;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author ArunKumar
 * POJO contains all the application configuration attributes. 
 * @configuraion class uses the @PropertySrouce to contribute application.properties 
 * to the Environment's set of PropertySources.  	
 */
@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "weather")
public class ConfigProperties {
	
	private HashMap<String,Integer> sunny;
	private HashMap<String,Integer> rain;
	private HashMap<String, Integer> snow;
	private HashMap<String,String> citiesWithPosition;
	private String simulatorMode;
	private String weatherCondition;
	
	public String getWeatherCondition() {
		return weatherCondition;
	}
	public void setWeatherCondition(String weatherCondition) {
		this.weatherCondition = weatherCondition;
	}
	public String getSimulatorMode() {
		return simulatorMode;
	}
	public void setSimulatorMode(String simulatorMode) {
		this.simulatorMode = simulatorMode;
	}
	public HashMap<String, Integer> getSunny() {
		return sunny;
	}
	public void setSunny(HashMap<String, Integer> sunny) {
		this.sunny = sunny;
	}
	public HashMap<String, Integer> getRain() {
		return rain;
	}
	public void setRain(HashMap<String, Integer> rain) {
		this.rain = rain;
	}
	public HashMap<String, Integer> getSnow() {
		return snow;
	}
	public void setSnow(HashMap<String, Integer> snow) {
		this.snow = snow;
	}
	public HashMap<String, String> getCitiesWithPosition() {
		return citiesWithPosition;
	}
	public void setCitiesWithPosition(HashMap<String, String> citiesWithPosition) {
		this.citiesWithPosition = citiesWithPosition;
	}

	

}
