package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(name = "user_name")
	private WebElement user;
	
	@FindBy(name = "user_password")
	private WebElement pwd;
	
	@FindBy(id = "submitButton")
	private WebElement loginBtn;

	public WebElement getUser() {
		return user;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//businessLogin
	public void LoginApp(String userNm,String password)
	{
		user.sendKeys(userNm);
		pwd.sendKeys(password);
		loginBtn.click();
	}

}
