package com.cognizant.orm_learn;

import org.springframework.context.ApplicationContext;
import com.cognizant.orm_learn.model.Country;
import java.util.List;
import com.cognizant.orm_learn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountryApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryApplication.class);
	private static CountryService countryService;

	private static void testGetAllCountries() {
	LOGGER.info("Start");
	List<Country> countries = countryService.getAllCountries();
	LOGGER.debug("countries={}", countries);
	LOGGER.info("End");
	}

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(CountryApplication.class, args);
		LOGGER.info("Application started");
		countryService = context.getBean(CountryService.class);
		testGetAllCountries();
	}

}
