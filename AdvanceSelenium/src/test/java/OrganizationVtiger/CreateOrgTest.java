//package OrganizationVtiger;
//
//import java.io.FileInputStream;
//import java.util.Properties;
//import java.util.Random;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//
//
//public class CreateOrgTest  extends BaseClass{
//
//	@Test(groups = "smoke")
//	public void createOrg() throws Throwable {
//
//		//WebDriver driver=null;
//		
//		WebDriver_Utility wlib=new WebDriver_Utility();
//
//		File_Utitity flib= new File_Utitity();
//			
//		HomePage home= new HomePage(driver);
//		home.ClickOrg();
//		
//		Java_Utilities jlib=new Java_Utilities();
//		int ranInt=	jlib.getRandomNum();
//		
//		Excel_Utility elib=new Excel_Utility();
//		String orgName = elib.getExcelData("Sheet2", 0, 0)+ranInt;
//		String phoneno = elib.getExcelData("Sheet2", 1, 1);
//		String email = elib.getExcelData("Sheet2", 2, 2);
//		
//	
//		OrganizationPage org=new OrganizationPage(driver);
//		org.ClickPlusOrg();
//		org.AddSaveOrg(orgName, phoneno, email);
//		
//		wlib.waitPageLoad(driver);
//		Thread.sleep(3000);
//		
//		ValidatePage validP=new ValidatePage(driver);
//		String expData=validP.validateOrgName(driver);
//		Assert.assertEquals(expData, orgName, "Assert pass");
//		
//	
//	
//	}
//	
//	
//		
//		
//
//}
