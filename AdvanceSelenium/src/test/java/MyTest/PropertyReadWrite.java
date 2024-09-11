package MyTest;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.hpsf.Property;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 

public class PropertyReadWrite {

	public static void main(String[] args) throws Throwable {

		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		FileInputStream fis=new FileInputStream("./src/test/resources/testCred.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String Url=pro.getProperty("url");
		String serch=pro.getProperty("search");
		
		driver.get(Url);
		Thread.sleep(3000);
		WebElement ab=driver.findElement(By.cssSelector("input[title=\"Search for Products, Brands and More\"]"));
		ab.sendKeys(serch);
		//ab.sendKeys(Keys.ENTER);
		//driver.findElement(By.partialLinkText("Printed, Embellished, Striped")).click();
		
		String title = driver.getTitle();
		
		FileOutputStream fos=new FileOutputStream("./src/test/resources/WriteData.properties");
		Properties pro2=new Properties();
		pro2.setProperty("Title", title);
		pro2.store(fos, "add title");
		driver.close();
		
	}

}
