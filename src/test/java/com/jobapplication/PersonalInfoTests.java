package com.jobapplication;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PersonalInfoTests {
	WebDriver driver;
	
	@BeforeClass //runs once for all tests
	public void setUp() {
		System.out.println("Setting up WebDriver in BeforeClass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
	}
	
	@BeforeMethod //runs before each @Test
	public void navigateToHomePage() {
		System.out.println("Navigating to homepage in @BeforeMethod....");
		driver.get("https://forms.zohopublic.com/murodil/form/JobApplicationForm/formperma/kOqgtfkv1dMJ4Df6k4_mekBNfNLIconAHvfdIk3CJSQ");	
	}
	
	@Test
	public void fullNameEmptyTest() {
		//firstly assert that you are on the correct page
		assertEquals(driver.getTitle(), "SDET Job Application");
		
		driver.findElement(By.xpath("//input[@elname='first']")).clear();	
		driver.findElement(By.xpath("//*[@elname='last']")).clear();
		//<em> Next </em>
		driver.findElement(By.xpath("//em[.=' Next ']")).click();
		//write xpath with tagname + id 
		//get the text and assert text equals to Enter a value for this field.
//		<p class="errorMessage" elname="error" id="error-Name"
//				style="display: block;">Enter a value for this field.</p>
		String nameError = driver.findElement(By.xpath("//p[@id='error-Name']")).getText();
		assertEquals(nameError, "Enter a value for this field.");

	}
	
}	
