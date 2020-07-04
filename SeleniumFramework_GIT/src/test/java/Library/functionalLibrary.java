package Library;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Repository.RepositoryParser;

public class functionalLibrary {
	RepositoryParser parser;
	WebDriver driver;
	HashMap<String, String> data;
	ExtentTest test;
	
	public functionalLibrary(RepositoryParser parser, WebDriver driver,	HashMap<String, String> data, ExtentTest test) {
		// TODO Auto-generated constructor stub
		//super(driver,parser,data);
		this.driver = driver;
		this.parser = parser;
		this.data = data;
		this.test = test;
	}
	public void customclick(String identifierr) throws InterruptedException{
		Thread.sleep(1500);
		driver.findElement(parser.getbjectLocator(identifierr)).click();
		test.log(LogStatus.PASS, identifierr+" link is clicked");
	}
	public void customsetText(String identifierr,String passdata) throws InterruptedException{
		Thread.sleep(1500);
		driver.findElement(parser.getbjectLocator(identifierr)).sendKeys(passdata);
		test.log(LogStatus.PASS, identifierr+" text field is passed with data " +passdata);
	}
	public void customClearText(String identifierr) throws InterruptedException{
		Thread.sleep(1500);
		driver.findElement(parser.getbjectLocator(identifierr)).clear();
		test.log(LogStatus.PASS, identifierr+" text field is cleared");
	}
	
	
	public void switchTab(){
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window's handle -> " + parentWindowHandle);
		 
		Set<String> allWindowHandles = driver.getWindowHandles();
		String lastWindowHandle = "";
		for(String handle : allWindowHandles)
		{
		System.out.println("Switching to window - > " + handle);
		driver.switchTo().window(handle); //Switch to the desired window first and then execute commands using driver
		lastWindowHandle = handle;
		}
		driver.switchTo().window(lastWindowHandle); 
	}
	public void switchTabHome(){
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window's handle -> " + parentWindowHandle);
		 
		Set<String> allWindowHandles = driver.getWindowHandles();
		String lastWindowHandle = "";
		for(String handle : allWindowHandles)
		{
		System.out.println("Switching to window - > " + handle);
		driver.switchTo().window(handle); //Switch to the desired window first and then execute commands using driver
		lastWindowHandle = handle;
		break;
		}
		driver.switchTo().window(lastWindowHandle); 
		driver.navigate().refresh();
	}
	
	public static String capture(WebDriver driver) throws IOException {
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	File Dest = new File("D:\\RestWorkspace\\SeleniumFramework\\src\\test\\java\\Reports\\" + System.currentTimeMillis()
	+ ".png");
	
	String errflpath = Dest.getAbsolutePath();
	FileUtils.copyFile(scrFile, Dest);
	return errflpath;
	}

}
