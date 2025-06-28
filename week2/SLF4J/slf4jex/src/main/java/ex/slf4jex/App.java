package ex.slf4jex;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App 
{
    public static void main( String[] args )
    {
    	int value = 1000;
    	Logger logger = LoggerFactory.getLogger("SampleLogger");
	 	logger.info("Logger initialized");
    	Scanner sc = new Scanner(System.in);   
    	int  discount= sc.nextInt();
    	
    	if(discount > 100) {
    		logger.warn("discount greater than 100%");
    	}
    	else if(discount < 0){
    		logger.error("discount less than 0%");
    	}
    	else {
    		System.out.println(value+value*discount*0.01);
    	}
    	
    	sc.close();
    }
}
