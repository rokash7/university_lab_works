package org.example;

import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Instant;


import static org.junit.jupiter.api.Assertions.*;

public class Uzduotis3Test {

    static Main uzduotis3 = new Main();
    static ChromeDriver driver = new ChromeDriver();
    static String email;
    static String password;
    static String data;
    //static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));


    @BeforeClass
    public static void StartUp()
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        email = "gp"+ Instant.now().getEpochSecond() + "@gmail.com";
        password = "Nenoriu";
        uzduotis3.Register(driver, email, password);
        System.out.println("BeforeClass");
    }

    @Before
    public void Login()
    {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().window().maximize();
        uzduotis3.Login(driver, email, password);
        System.out.println("Before");
    }

    @Test
    public void Uzduotis3_data1()
    {
        assertEquals(true, uzduotis3.Uzduotis(1, driver));
    }
    @Test
    public void Uzduotis3_data2()
    {
        assertEquals(true, uzduotis3.Uzduotis(2, driver));
    }

    /*@After
    public void Close()
    {
        driver.close();
        System.out.println("After");
    }

    @AfterClass
    public static void Quit()
    {
        driver.quit();
        System.out.println("AfterClass");
    }*/
}