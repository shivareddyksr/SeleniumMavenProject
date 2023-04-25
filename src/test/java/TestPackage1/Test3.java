package TestPackage1;
import org.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test3 {

	
	@BeforeSuite
	public void tc1()
	{
		System.out.println("tc1");
	}
	
	@BeforeMethod
	public void tc2()
	{
		System.out.println("tc2");
	}
	
	@BeforeClass
	public void tc3()
	{
		System.out.println("tc3");
	}
	
	@BeforeTest
	public void tc4()
	{
		System.out.println("tc4");
	}
	
	@Test
	public void tc5()
	{
		System.out.println("tc5");
	}
	
	@AfterMethod
	public void tc6()
	{
		System.out.println("tc6");
	}
	
	@AfterClass
	public void tc7()
	{
		System.out.println("tc7");
	}
	
	@AfterTest
	public void tc8()
	{
		System.out.println("tc8");
	}
	
	@AfterSuite
	public void tc9()
	{
		System.out.println("tc9");
	}
}
