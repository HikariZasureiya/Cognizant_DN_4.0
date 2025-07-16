package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/country")
    public Country getCountryIndia() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countrylis = (List<Country>) context.getBean("countryList");
          return countrylis.get(0);
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countrylis = (List<Country>) context.getBean("countryList");
        return countrylis;
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code){
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countrylis = (List<Country>) context.getBean("countryList");
        Country count = countrylis.stream().filter(country -> country.getCode().equals(code)).findFirst().orElse(null);
        return count;
    }


}
