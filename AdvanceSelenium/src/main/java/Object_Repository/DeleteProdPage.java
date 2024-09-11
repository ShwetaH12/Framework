package Object_Repository;
import java.util.List;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProdPage {

	public DeleteProdPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[class=\"crmbutton small delete\"]")
	private WebElement deleteBtn;
	
	public void selectProdCheckBox(WebDriver driver,String prodname)
	{
		driver.findElement(By.xpath("//table[@class=\"lvt small\"]/tbody/tr//a[text()='"+prodname+"']/../preceding-sibling::td//input[@type=\"checkbox\"]")).click();

	}
	
	public void deletePrdBtn(WebDriver driver)
	{
		deleteBtn.click();
		Alert a=driver.switchTo().alert();
		a.accept();
	}
	
	public void validateProdDel(WebDriver driver,String prdName)
	{
		List<WebElement> productList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
		
		 boolean flag=false;
			 
		 for(WebElement prdName1:productList)
		 {
			String actData = prdName1.getText();
			System.out.println(actData);
			if(actData.equalsIgnoreCase(prdName))
			{
				flag=true;
				break;
			}
		 }
		 System.out.println(flag);
		if(flag=false)
		{
			System.out.println("product data is deleted");
		}else {
			System.out.println("product data is not deleted");
		}

	}
	
	
	public void validatePrdDeleted(WebDriver driver,String prdName)
	{
		List<WebElement> productList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
		
		 boolean flag=false;
			 
		 for(WebElement prdName1:productList)
		 {
			String actData = prdName1.getText();
			System.out.println(actData);
			if(actData.equalsIgnoreCase(prdName))
			{
				flag=true;
				break;
			}
		 }
		 System.out.println(flag);
		if(!flag)
		{
			System.out.println("product data is deleted");
		}else {
			System.out.println("product data is not deleted");
		}
	}
}
