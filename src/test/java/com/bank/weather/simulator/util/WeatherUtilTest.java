package com.bank.weather.simulator.util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;
import com.bank.weather.simulator.model.ConfigProperties;
import com.bank.weather.simulator.model.Weather;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableConfigurationProperties(ConfigProperties.class)
public class WeatherUtilTest {

	@Autowired
	private ConfigProperties configProperties;
	List<String> testConditionList = new ArrayList<String>();
	private int maxTemperature;
	private int minTemperature;
	private int minPressure;
	private int maxPressure;
	private int minHumidity;
	private int maxHumidity;
	private int frommonth;
	private int tomonth;

	@Before
	public void setup() {
		HashMap<String, Integer> snowConfig = configProperties.getSnow();
		maxTemperature = snowConfig.get("maxtemp");
		minTemperature = snowConfig.get("mintemp");
		minPressure = snowConfig.get("minpressure");
		maxPressure = snowConfig.get("maxpressure");
		maxHumidity = snowConfig.get("maxhumidity");
		minHumidity = snowConfig.get("minhumidity");
		frommonth = snowConfig.get("frommonth");
		tomonth = snowConfig.get("tomonth");

		testConditionList.add("snow");
		testConditionList.add("sunny");
		testConditionList.add("rain");
	}

	@Test
	public void testCreateRandomDoubleBetween() {

		int result = WeatherUtil.CreateRandomDoubleBetween(minTemperature, maxTemperature).intValue();
		assertTrue(minTemperature <= result && result <= maxTemperature);
	}

	@Test
	public void testCreateRandomIntBetween() {

		int result = WeatherUtil.createRandomIntBetween(minHumidity, maxHumidity);
		assertTrue(minHumidity <= result && result <= maxHumidity);
	}

	@Test
	public void testCreateRamdomClimate() {
		String result = WeatherUtil.createRamdomClimate(testConditionList);
		assertTrue(testConditionList.contains(result));

	}

	@Test
	public void testCreateRandomDate() {
		LocalDateTime result = WeatherUtil.createRandomDate(frommonth, tomonth);
		assertTrue(frommonth <= result.getMonthValue() && result.getMonthValue() <= tomonth);
	}

	@Test
	public void testCreateWeatherDataForSnow() {
		Weather weather = new Weather();
		weather = WeatherUtil.createWeatherData(configProperties.getSnow());
		assertTrue(minTemperature <= weather.getTemperature().intValue()
				&& weather.getTemperature().intValue() <= maxTemperature);
		assertTrue(minHumidity <= weather.getHumidity() && weather.getHumidity() <= maxHumidity);
		assertTrue(frommonth <= weather.getLocalTime().getMonthValue()
				&& weather.getLocalTime().getMonthValue() <= tomonth);
	}
}
