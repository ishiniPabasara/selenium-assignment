package com.ebay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Main {
    protected static WebDriver webDriver;

    public static WebDriverWait wait;
    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/driver/chromedriver.exe" );
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);

        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    @AfterTest
    public void tearDown(){
        webDriver.quit();
    }

}