package TestPackage2;

import org.testng.annotations.Test;

public class Test2 {

	@Test
	public void tc1()
	{
		char a = 'a';
		char b = 'a';
		if(Character.toString(a).equalsIgnoreCase(Character.toString(b)))
		{
			System.out.println("Success");
		}
		else
		{
			System.out.println("Failed");
		}
	}
}
