package testavimas;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		String response = "";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rokas\\Desktop\\testavimas\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		ElPastas pastas = new ElPastas();
		
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		driver.findElement(By.xpath("//input[@id='gender-male']")).click();
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Robo");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Cop");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(pastas.elPastas());
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("RoboCop.3000");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("RoboCop.3000");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		driver.findElement(By.xpath("//div[@class='leftside-3']//a[@href='/computers']")).click();
		driver.findElement(By.xpath("//ul[@class='list']//a[@href='/desktops']")).click();
		driver.findElement(By.xpath("//div[@class='item-box']//span[text()>1500]/ancestor::node()[1]/following-sibling::div/input[@value='Add to cart']")).click();
		//driver.findElement(By.xpath("//input[@value='Add to cart' and @class='button-1 add-to-cart-button']")).click();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@class='button-1 add-to-cart-button']")).click();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox' and @name='removefromcart']")).click();
		driver.findElement(By.xpath("//input[@name='updatecart']")).click();
		response = driver.findElement(By.xpath("//div[contains(text(),'Your Shopping Cart is empty!')]")).getText();

		driver.close();
		
		System.out.println(response);
	}
	
}
