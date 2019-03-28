package com.bank.weather.simulator.util;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bank.weather.simulator.model.Weather;

/**
 * @author ArunKumar This is the utility holds the common logic to generate
 *         random numbers, random date and weather object.
 * 
 */
public class WeatherUtil {
	private static final Logger logger = LoggerFactory.getLogger(WeatherUtil.class);
	private WeatherUtil() {

	}

	public static Double CreateRandomDoubleBetween(Integer min, Integer max) {
		Double temperature = min + (Math.random() * (max - min) + 1);
		logger.debug("Generated Random Double:"+temperature);
		return temperature;
	}

	public static Integer createRandomIntBetween(Integer min, Integer max) {
		Integer pressure = (int) (min + (Math.random() * (max - min)));
		logger.debug("Generated Random Integer:"+pressure);
		return pressure;
	}

	public static LocalDateTime createRandomDate(int startMonth, int endMonth) {
		int day = createRandomIntBetween(1, 28);
		int month = createRandomIntBetween(startMonth, endMonth);
		int year = createRandomIntBetween(2000, 2018);
		int hour = createRandomIntBetween(01, 12);
		int minute = createRandomIntBetween(0, 60);
		int sec = createRandomIntBetween(0, 60);
		logger.debug("Gnerated Date:"+day+""+month+""+year);
		return LocalDateTime.of(year, month, day, hour, minute, sec);
	}

	public static String createRamdomClimate(List<String> climateList) {
		Random random = new Random();
		return climateList.get(random.nextInt(climateList.size()));
	}

	public static Weather createWeatherData(HashMap<String, Integer> conditionMap) {
		Weather weather = new Weather();
		Double temperature = CreateRandomDoubleBetween(conditionMap.get("maxtemp"), conditionMap.get("mintemp"));
		Double pressure = CreateRandomDoubleBetween(conditionMap.get("maxpressure"), conditionMap.get("minpressure"));
		Integer humidity = createRandomIntBetween(conditionMap.get("maxhumidity"), conditionMap.get("minhumidity"));
		LocalDateTime localTime = createRandomDate(conditionMap.get("frommonth"), conditionMap.get("tomonth"));
		weather.setPressure(pressure);
		weather.setTemperature(temperature);
		weather.setHumidity(humidity);
		weather.setLocalTime(localTime);
		return weather;

	}

}
