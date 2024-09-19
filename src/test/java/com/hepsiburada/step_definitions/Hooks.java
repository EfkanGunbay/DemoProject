package com.hepsiburada.step_definitions;

import com.hepsiburada.utilities.ConfigReader;
import com.hepsiburada.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.cucumber.java.Before;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @BeforeTest
    public void setUp(){
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get("https://www.hepsiburada.com/");
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown(){
       Driver.close();
    }

}
