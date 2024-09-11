package TestNgPractise;

import org.testng.annotations.Test;

public class SampleTest {
	
	@Test(priority=0,invocationCount = 2)
	public void createProductTest()
	{
		System.out.println("Product Created");
	}

	@Test(priority=-1,dependsOnMethods = "createProductTest")
	public void modifyProductTest()
	{
		System.out.println("Product Modified");
	}
	
	@Test(invocationCount = 2)
	public void deleteProductTest()
	{
		System.out.println("Product Deleted");
	}
}
