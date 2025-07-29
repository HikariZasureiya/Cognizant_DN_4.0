package com.cognizant.account.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@RestController
public class Controller{
    @GetMapping("/accounts/{number}")
    public HashMap<String , Object> resp(@PathVariable String number){
        HashMap<String , Object> map = new HashMap<>();
//        { number: "00987987973432", type: "savings", balance: 234343 }
        map.put("number", "00987987973432");
        map.put("type", "savings");
        map.put("balance", 234343);
        return map;
    }

}

