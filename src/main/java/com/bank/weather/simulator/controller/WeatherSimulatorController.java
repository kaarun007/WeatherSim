package com.bank.weather.simulator.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.weather.simulator.model.ConfigProperties;
import com.bank.weather.simulator.service.WeatherSimulatorService;


/**
 * @author ArunKumar Weather simulator controller, the class is flagged as
 *         a @RestController, meaning it’s ready for use by Spring MVC to handle
 *         web requests.
 * @RequestMapping maps /weather to the getWeatherData() method.
 * 
 */
@RestController
public class WeatherSimulatorController {
	private final Logger logger = LoggerFactory.getLogger(WeatherSimulatorController.class);
	/**
	 * <p>
	 * The method would return the weather Data as a list of strings based on the
	 * application configuration.
	 * </p>
	 * @param
	 * @return weatherList list of weather data.
	 */
	@Autowired
	private ConfigProperties configProperties;
	@Autowired
	private WeatherSimulatorService weatherSimulatorService;

	@RequestMapping(value = "/weather")
	public List<String> getWeatherData() {
		List<String> weatherList = weatherSimulatorService.generateWeather(configProperties);
		logger.info("List of WeatherData is available");
		return weatherList;
	}

}