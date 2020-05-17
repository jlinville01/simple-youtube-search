package test;

import org.junit.Assert;
import org.junit.Test;

public class HomePageTest extends AbstractTest {
	@Test
	public void runTest() throws Exception {
		// Navigate to page
		app.homepage().navigateHomePage(driver);
			
		// Search for batman
		app.homepage().search("Batman Animated Series");
		
		// Assert url
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.youtube.com/results?search_query=Batman+Animated+Series");
	}
}
