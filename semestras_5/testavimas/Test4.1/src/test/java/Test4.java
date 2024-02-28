import static org.junit.jupiter.api.Assertions.*;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Test4 {
    //static Main main = new Main();
    static ChromeDriver driver = new ChromeDriver();
    static String email;
    static String password;
    static String data;

    @BeforeClass
    public static void Register(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        email = "not_a_robot"+ Instant.now().getEpochSecond() + "@gmail.com";
        password = "slaptazodis";
        driver.get("https://demowebshop.tricentis.com");
        driver.findElement(By.xpath("//a[text()='Log in']")).click();
        driver.findElement(By.xpath("//input[@class='button-1 register-button']")).click();
        driver.findElement(By.xpath("//input[@id='gender-male']")).click();
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Nerobotas");
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Nerobotauskas");
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='register-button']")).click();
        driver.close();
    }

    @Before
    public void Login() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
    }

    @Test
    public void data1() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.findElement(By.xpath("//li[@class=\"inactive\"]/descendant::a[@href='/digital-downloads']")).click();
        try {
            File myObj = new File("data1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();

//                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='" + data +"']/ancestor::div[@class='product-item']/descendant::input[@value='Add to cart']")));
//                driver.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[text()='" + data +"']/ancestor::div[@class='product-item']/descendant::input[@value='Add to cart']")));
                driver.findElement(By.xpath("//a[text()='" + data +"']/ancestor::div[@class='product-item']/descendant::input[@value='Add to cart']")).click();
                TimeUnit.SECONDS.sleep(1);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//span[@title='Close']")).click();
        driver.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//span[text()='Shopping cart']")));
        driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();

        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
        driver.findElement(By.xpath("//button[@id='checkout']")).click();

        driver.findElement(By.xpath("//option[text()='Lithuania']")).click();
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("Robotburgas");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']")).sendKeys("Robotizacijos g. 404");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("LT08303");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("+37064040404");
        driver.findElement(By.xpath("//input[@title='Continue']")).click();

        driver.findElement(By.xpath("//input[@class='button-1 payment-method-next-step-button']")).click();

        driver.findElement(By.xpath("//input[@class='button-1 payment-info-next-step-button']")).click();

        driver.findElement(By.xpath("//input[@class='button-1 confirm-order-next-step-button']")).click();

        assertTrue(driver.findElement(By.xpath("//*[text()='Your order has been successfully processed!']")).isDisplayed());
    }

    @Test
    public void data2() throws InterruptedException {

        driver.findElement(By.xpath("//li[@class=\"inactive\"]/descendant::a[@href='/digital-downloads']")).click();
        try {
            File myObj = new File("data2.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();

//                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='" + data +"']/ancestor::div[@class='product-item']/descendant::input[@value='Add to cart']")));
//                driver.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[text()='" + data +"']/ancestor::div[@class='product-item']/descendant::input[@value='Add to cart']")));
                driver.findElement(By.xpath("//a[text()='" + data +"']/ancestor::div[@class='product-item']/descendant::input[@value='Add to cart']")).click();
                TimeUnit.SECONDS.sleep(1);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//span[@title='Close']")).click();
        driver.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//span[text()='Shopping cart']")));
        driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();

        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
        driver.findElement(By.xpath("//button[@id='checkout']")).click();

        if(driver.findElement(By.xpath("//option[text()='Lithuania']")).isDisplayed()) {
        driver.findElement(By.xpath("//option[text()='Lithuania']")).click();
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("Robotburgas");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']")).sendKeys("Robotizacijos g. 404");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("LT08303");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("+37064040404");
        driver.findElement(By.xpath("//input[@title='Continue']")).click();
        }else {
            driver.findElement(By.xpath("//input[@class='button-1 new-address-next-step-button']")).click();
        }

        driver.findElement(By.xpath("//input[@class='button-1 payment-method-next-step-button']")).click();

        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//input[@class='button-1 payment-info-next-step-button']")).click();

        driver.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//input[@class='button-1 confirm-order-next-step-button']")));
        driver.findElement(By.xpath("//input[@class='button-1 confirm-order-next-step-button']")).click();

        assertTrue(driver.findElement(By.xpath("//*[text()='Your order has been successfully processed!']")).isDisplayed());
    }

    @After //after each test
    public void Close()
    {
        driver.close();
    }

}
