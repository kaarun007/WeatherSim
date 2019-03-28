package com.bank.weather.simulator;



import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bank.weather.simulator.controller.WeatherSimulatorController;
import com.bank.weather.simulator.model.ConfigProperties;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableConfigurationProperties(ConfigProperties.class)
public class WeatherSimApplicationTests {

	@Autowired
	private ConfigProperties configProperties;
	@Test
	public void contextLoads() {
	}

}
