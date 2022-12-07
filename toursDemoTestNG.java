package practice.demo.tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class toursDemoTestNG {
	WebDriver driver;
	private String URL = "https://demo.guru99.com/test/newtours/";
	
  @Test(description = "Launch the website")
  public void launchWebSite() {
	  	driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }
  
  @Test(description = "Register the applicaion")
  @Parameters("firstName")
	public void register() {
		driver.findElement(By.linkText("REGISTER")).click();
		
		//Contact Information
		driver.findElement(By.name("firstName")).sendKeys("Padmini");
		driver.findElement(By.name("lastName")).sendKeys("Nayak");
		driver.findElement(By.name("phone")).sendKeys("12345");
		driver.findElement(By.id("userName")).sendKeys("abc@abc.com");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Mailing information
		driver.findElement(By.name("address1")).sendKeys("Test Address");
		driver.findElement(By.name("city")).sendKeys("Test city");
		driver.findElement(By.name("state"));
		driver.findElement(By.name("postalCode")).sendKeys("464546");
		
		Select select = new Select(driver.findElement(By.name("country")));
		select.selectByVisibleText("INDIA");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//User Information
		driver.findElement(By.id("email")).sendKeys("Padmini");
		driver.findElement(By.name("password")).sendKeys("abc");
		driver.findElement(By.name("confirmPassword")).sendKeys("abc");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//submit
		driver.findElement(By.name("submit")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
  
  @BeforeTest
  @Parameters("browser")
  public void beforeTest(String browser) {
	  if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("windows.chrome.driver", "C://WebDrivers//chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("windows.firefox.driver", "C://WebDrivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}
}
  

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
