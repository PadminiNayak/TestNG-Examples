package practice.demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class insuranceDemoTestNG {
	WebDriver driver;
	private String URL = "";

	@Test(description = "Launch the website")
	public void launchURL() {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test(description = "Sign Up the applicaion")
	public void signUp() {
		driver.findElement(By.partialLinkText("Reg")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.id("user_firstname")).sendKeys("Padmini");
		driver.findElement(By.id("user_surname")).sendKeys("Nayak");
		driver.findElement(By.id("user_phone")).sendKeys("123456");

		driver.findElement(By.id("licencetype_f")).click();

		driver.findElement(By.id("user_address_attributes_street")).sendKeys("Address");
		driver.findElement(By.id("user_address_attributes_city")).sendKeys("city");
		driver.findElement(By.id("user_address_attributes_county")).sendKeys("country");
		driver.findElement(By.id("user_user_detail_attributes_email")).sendKeys("abc@abv.bg");
		driver.findElement(By.id("user_user_detail_attributes_password")).sendKeys("pwd");
		driver.findElement(By.id("user_user_detail_attributes_password_confirmation")).sendKeys("pwd");

		driver.findElement(By.name("submit")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Test(description = "Login to the application")
	public void logIn() {
		driver.findElement(By.id("email")).sendKeys("abc@abv.bg");
		driver.findElement(By.id("password")).sendKeys("pwd");
		driver.findElement(By.name("submit")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Test(description = "Logout to the application")
	public void logOut() {
		driver.findElement(By.xpath("//body/div[3]/form[1]/input[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("windows.chrome.driver", "C://WebDrivers//chromedriver.exe");
		driver = new ChromeDriver();
		URL = "https://demo.guru99.com/insurance/v1/index.php";
	}
	
	

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
