package TestNgPractise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvideEx1 {



	//DataProvider:-Executing same method/script multiple times with different set of data
	//Return Two Dimentional Object Array
	
	//Booking Bus Tickets
	
@Test(dataProvider = "dataProvider_BookTickets")
	public void bookTickets(String src,String dest,int no)
	{
		System.out.println("Book Tickets from : "+src+ " to :" +dest+" ,people :"+no);
	}
	
@DataProvider
	public Object[][] dataProvider_BookTickets()
	{
		Object[][] objArr = new Object[3][3];
		
		objArr[0][0]="Bangalore";
		objArr[0][1]="Goa";
		objArr[0][2]=4;

		objArr[1][0]="Bangalore";
		objArr[1][1]="mysore";
		objArr[1][2]=5;

		objArr[2][0]="Bangalore";
		objArr[2][1]="chennai";
		objArr[2][2]=6;

	
		return objArr;
		
	}
	
}	
	
