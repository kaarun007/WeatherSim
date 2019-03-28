package com.bank.weather.simulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.bank.weather.simulator.model.ConfigProperties;

@SpringBootApplication
@EnableConfigurationProperties(ConfigProperties.class)
public class WeatherSimApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherSimApplication.class, args);
	}

}
