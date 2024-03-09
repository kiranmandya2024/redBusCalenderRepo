package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.example.RedBusCalender.driver;

public class Calender {

    public static List<String> getWeekEndDates(String month, String year){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#onwardCal")));
        driver.findElement(By.cssSelector("#onwardCal")).click();

        //selecting the year
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class^='DayNavigator__IconBlock']:nth-of-type(2)")));
        String monthYear=driver.findElement(By.cssSelector("[class^='DayNavigator__IconBlock']:nth-of-type(2)")).getText().trim();
        System.out.println(monthYear);
        String holidays;
        while (!(monthYear.contains(year) && monthYear.contains(month)))
       {
           driver.findElement(By.cssSelector("div[class^='DayNavigator__CalendarHeader']>div:nth-child(3)>svg")).click();
           webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class^='DayNavigator__IconBlock']:nth-of-type(2)")));
           monthYear=driver.findElement(By.cssSelector("[class^='DayNavigator__IconBlock']:nth-of-type(2)")).getText().trim();
           System.out.println(monthYear);

       }

        List<String> weekenddates = new ArrayList<>();
        //getting all the weekends
        driver.findElements(By.cssSelector("div[class^='DayTilesWrapper']>span>div>span"))
                .stream().forEach(dates->{
                    if(dates.getCssValue("color").startsWith("rgba(2")){
                        weekenddates.add(dates.getText());
                    }
                });
        return weekenddates;
    }
}
