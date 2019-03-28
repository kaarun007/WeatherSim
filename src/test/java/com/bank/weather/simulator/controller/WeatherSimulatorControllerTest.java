package com.bank.weather.simulator.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.bank.weather.simulator.model.ConfigProperties;
import com.bank.weather.simulator.service.WeatherSimulatorService;
import com.bank.weather.simulator.service.impl.WeatherSimulatorServiceImpl;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
@EnableConfigurationProperties(ConfigProperties.class)
public class WeatherSimulatorControllerTest {
	
	@Autowired
	private ConfigProperties configProperties;
	@Autowired
    private MockMvc mvc;
	
	
	 @Test 
	 public void testGetWeather() throws Exception {
		 
		 mvc.perform(MockMvcRequestBuilders.get("/weather"))
         .andExpect(status().isOk());
        // .andExpect((ResultMatcher) content().string(equalTo("Greetings from Spring Boot!")));

		/*
		 * WeatherSimulatorController simulatorController = new
		 * WeatherSimulatorController(); List<String> result =
		 * simulatorController.getWeatherData(); assertEquals(10, result.size());
		 */
	 }
	 

	 

}
