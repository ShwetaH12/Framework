package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.File_Utitity;
import Generic_Utilities.WebDriver_Utility;

public class AddDeleteProduct {

	public static void main(String[] args) throws Throwable {

		
		ChromeDriver driver=new ChromeDriver();
		WebDriver_Utility wlib=new WebDriver_Utility();

		
		File_Utitity flib= new File_Utitity();
		String url=flib.getPropertiesData("url");
		String userNm=flib.getPropertiesData("user");
		String pwd=flib.getPropertiesData("password");
		
		driver.get(url);
		wlib.maxWindow(driver);
		
		String mainpage=driver.getWindowHandle();
		
		
		driver.findElement(By.name("user_name")).sendKeys(userNm);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
		
		//driver.findElement(By.cssSelector("input[value=\"5\"]")).click();
		driver.findElement(By.name("selected_id")).click();
		
		driver.findElement(By.cssSelector("input[class=\"crmbutton small delete\"]")).click();
		
		Alert a=driver.switchTo().alert();
		a.accept();
	
		driver.switchTo().window(mainpage);
		driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
	}

}
