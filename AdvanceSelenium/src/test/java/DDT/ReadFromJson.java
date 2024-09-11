package DDT;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadFromJson {

	public static void main(String[] args) throws Throwable {

		File file = new File("./src/test/resources/jackson.json");
		
		ObjectMapper obj=new ObjectMapper();
		JsonNode data = obj.readTree(file);
		
		String url=data.get("url").asText();
		String user=data.get("username").asText();
		String pwd=data.get("password").asText();
		
		ChromeDriver driver=new ChromeDriver();
		driver.get(url);
		driver.findElement(By.id("user-name")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("login-button")).click();
		driver.close();
	}

}
