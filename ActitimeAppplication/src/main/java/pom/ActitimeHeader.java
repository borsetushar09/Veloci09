package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActitimeHeader {
	//sainath//
	private WebDriver driver2;
	  
	@FindBy(xpath="//a[@class='content users']")
	private WebElement user;
	
	@FindBy(xpath="//a[@class='content reports']")
	private WebElement report;
	
	@FindBy(xpath="//a[@class='content tasks']")
	private WebElement tasks;
	
	@FindBy(xpath="//a[@id='logoutLink']")
	private WebElement logout;
	
	public ActitimeHeader(WebDriver driver1)
	{
		PageFactory.initElements(driver1,this);
		driver2 = driver1;
	}
	
	public void clickOnUserTab() {
		
		WebDriverWait wait = new WebDriverWait(driver2,20);
		wait.until(ExpectedConditions.visibilityOf(user));
		user.click();
	}
	
	public void clickOnReportTab() {
		report.click();
	}
	
	public void clickOnTasksTab() {
		tasks.click();
	}
	
	public void clickOnLogOutTab() {
		logout.click();
	}
		
	}

	
	


