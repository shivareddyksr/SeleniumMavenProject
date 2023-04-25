package TestPackage1;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test5 {

	public static WebDriver driver;

	@BeforeMethod
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	
	  @AfterMethod
	  public void closeApp(ITestResult result) throws IOException 
	  { 
		  int resl = result.getStatus(); 
		  if(resl==2) 
	  {
	 System.out.println("entered screenshot"); 
	 screenshot(); 
	 driver.close(); 
	 }
	  else { System.out.println("entered non screenshot"); 
	  driver.close();
	  }
	  
	 }
	  
	 
//	@AfterSuite
//	public void closeApp(ITestResult result) {
//		driver.close();
//	}

	public static void screenshot() throws IOException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
		LocalDateTime now = LocalDateTime.now();  
		String date = dtf.format(now);  
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("./ScreenShotFolder/"+date+".png");
		FileUtils.copyFile(src, f);
		System.out.println("Completed picture");
	}

	@Test
	public void tc1() throws InterruptedException {
		driver.get("https://www.amazon.in/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='1Best Sellers']")).click();
		
	}
}
