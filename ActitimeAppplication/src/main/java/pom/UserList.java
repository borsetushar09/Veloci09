package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserList {
	
	private WebDriver driver2;

	@FindBy(xpath="//div[@id='ext-comp-1002']//span")
	private WebElement userText;
	
	public UserList(WebDriver driver1)
	{
		PageFactory.initElements(driver1,this);
		driver2 = driver1;
	}

	
	public String verifyUserButton() {
		String user = userText.getText();
		return user;
	}

}
