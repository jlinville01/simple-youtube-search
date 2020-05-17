package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import page_objects.App;

public abstract class AbstractTest {
	protected WebDriver driver;
	protected App app;
	WebDriverWait wait;
	public java.util.Properties props;
	public String baseUrl;
	
	/**
	 * Establishes a universal setup() to be used initialize all test cases.
	 * Includes setting up properties for database connection, driver and wait.
	 * @throws IOException 
	 */
	@Before
	public void setUp() throws IOException {
		// Properties
		Properties props = new Properties();
		FileInputStream objfile = new FileInputStream("src/resources/config.properties");
		props.load(objfile);
		this.props = props;
		this.baseUrl = props.getProperty("baseUrl");
		
		// Driver (hardcoded to Chrome)
		System.setProperty(props.getProperty("driverType"), props.getProperty("driverLocation"));
		driver = new ChromeDriver();
		driver.get(this.baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		this.wait = new WebDriverWait(driver, 30);
		
		app = new App(driver, props);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}