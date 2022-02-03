package pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.Utility;

public class LoginPage {
	
	private WebDriver driver2;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement username;
	
	@FindBy(xpath="//input[@name='pwd']")
	private WebElement password;
	
	@FindBy(xpath="//div[text()='Login ']")
	private WebElement loginbutton;
	
	public LoginPage(WebDriver driver1)
	{
		PageFactory.initElements(driver1,this);
		driver2 = driver1;
	}
	
	public void sendUsername() throws EncryptedDocumentException, IOException {
	String user = Utility.getDataFromExcelsheet(1, 0);
	
	username.sendKeys(user);
	}

	public void sendPassword() throws EncryptedDocumentException, IOException {
		String pass = Utility.getDataFromExcelsheet(1, 1);
		password.sendKeys(pass);
	}
	
	public void clickOnLoginButton() {
		loginbutton.click();
	}

	}


	


