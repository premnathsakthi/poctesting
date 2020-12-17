package machinetest;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import inputs.ExcelValue;

import wrappers.GenericWrappers;

public class MachineTask extends GenericWrappers {
	@Test(dataProvider="fetchData",dataProviderClass=ExcelValue.class)
	
	public void OnlineShopping(String SearchKeyword,String Searchkey,String EmailAddress,String Firstname,String lastname,String password,String First,String last,String company,String Address,String City,String Zipcode,String MobileNo) {
		String document;
		
		invokeApp("chrome", "http://automationpractice.com/index.php");
		waitProperty(5000);
		enterById("search_query_top",SearchKeyword );
		clickByName("submit_search");
		String url =getURL();
		if(url.equals("http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=Printed+Summer+Dress&submit_search=")) {
			System.out.println("Is verified");
		}
		else {
			System.out.println("Is not verified");
		}
		System.out.println("URL"+url);
		clickByXpath("//img[@title='Printed Summer Dress']");
		clickByXpath("//button[@type='submit']");
		waitProperty(5000);
		clickByXpath("//span[@title='Continue shopping']");
		waitProperty(5000);
		navigatebackward();
		getclearbyid("search_query_top");
		waitProperty(5000);
		enterByName("search_query",Searchkey);
		clickByName("submit_search");
		clickByXpath("//img[@title='Blouse']");
		clickByName("Submit");
		waitProperty(5000);
		clickByXpath("//a[@title='Proceed to checkout']");
		waitProperty(5000);
		enterByXpath("//html/body",  Keys.PAGE_DOWN);
		waitProperty(5000);
		clickByXpath("/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]");
		waitProperty(5000);
		enterById("email_create",EmailAddress );
		clickById("SubmitCreate");
		waitProperty(5000);
		clickByName("id_gender");
		enterById("customer_firstname", Firstname);
		enterById("customer_lastname", lastname);
		enterById("passwd",password );
		selectVisibileTextById("days","7  ");
		selectVisibileTextById("months", "June ");
		selectVisibileTextById("years","1995  " );
		enterById("firstname", First);
		enterById("lastname",last );
		enterById("company", company);
		enterById("address1", Address);
		enterById("city", City);
		selectVisibileTextById("id_state", "Texas");
		enterById("postcode", Zipcode);
		enterById("phone_mobile",MobileNo );
		clickById("submitAccount");
		enterByXpath("//html/body",  Keys.PAGE_DOWN);
		clickByName("processAddress");
		waitProperty(5000);
		clickById("cgv");
		clickByName("processCarrier");
		
		
		
		
	}
	
	

}
