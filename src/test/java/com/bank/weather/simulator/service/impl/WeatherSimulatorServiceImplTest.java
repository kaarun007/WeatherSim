package com.bank.weather.simulator.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bank.weather.simulator.model.ConfigProperties;
import com.bank.weather.simulator.service.WeatherSimulatorService;

@RunWith(SpringRunner.class)
@EnableConfigurationProperties(ConfigProperties.class)
public class WeatherSimulatorServiceImplTest {
	@Autowired
	private ConfigProperties configProperties;
    
	@Test
	public void generateWeatherTest(){
		WeatherSimulatorService simulatorService = new WeatherSimulatorServiceImpl();
		List<String>result = simulatorService.generateWeather(configProperties);
		assertEquals(10,result.size());
	}

}
