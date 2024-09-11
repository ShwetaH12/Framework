package DDT;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReadProperties {

	public static void main(String[] args) throws Throwable {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//read from properties
		
		FileInputStream fis = new FileInputStream("./src/test/resources/Credentials.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String URL=pro.getProperty("url");
		//String um=pro.getProperty("username");
		String pwd=pro.getProperty("pwd");
		driver.get(URL);
		driver.findElement(By.id("user-name")).sendKeys(pro.getProperty("username"));
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("login-button")).click();
		driver.close();
	}

}
