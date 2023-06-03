package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id ="Email")
	WebElement txtEmail;
	
	@FindBy(id = "Password")
	WebElement txtPwd;
	
	@FindBy(xpath = "//button[text()='Log in']")
	WebElement btnLogin;
	
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement btnLogout;
	
	public void setUsrEmailId(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void setPwd(String pwd) {
		txtPwd.clear();
		txtPwd.sendKeys(pwd);
	}
	
	public void clickLoginBtn() {
		btnLogin.click();
	}
	
	public void clickLogoutBtn() {
		btnLogout.click();
	}

}
