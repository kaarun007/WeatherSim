package com.bank.weather.simulator.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bank.weather.simulator.model.ConfigProperties;
import com.bank.weather.simulator.model.Weather;
import com.bank.weather.simulator.service.WeatherSimulatorService;
import com.bank.weather.simulator.util.WeatherUtil;

/**
 * @author ArunKumar 
 * 		   This WeatherSimulatorService class holds the main logic to
 *         generate the weather data. The difference weather conditions and the
 *         corresponding environments are predefined in the
 *         applicaiton.properties file. The logic in this class generates below
 *         attributes for each Location 
 *         1.Random weather condition 
 *         2.Random Time. 
 *         3.Random temperature value. 
 *         4.Random pressure value. 
 *         5.Random Humidity value.
 * @Service denotes WeatherSimulatorServiceImpl is an implementation class for
 *          the WeatherSimilatorService interface.
 * 
 */

@Service
public class WeatherSimulatorServiceImpl implements WeatherSimulatorService {
	private final Logger logger = LoggerFactory.getLogger(WeatherSimulatorServiceImpl.class);
	
	/**
	 * <p>This method generates the random weather data for each location based on the weather condition.
	 * </p>
	 * @param configproperteis it holds the attributes of application.properties. 
	 * @return weatherDataList list of randomly generated weather data per location.
	 */
	@Override
	public List<String> generateWeather(ConfigProperties configProperties) {
		List<String> weatherDataList = new ArrayList<String>();
		if (configProperties.getSimulatorMode().equals("mixed")) {
			List<Weather> weather = generateMixedWeather(configProperties);
			weather.forEach(e -> weatherDataList.add(e.toString()));
		}else {
			// handled in future
		}
		return weatherDataList;
	}

	private List<Weather> generateMixedWeather(ConfigProperties configProperties) {
		List<Weather> weatherList = new ArrayList<Weather>();
		String conditions = configProperties.getWeatherCondition();
		List<String> conditionList = Arrays.asList(conditions.split(","));
		HashMap<String, String> cityWithPosition = configProperties.getCitiesWithPosition();
		Weather weatherData = new Weather();
		for (HashMap.Entry<String, String> entry : cityWithPosition.entrySet()) {
			logger.debug("The weather data generation logic started generated");
			String condition = WeatherUtil.createRamdomClimate(conditionList);
			if(condition != null) {
			switch(condition) {
			case "snow":
				logger.debug("The condition generated"+condition);
				HashMap<String, Integer> snowMap = configProperties.getSnow();
				weatherData = WeatherUtil.createWeatherData(snowMap);
				break;
			case "rain":
				logger.debug("The condition generated"+condition);
				HashMap<String, Integer> rainMap = configProperties.getRain();
				weatherData = WeatherUtil.createWeatherData(rainMap);
			    break;
			case "sunny":
				logger.debug("The condition generated"+condition);
				HashMap<String, Integer> sunnyMap = configProperties.getSunny();
				weatherData = WeatherUtil.createWeatherData(sunnyMap);
				break;
			}}
			weatherData.setLocation(entry.getKey());
			logger.debug("Location:"+entry.getKey());
			weatherData.setPosition(entry.getValue());
			logger.debug("Position:"+entry.getValue());
			weatherData.setCondition(condition);
			weatherList.add(weatherData);
           
		}
		return weatherList;
	}

}
