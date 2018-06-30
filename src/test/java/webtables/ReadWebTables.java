package webtables;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadWebTables {
	String url = "file:///Users/cybertekschool/JavaPrgs/selenium-maven-automation/src/test/java/webtables/webtable.html";
	
	WebDriver driver;
	
	@BeforeClass //runs once for all tests
	public void setUp() {
		System.out.println("Setting up WebDriver in BeforeClass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
	}
	
	@Test
	public void readScores() {
		driver.get(url);
		//Read whole webtable data and print
		WebElement table = driver.findElement(By.tagName("table"));
		System.out.println(table.getText());
		
		//find out how many rows in the table
		List<WebElement> rows= driver.findElements(By.xpath("//table[@id='worldcup']/tbody/tr"));
		System.out.println("Number of data rows: " + rows.size());
		
		//print all table headers. one by one
		//get all headers into a list
		//use a loop to print out
		String headerPath  = "//table[@id='worldcup']/thead/tr/th";
		List<WebElement> headers = driver.findElements(By.xpath(headerPath));
		for (WebElement h : headers) {
			System.out.println(h.getText());
		}
		
	}
	

}
