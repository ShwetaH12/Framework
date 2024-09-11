package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwitchWinCampWithProd {

	public SwitchWinCampWithProd(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//	@FindBy(id = "search_txt")
//	private WebElement searchProd;
//	
	
	@FindBy(css = "[name=\"search_text\"]")
	private WebElement searchProd;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//a[@id=\"1\"]")
	private WebElement selectSearchedProd;

	public WebElement getSearchProd() {
		return searchProd;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSelectSearchedProd() {
		return selectSearchedProd;
	}
	
	
	public void searchProdAdd(String prodNm)
	{
		searchProd.sendKeys(prodNm);
		searchBtn.click();
		selectSearchedProd.click();
	}
	
}
