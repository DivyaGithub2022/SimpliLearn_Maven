package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	//WebDriver pageDriver;
	
	//============================ Objects ======================================
	
	
		@FindBy(linkText="Log in")
		WebElement loginLink;
		
		@FindBy(name="user_login")
		WebElement userName;
		
		@FindBy(id="password")
		WebElement password;
		
		@FindBy(className="rememberMe")
		WebElement RememberMe;
		
		@FindBy(name="btn_login")
		WebElement loginBtn;
		
		//============================ Methods ==============================================
		
		public LoginPage(WebDriver driver) {
			
			this.driver = driver;
			PageFactory.initElements(driver, this);
			
			/* OR 
			
			pageDriver = driver;
			PageFactory.initElements(driver, pageDriver);*/
		}
		
		public void LoginFunction(String UserNameVal,String PwdVal) {
		
			loginLink.click();
			userName.sendKeys(UserNameVal);
			password.sendKeys(PwdVal);
			RememberMe.click();
			loginBtn.click();
			
		}

}
