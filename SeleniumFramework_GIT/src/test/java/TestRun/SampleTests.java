package TestRun;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.createAccount;
import Repository.RepositoryParser;



public class SampleTests {
	RepositoryParser parser;
	WebDriver driver;
	ExtentTest test;
	ExtentReports report;
	
	@Test(dataProvider = "ToolData",threadPoolSize=7)
	public void setUp(HashMap<String, String> data) throws IOException, InterruptedException
	{
		//report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		String fileSuffix = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		report = new ExtentReports("D:\\RestWorkspace\\SeleniumFramework\\src\\test\\java\\Reports\\ExtentReportResults"+fileSuffix+".html");
		test = report.startTest("ExtentDemo");
		parser = new RepositoryParser("ObjectRepo.properties");
		if(data.get("ToRun").equalsIgnoreCase("Yes"))
		{
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		createAccount ca = new createAccount(parser,driver, data, test);
		ca.giveAddress();
		test.log(LogStatus.PASS, "Navigated to the specified URL");
		Thread.sleep(1500);
		}
		report.endTest(test);
		report.flush();
	}
	
	
	@DataProvider(name="ToolData", parallel=true)
	public Iterator<Object[]> getExcelData() throws IOException{
		ArrayList<HashMap> excelData;
		TestDataReader.readExcelFile objExcelFile = new TestDataReader.readExcelFile();
		//excelData = objExcelFile.readExcel("E:\\ExcelData","ToolsQATestData.xls","Sheet1");
		excelData = objExcelFile.readExcel("D:\\RestWorkspace\\SeleniumFramework\\src\\test\\java\\TestData\\","ToolsQATestData.xls","Sheet1");
		
		List<Object[]> dataArray = new ArrayList<Object[]>();
		for(HashMap data : excelData){
			dataArray.add(new Object[] { data });
			}
		return dataArray.iterator();
		
	}

}
