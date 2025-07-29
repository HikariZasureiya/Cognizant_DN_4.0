package com.cognizant.loans.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@RestController
public class Controller{
    @GetMapping("/loans/{number}")
    public HashMap<String , Object> resp(@PathVariable String number){
        HashMap<String , Object> map = new HashMap<>();
//        { number: "H00987987972342", type: "car", loan: 400000, emi: 3258, tenure:
//            18 }
        map.put("number", "H00987987972342");
        map.put("type", "car");
        map.put("loan", 400000);
        map.put("emi", 3258);
        map.put("tenure", 18);

        return map;
    }

}