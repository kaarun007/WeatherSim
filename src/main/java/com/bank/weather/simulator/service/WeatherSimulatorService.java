package com.bank.weather.simulator.service;

import java.util.List;

import com.bank.weather.simulator.model.ConfigProperties;
import com.bank.weather.simulator.model.Weather;

public interface WeatherSimulatorService {
	
	public List<String> generateWeather(ConfigProperties configProperties);


}
