package Generic_Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidatePage {

	public ValidatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateProductName(WebDriver driver)
	{
		String data=driver.findElement(By.xpath("//span[@id=\"dtlview_Product Name\"]")).getText();
		return data;
		
	}
	
	public String validateOrgName(WebDriver driver)
	{
		String data =driver.findElement(By.xpath("//span[@id=\"dtlview_Organization Name\"]")).getText();
		return data;
		
	}

	
	
	public String validateCmpName(WebDriver driver)
	{
		String data =driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();
		return data;
		
	}

	public String validateCmpProdName(WebDriver driver)
	{
		String data =driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();
		return data;
		
	}
	
	
}
