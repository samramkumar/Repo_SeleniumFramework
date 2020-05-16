package Pages;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Library.functionalLibrary;
import Repository.RepositoryParser;

public class createAccount extends functionalLibrary{
	RepositoryParser parser;
	WebDriver driver;
	HashMap<String, String> data;
	ExtentTest test;
	

	public createAccount(RepositoryParser parser, WebDriver driver,	HashMap<String, String> data, ExtentTest test) {
		// TODO Auto-generated constructor stub
		super(parser,driver,data,test);
		this.driver = driver;
		this.parser = parser;
		this.data = data;
		this.test = test;
	}
	
	public void giveAddress() throws IOException, InterruptedException
	{
		customclick("lnkMyaddress");
		Thread.sleep(1500);
		customsetText("txtbxemailcreate", data.get("Name"));
		driver.findElement(parser.getbjectLocator("btnSubmit")).click();
		test.log(LogStatus.PASS, "Give Address function executed successfully");
		test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Failed");
	}

	public void giveAddress1() throws IOException, InterruptedException
	{
		System.out.println("Welcome");
		functionalLibrary fb = new functionalLibrary(parser,driver, data,test);
		fb.customclick("lnkMyaddress");
		fb.customsetText("txtbxemailcreate", data.get("Name"));
		fb.customclick("btnSubmit");
		test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Failed");
		//webdriver.findElement(parser.getbjectLocator("lnkMyaddress")).click();
		//Thread.sleep(1500);
		//webdriver.findElement(parser.getbjectLocator("txtbxemailcreate")).sendKeys(data.get("Name"));
		//webdriver.findElement(parser.getbjectLocator("btnSubmit")).click();
		//webdriver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(data.get("Name"));
		//webdriver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
	}
	
	


}
