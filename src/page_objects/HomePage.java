package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	protected WebDriverWait wait;
	
	@FindBy(css = "ytd-searchbox")
	private WebElement searchBar;
	
	@FindBy(id = "search-icon-legacy")
	private WebElement searchButton;
	
	public HomePage(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 10);
	}
	
	public void navigateHomePage(WebDriver driver) throws Exception {
		driver.get("http://www.youtube.com");

	}
	
	public void search(String query) throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(searchBar));
		searchBar.sendKeys(query);
		wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
	}
}
