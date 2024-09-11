package xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpathUsingParent {

	public static void main(String[] args) throws Throwable {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.prokabaddi.com/standings");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//using child to parent and then to clild
		
		String won = driver.findElement(By.xpath("//p[text()='Bengal Warriorz']/../../../..//div[@class='table-data matches-won']")).getText();
		System.out.println(won);
		String diff = driver.findElement(By.xpath("//p[text()='Bengal Warriorz']/../../../..//div[@class='table-data score-diff']")).getText();
		System.out.println(diff);
		
		//using following-sibling
		String lost = driver.findElement(By.xpath("//p[text()='Puneri Paltan']/../../../following-sibling::div[@class='table-data matches-draw']")).getText();
		System.out.println(lost);
		driver.close();
	}

}
