package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {

	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement plusSign;
	
	@FindBy(name = "campaignname")
	private WebElement campaignname;
	
	//save
	@FindBy(css = "[title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement prodPlusInCmp;
	
	public WebElement getPlusSign() {
		return plusSign;
	}

	public WebElement getCampaignname() {
		return campaignname;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getProdPlusInCmp() {
		return prodPlusInCmp;
	}

	public void AddCampaign(String campName)
	{
		plusSign.click();
		campaignname.sendKeys(campName);
		saveBtn.click();
	}
	public void AddCampaignWithProd(String campName)
	{
		plusSign.click();
		campaignname.sendKeys(campName);
	}
	
	
}
