package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        //System.setProperty("webdriver.chrome.driver", "Macintosh HD//Users//siddharthgarnaik//Documents//SeleniumPrac//Driver//chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //WebDriverWait wait = new WebDriverWait(wait.until());
        driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
        if(driver.findElement(By.xpath("//a[@class='close']")).isDisplayed()){
            driver.findElement(By.xpath("//a[@class='close']")).click();
        }
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[text()='From']")).click();
        driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Mumbai");
        driver.findElement(By.xpath("//*[text()='BOM']")).click();
        driver.findElement(By.xpath("//*[text()='To']")).click();
        driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Bengaluru");
        driver.findElement(By.xpath("//*[text()='BLR']")).click();
        driver.findElement(By.xpath("//*[text()='Departure']")).click();
        driver.findElement(By.xpath("//*[@aria-label='Thu Mar 21 2024']")).click();
        driver.findElement(By.xpath("//*[text()='Search']")).click();
        //if this is displayed then click
        if(driver.findElement(By.xpath("//*[text()='OKAY, GOT IT!']")).isDisplayed()){
            driver.findElement(By.xpath("//*[text()='OKAY, GOT IT!']")).click();
        }
        //for Timings
        List<WebElement> startTime = driver.findElements(By.xpath("//div[contains(@class,'flexOne timeInfoLeft')]//span"));
        System.out.println(startTime.get(0).getText());
        List<WebElement> endTime = driver.findElements(By.xpath("//div[contains(@class,'flexOne timeInfoRight')]//span"));
        System.out.println(endTime.get(0).getText());
        //for Flight Details
        List<WebElement> flightCompany = driver.findElements(By.xpath("//p[contains(@class,'airlineName')]"));
        System.out.println(flightCompany.get(0).getText());
        List<WebElement> flightCode = driver.findElements(By.xpath("//p[contains(@class,'airlineName')]/following-sibling::p"));
        System.out.println(flightCode.get(0).getText());
        }
    }
