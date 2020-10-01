package com.wa.qa.base;

import com.wa.qa.util.TestUtil;
import com.wa.qa.util.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;

    public TestBase(){

        prop = new Properties();
        FileInputStream fi = null;
        try {
            fi = new FileInputStream("/Users/shubhampurwar/IdeaProjects/Coding/WebAutomation/src/main/java/com/wa/qa/config/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(fi);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void initialization(){

        String browserName = prop.getProperty("browser");

        if ("Chrome".equals(browserName)){
            System.setProperty("webdriver.chrome.driver","/Users/shubhampurwar/desktop/AWS/Selenium/chromedriver");
            driver = new ChromeDriver();
        }else if(browserName.equals("Firefox")){
            // FireFox Browser
        }else if(browserName.equals("IE")){
            // IE browser
        }

        e_driver = new EventFiringWebDriver(driver);
        // Now create Object of EventListenerHandler to register it with EventFiringWebDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }


}
