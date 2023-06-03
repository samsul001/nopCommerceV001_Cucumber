package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustPage {
	
	WebDriver ldriver;
	
	public AddCustPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	By txtDashboard = By.xpath("//h1[contains(text(), 'Dashboard')]");
	
	By lnkCustomers_menu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By lnkCustomers_menuItems = By.xpath("//p[text()=' Customers']");
	
	By btnAddNew = By.partialLinkText("new");
	
	By txtEmail = By.xpath("//input[@id='Email']");
	By txtPwd = By.xpath("//input[@id='Password']");
	
	By txtCustomerRoles = By.xpath("//ul[@class='k-reset']//following-sibling::input[@class='k-input']");
	
	By lstitemRegistered = By.xpath("//li[contains(text(),'Registered')]");
	By lstitemGuests = By.xpath("//li[contains(text(),'Guests')]");
	By lstitemVendors = By.xpath("//li[contains(text(),'Vendors')]");
	By lstitemAdminstrators = By.xpath("//li[contains(text(),'Administrators')]");
	
	By drpmngrOfVendor = By.xpath("//select[@id='VendorId']");
	
	By rdMaleGender = By.xpath("//input[@id='Gender_Male']");
	By rdFemaleGender = By.xpath("//input[@id='Gender_Female']");
	
	By txtFirstName = By.xpath("//input[@id='FirstName']");
	By txtLastName = By.xpath("//input[@id='LastName']");
	
	By txtDob = By.xpath("//input[@id='DateOfBirth']");
	By txtCompanyName = By.xpath("//input[@id='Company']");
	By txtAdminComment = By.xpath("//textarea[@id='AdminComment']");
	By btnSave = By.xpath("//button[@name='save']");
	
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	
	public void clickOnCustomerMenu() {
		ldriver.findElement(lnkCustomers_menu).click();
	}
	
	public void clickonCustomerMenuItems() {
		ldriver.findElement(lnkCustomers_menuItems).click();
	}
	
	public void clickonAddNewBtn() {
		ldriver.findElement(btnAddNew).click();
	}
	
	public void setEmailId(String email) {
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPwd(String pwd) {
		ldriver.findElement(txtPwd).sendKeys(pwd);
	}
	
	public void setCustomerRoles(String roles) {
		ldriver.findElement(txtCustomerRoles).click();
		
		WebElement lstItem;
		
		if(roles.equals("Administrators")) {
			lstItem = ldriver.findElement(lstitemAdminstrators);
		}
		else if(roles.equals("Guests")) {
			lstItem = ldriver.findElement(lstitemGuests);
		}
		else if(roles.equals("Registred")) {
			lstItem = ldriver.findElement(lstitemRegistered);
		}
		else {
			lstItem = ldriver.findElement(lstitemGuests);
		}
		
		//lstItem.click();
		
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("argument[0].click();", lstItem);
				
	}
	
	public void setManagerOfVendor(String value) {
		Select drp = new Select(ldriver.findElement(drpmngrOfVendor));
		drp.selectByVisibleText(value);
	}
	
	public void setGender(String gender) {
		if(gender.equals("Male")) {
			ldriver.findElement(rdMaleGender).click();
		}
		else if(gender.equals("Female")) {
			ldriver.findElement(rdFemaleGender).click();
		}
		else {
			ldriver.findElement(rdMaleGender).click();
		}
	}
	
	public void setFirstName(String fName) {
		ldriver.findElement(txtFirstName).sendKeys(fName);
	}
	
	public void setLastName(String lName) {
		ldriver.findElement(txtLastName).sendKeys(lName);
	}
	
	public void setDob(String dob) {
		ldriver.findElement(txtDob).sendKeys(dob);
	}
	
	public void setCompanyName(String companyName) {
		ldriver.findElement(txtCompanyName).sendKeys(companyName);
	}
	
	public void setAdminCmnt(String adminCmt) {
		ldriver.findElement(txtAdminComment).sendKeys(adminCmt);
	}
	
	public void clickSaveBtn() {
		ldriver.findElement(btnSave).click();
	}
	
	
	
}
