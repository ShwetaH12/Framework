package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title=\"Create Product...\"]")
	private WebElement productPlusClick;
	
	@FindBy(name = "productname")
	private WebElement productname;
	
	@FindBy(linkText = "Products")
	private WebElement productList;
	

	
	//save
	@FindBy(css = "[title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;
	
	public WebElement getProductPlusClick() {
		return productPlusClick;
	}

	public WebElement getProductname() {
		return productname;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void ClickProductList()
	{
		productList.click();
	}
	public void AddProduct(String prodNm)
	{
		productPlusClick.click();
		productname.sendKeys(prodNm);
		saveBtn.click();
	}
	
}
