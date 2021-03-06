package com.bank.weather.simulator.controller;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.bank.weather.simulator.model.ConfigProperties;


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

		mvc.perform(MockMvcRequestBuilders.get("/weather")).andExpect(status().isOk());

	}

}
