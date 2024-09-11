package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	//1.click on Campaigns from more options
	@FindBy(linkText = "More")
	private WebElement moreOptions;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsOption;
	
		
	//2.click on Organizations 
	@FindBy(linkText =  "Organizations")
	private WebElement organizations;
	
		
	//sign-out 
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement adminImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOut;
	
	//Product click
	@FindBy(linkText = "Products")
	private WebElement productClick;
	
	
	public WebElement getMoreOptions() {
		return moreOptions;
	}

	public WebElement getCampaignsOption() {
		return campaignsOption;
	}

	public WebElement getOrganizations() {
		return organizations;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignOut() {
		return SignOut;
	}

	public WebElement getProductClick() {
		return productClick;
	}

	public void ClickCampaign(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.moveToElement(moreOptions).click().perform();
		a.moveToElement(campaignsOption).click().perform();
	}
	public void ClickProductLink()
	{
		productClick.click();
	}
	
	public void ClickOrg()
	{
		organizations.click();
	}
				
	public void SignOut(WebDriver driver)
	{
		adminImg.click();
		SignOut.click();
	}
	
	
}
