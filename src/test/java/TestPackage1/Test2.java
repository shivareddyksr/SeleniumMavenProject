package TestPackage1;

import org.testng.annotations.Test;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Window;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2 {

	@Test
	public void tc1() throws InterruptedException, IOException
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--incognito");
		option.addArguments("--disable-notification");
		option.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver(option);    //SessionNotCreatedException
		driver.manage().window().maximize();
		Properties ps = new Properties();
		FileInputStream fis = new FileInputStream("./data.properties");
		//Workbook wb = workBookFactory();
		ps.load(fis);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);   //NosuchElementException
		driver.get(ps.getProperty("url"));
		Thread.sleep(3000);    //InterruptedException
		//driver.findElement(By.id("nav-logo-sprites")).click();
		//Thread.sleep(3000);
		WebElement ele = driver.findElement(By.xpath("(//a[text()='Best Sellers'])[1]"));
		//header[@id='navbar-main']/div/div[5]/div[2]/div/div/a[3]
		WebDriverWait wait = new WebDriverWait(driver,10);
		System.out.println(ele.getText());
		System.out.println(ele.getAttribute("class"));
		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();  //TimeOutException
		Thread.sleep(2000);
		WebElement ele2 = driver.findElement(By.xpath("//a[text()='Facebook']"));
		wait.until(ExpectedConditions.visibilityOf(ele2));
		org.openqa.selenium.Point p = ele2.getLocation();
		System.out.println(p.getX()+" , "+p.getY());
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+p.getX()+","+p.getY()+")");
		//js.executeScript("Windows.scrollBy()");
		org.openqa.selenium.Dimension d = ele2.getSize();
		System.out.println(d.getHeight()+" , "+d.getWidth());
		
		String s = driver.getWindowHandle();
		System.out.println(s);
		Thread.sleep(3000);
		driver.close();
	}
}
