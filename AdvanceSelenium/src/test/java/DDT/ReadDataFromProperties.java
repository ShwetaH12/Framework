package DDT;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class ReadDataFromProperties {

public static void main(String[] args) throws Throwable {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//Normal Approach
//		driver.get("https://www.saucedemo.com/v1/");
//      driver.findElement(http://By.name("user-name")).sendKeys("standard_user");
//		driver.findElement(http://By.id("password")).sendKeys("secret_sauce");
//		driver.findElement(http://By.id("login-button")).click();
		
//------------------------------------------------------------------------------------------------		
		//Reading data from External Resource---->Properties File
		
	//	step1:-get the java representation object of the physical file
	FileInputStream fis = new FileInputStream("./src/test/resources/Credentials.properties");
	
	//step2:-create an object to property class to load all the keys
	    Properties pro = new Properties();
	    pro.load(fis);
	    
	    //step3:-read the value using getProperty()
	    String URL = pro.getProperty("url");
	    String USERNAME = pro.getProperty("username");
	    String PASSWORD = pro.getProperty("password");
	  
	    driver.get(URL);
	    
	    driver.findElement(By.name("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		//driver.close();
		
//----------------------------------------------------------------------------------------
//Writing data to properties file
		
		
		FileOutputStream fos =new FileOutputStream("./src/test/resources/WriteData.properties");
		Properties pro2=new Properties();
		pro2.setProperty("url", "https://www.saucedemo.com/v1/");
		pro2.setProperty("username", "standard_user");
		pro2.setProperty("pwd", "secret_sauce");
		
		pro2.store(fos, "write user data");
		
		
		
	}

}
