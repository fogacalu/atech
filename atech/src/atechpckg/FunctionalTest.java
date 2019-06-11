package atechpckg;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * <strong>FunctionalTest</strong> handles setup and teardown of WebDriver.
 */
public class FunctionalTest {

	protected static WebDriver driver;

	
	@BeforeMethod
	public static void setUp(){
		System.setProperty("webdriver.gecko.driver", "c:\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public static void tearDown(){
		driver.close();
	}	
}
