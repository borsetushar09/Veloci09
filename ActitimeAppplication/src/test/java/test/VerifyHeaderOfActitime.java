package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Base;
import pom.ActitimeHeader;
import pom.LoginPage;
import pom.UserList;
import util.Utility;


public class VerifyHeaderOfActitime extends Base {
	
	private WebDriver driver;
	private ActitimeHeader actitimeHeader;
    private LoginPage loginPage;
    private UserList userList;
    private SoftAssert softAssert;
    private int testID;
    
    static ExtentTest test;
	static ExtentHtmlReporter reporter;

	@BeforeTest
	@Parameters("browser")
	public void lauchBrowser(String browser) {
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		System.out.println("lauchBrowser");
		
		
		if(browser.equals("chrome"))
		{
          driver =   Base.openChromeBrowser();
        }
		else 
		{
             driver =  Base.openFirefoxBrowser();
	    }
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}
	
	@BeforeClass
	public void initializePomclasses() {
		  loginPage = new LoginPage(driver);
		  actitimeHeader = new ActitimeHeader(driver);
		    userList = new UserList (driver); 
		
	}
	
	@BeforeMethod
	public void loginActiTime() throws EncryptedDocumentException, IOException {
		System.out.println("loginActiTime");
		driver.get("http://localhost/login.do");
		
	    loginPage.sendUsername();
		loginPage.sendPassword();
		loginPage.clickOnLoginButton();
	    
	   
	    softAssert=new SoftAssert();
	}
	
		
	@Test
	public void toVerifyUserTab() {
		testID=101;
		System.out.println("toVerifyUserTab");
   
		actitimeHeader.clickOnUserTab();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		Assert.assertEquals(url,"http://localhost/administration/userlist.do");
		
		String title = driver.getTitle(); //nbsp-non breakable space
		
		softAssert.assertEquals(title,"actiTIME - User List");
		
	String buttonname =	userList.verifyUserButton();
	softAssert.assertEquals(buttonname, "User");
	softAssert.assertAll();
		
	}
	

	
	@Test
	public void toVerifyReportTab () {
		testID=102;
		System.out.println("toVerifyReportTab"); 
          actitimeHeader.clickOnReportTab();
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}

	
	@AfterMethod
	public void logoutActitimeHeader(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus())
		{
		Utility.saveScreenshot(driver,testID);
		}
		System.out.println("logoutActitimeHeader");
		actitimeHeader.clickOnLogOutTab();
		
		}
	
	
	@AfterClass
	public void Clearobjects() {
		  loginPage =null;
		  actitimeHeader = null;
		  userList = null;
	}
	
	@AfterTest
	public void closeBrowser() {
	System.out.println("closeBrowser");
	driver.quit();
	driver=null;
	System.gc(); //CLear all object (no refrence object)
		
	}
	

	}


