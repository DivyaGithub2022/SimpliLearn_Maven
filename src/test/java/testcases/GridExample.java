package testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;


public class GridExample {
	
	@Test
	public void testGrid() throws MalformedURLException {
		
		// instead of giving these commands - 
		//system.setproperty(null,null);
		//WebDriverManager.chromedriver().setup();
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setPlatform(Platform.LINUX);
		capabilities.setBrowserName("chrome");
		
		URL hubURL = new URL("http://172.17.0.1:4444/wd/hub");
		//06:49:29.114 INFO [Hub.start] - Clients should connect to http://172.17.0.1:4444/wd/hub
		//from the command prompt

		
		WebDriver driver = new RemoteWebDriver(hubURL,capabilities);
		
		driver.get("https://www.simplilearn.com/");
		
		//driver.quit();

	
	}

}
