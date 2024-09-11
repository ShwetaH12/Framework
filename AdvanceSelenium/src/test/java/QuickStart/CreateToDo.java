package QuickStart;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateToDo {

	public static void main(String[] args) throws Throwable {


		ChromeDriver driver=new ChromeDriver();
		
		FileInputStream fis=new FileInputStream("./src/main/resources/userDetails1.properties");
		Properties pro=new Properties();
		pro.load(fis);
		
		String url = pro.getProperty("url");
		driver.get(url);
		driver.manage().window().maximize();
		
		String userNm=pro.getProperty("user");
		String pwd=pro.getProperty("password");
		
		driver.findElement(By.name("user_name")).sendKeys(userNm);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		
		WebElement drpdwn = driver.findElement(By.id("qccombo"));
		
		Select s= new Select(drpdwn);
		s.selectByIndex(3);
		Thread.sleep(2000);
		
		
		driver.findElement(By.name("subject")).sendKeys("testing");
	}

}
