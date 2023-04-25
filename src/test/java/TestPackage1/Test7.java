package TestPackage1;

import java.util.LinkedHashSet;

import org.testng.annotations.Test;

public class Test7 {

	@Test
	public void tc1()
	{
		String a = "Shiva Reddy";
		String dup="";
		LinkedHashSet<Character> lhs = new LinkedHashSet<Character>();
		for(int i =0;i<=a.length()-1;i++)
		{
			lhs.add(a.charAt(i));
		}
		for(Character c : lhs)
		{
			dup=dup+c;
		}
		String rev = dup.replace(" ","");
		System.out.println(rev);
	}
	
	@Test
	public void tc2()
	{
		String[] a = {"Shiva","Reddy","reddy","Shiva","Kalyani","Kandula","reddy"};
		//String[] dup={};
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		for(int i =0;i<a.length;i++)
		{
			lhs.add(a[i]);
		}
		for(String c : lhs)
		{
			System.out.println(c);
		}
	}
	
	@Test
	public void tc3()
	{
		String a = "abc123h5s3";
		int total=0;
		int count=0;
		for(int i=0;i<a.length();i++)
		{
			if(Character.isDigit(a.charAt(i))==true)
			{
				int temp = a.charAt(i)-'0';
				total=total+temp;
				count=count+1;
			}
			System.out.println(total);
		}
	}
	
	
}
