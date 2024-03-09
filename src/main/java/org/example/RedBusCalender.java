package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class RedBusCalender {
    static WebDriver driver;
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver =WebDriverManager.chromedriver().capabilities(options).create();
        driver.manage().window().maximize();
        driver.get("https://www.redbus.in/");
        List<String> weekenddates=Calender.getWeekEndDates("Apr","2025");
        System.out.println(weekenddates);

        driver.close();
    }
}