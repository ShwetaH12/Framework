package Generic_Utilities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WebDriver_Utility {
	
	/**
	 * this method is to maximize window
	 * @param driver
	 */
	public void maxWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * this method is to minimize window
	 * @param driver
	 */
	public void minWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}

	/**
	 * this method is to minimize window
	 * @param driver
	 */
	public void waitPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	}
	
	/**
	 * this method is to switch window
	 * @param driver
	 */
	public void switchWindow(WebDriver driver, String title)
	{
		Set<String> urls1 = driver.getWindowHandles();

		for(String win:urls1)
		{
			driver.switchTo().window(win);
			System.out.println(driver.getCurrentUrl());
			if(driver.getTitle().contains(title))
			{
				break;
			}
			
		}	
	}
	
	public void action()
	{
		
	}
	
}
