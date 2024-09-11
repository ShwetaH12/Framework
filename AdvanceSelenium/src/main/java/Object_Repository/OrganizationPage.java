package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css = "[src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement plusOrg;
	
	@FindBy(name = "accountname")
	private WebElement accountname;
	
	@FindBy(id = "phone")
	private WebElement phone;
	
	@FindBy(id = "email1")
	private WebElement email1;
	
	//save
	@FindBy(css = "[title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;
	
	public void ClickPlusOrg()
	{
		plusOrg.click();
	}
	
	public void AddSaveOrg(String accnm,String phoneNo,String email)
	{
		accountname.sendKeys(accnm);
		phone.sendKeys(phoneNo);
		email1.sendKeys(email);
		saveBtn.click();
	}
}
