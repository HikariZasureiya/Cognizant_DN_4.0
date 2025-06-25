package com.cogni.settingup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    void exampleTest() {
    	int res = App.meth();
        Assertions.assertEquals(69, res, "The result should be 42");
    }
    
}