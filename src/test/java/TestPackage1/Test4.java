package TestPackage1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test4 {
	
	public WebDriver driver;

	
	@Parameters({"browserName"})
	@Test
	public void tc1(String browser)
	{
				if(browser.equals("Chrome"))
				{
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
					driver.close();
				}
				
				else if(browser.equals("Firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
					driver.close();
				}
					
	}
}
