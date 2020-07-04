package Pages;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Library.functionalLibrary;
import Repository.RepositoryParser;

public class homePage extends functionalLibrary{
	RepositoryParser parser;
	WebDriver driver;
	HashMap<String, String> data;
	ExtentTest test;
	

	public homePage(RepositoryParser parser, WebDriver driver,	HashMap<String, String> data, ExtentTest test) {
		// TODO Auto-generated constructor stub
		super(parser,driver,data,test);
		this.driver = driver;
		this.parser = parser;
		this.data = data;
		this.test = test;
	}
	
	public void purchaseMobile(String itemname) throws IOException, InterruptedException
	{
		customsetText("txtbxsearch",itemname );
		customclick("btnsearch");
		Thread.sleep(1500);
		customclick("lnkfirstsearchitem");
		switchTab();
		customclick("lnkaddtocart");
		switchTabHome();
		customClearText("txtbxsearch");
		test.log(LogStatus.PASS, "Purchase mobile function executed successfully");
		test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Failed");
	}
	public void purchaseBook(String itemname) throws IOException, InterruptedException
	{
		customsetText("txtbxsearch",itemname );
		customclick("btnsearch");
		Thread.sleep(1500);
		customclick("lnkfirstsearchitem");
		switchTab();
		customclick("lnkaddtocart");
		switchTabHome();
		customClearText("txtbxsearch");
		test.log(LogStatus.PASS, "Purchase book function executed successfully");
		test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Failed");
	}
	public void purchaseLaptop(String itemname) throws IOException, InterruptedException
	{
		customsetText("txtbxsearch",itemname );
		customclick("btnsearch");
		Thread.sleep(1500);
		customclick("lnkfirstsearchitem");
		switchTab();
		customclick("lnkaddtocart");
		switchTabHome();
		customClearText("txtbxsearch");
		test.log(LogStatus.PASS, "Purchase Laptop function executed successfully");
		test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Failed");
	}
}
