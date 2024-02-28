package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); //implicit wait - wait for passed argument of time for how long should the driver keep on trying to execute the command
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60)); //explicit wait - define a condition before proceeding

        //------------------------------1 dalis-----------------------------------------

//        driver.get("https://demoqa.com");
//        driver.findElement(By.xpath("//h5[text()='Widgets']")).click();
//
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Progress Bar']")));
//        driver.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//span[text()='Progress Bar']")));
//        driver.findElement(By.xpath("//span[text()='Progress Bar']")).click();
//
//        driver.findElement(By.xpath("//button[@id='startStopButton']")).click();
//
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-valuenow='100']")));
//        driver.findElement(By.xpath("//button[@id='resetButton']")).click();
//
//        System.out.println(driver.findElement(By.xpath("//div[@role='progressbar']")).getAttribute("aria-valuenow").toString()); // ??????
//        if(driver.findElement(By.xpath("//div[@role='progressbar']")).getAttribute("aria-valuenow").toString().equals("0")){
//            System.out.println("great success!");
//            driver.close();
//        } else{
//            System.out.println(":-(");
//            driver.close();
//        }

        //----------------------------- 2 dalis ------------------------------------

        WebDriverWait fluentWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        fluentWait.withTimeout(Duration.ofSeconds(60));
        fluentWait.pollingEvery(Duration.ofMillis(200));
        fluentWait.ignoring(NoSuchElementException.class);

        driver.get("https://demoqa.com");
        driver.findElement(By.xpath("//h5[text()='Elements']")).click();
        driver.findElement(By.xpath("//span[text()='Web Tables']")).click();

        Function<WebDriver,Boolean> function = new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver arg0)
            {
                driver.findElement(By.xpath("//button[@id='addNewRecordButton']")).click();
                driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("ponas");
                driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("pavardenis");
                driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("ponas@gmail.com");
                driver.findElement(By.xpath("//input[@id='age']")).sendKeys("40");
                driver.findElement(By.xpath("//input[@id='salary']")).sendKeys("1000");
                driver.findElement(By.xpath("//input[@id='department']")).sendKeys("administracija");
                driver.findElement(By.xpath("//button[@id='submit']")).click();

                if (driver.findElement(By.xpath("//button[text()='Next']")).isEnabled()) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        fluentWait.until(function);

        driver.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//button[text()='Next']")));
        driver.findElement(By.xpath("//button[text()='Next']")).click();

        driver.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//span[@title='Delete']")));
        driver.findElement(By.xpath("//span[@title='Delete']")).click();

        driver.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[@class='-next']")));

        if(!driver.findElement(By.xpath("//div[@class='-next']//child::node()")).isEnabled() &&
                driver.findElement(By.xpath("//div[@class='-next']//child::node()")).getText().equals("1")){
            System.out.println("Great success!");
            driver.close();
        } else {
            System.out.println(":-(");
            driver.close();
        }
    }
}