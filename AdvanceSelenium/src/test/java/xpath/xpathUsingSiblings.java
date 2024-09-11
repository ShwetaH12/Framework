package xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class xpathUsingSiblings {

	public static void main(String[] args) throws Throwable {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//using child to parent and then to clild
		driver.findElement(By.name("q")).sendKeys("iphone15");
	Thread.sleep(2000);
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
		String won = driver.findElement(By.xpath("//div[text()='Apple iPhone 15 (Black, 128 GB)']/../..//div[@class='Nx9bqj _4b5DiR']")).getText();
		System.out.println(won);
		
		driver.close();
	}

}
