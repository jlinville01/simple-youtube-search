package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class App {
	private WebDriver driver;
	private java.util.Properties props;
	
	public App(WebDriver driver, java.util.Properties props) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.props = props;
	}
	
	public HomePage homepage() throws Exception { return new HomePage(driver); }
}