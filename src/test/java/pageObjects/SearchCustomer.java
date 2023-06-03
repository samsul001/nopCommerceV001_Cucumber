package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomer {
	
	WebDriver ldriver;
	WaitHelper waithelper;

	public SearchCustomer(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		waithelper = new WaitHelper(ldriver);
	}
	
	@FindBy(how = How.ID, using = "SearchEmail")
	WebElement txtEmail;
	
	@FindBy(how = How.ID, using = "SearchFirstName")
	WebElement txtFirstName;
	
	@FindBy(how = How.ID, using = "SearchLastName")
	WebElement txtLastName;
	
	@FindBy(how = How.ID, using = "SearchMonthOfBirth")
	WebElement drpdobMonth;
	
	@FindBy(how = How.ID, using = "SearchDayOfBirth")
	WebElement drpdobDay;
	
	@FindBy(how = How.ID, using = "SearchCompany")
	WebElement txtCompany;
	
	@FindBy(how = How.XPATH, using = "//div[@class='k-multiselect-wrap k-floatwrap']")
	WebElement txtCustomerRoles;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Administrators')]")
	WebElement listitemAdministrators;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Registered')]")
	WebElement listitemRegistered;
	
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Guests')]")
	WebElement listitemGuests;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Vendors')]")
	WebElement listitemVendors;
	
	@FindBy(how = How.ID, using ="search-customers")
	WebElement btnSearch;
	
	@FindBy(how = How.XPATH, using = "//table[@role='grid']")
	WebElement tblSearchResults;
	
	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']")
	WebElement table;
	
	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;
	
	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> tableColumns;
	
	public void setEmail(String email) {
		waithelper.waitForElement(txtEmail, 10);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void setFirstName(String fName) {
		waithelper.waitForElement(txtFirstName, 10);
		txtFirstName.clear();
		txtFirstName.sendKeys(fName);
	}
	
	public void setLastName(String lName) {
		waithelper.waitForElement(txtLastName, 10);
		txtLastName.clear();
		txtLastName.sendKeys(lName);
	}
	
	public void clickSearch() {
		waithelper.waitForElement(btnSearch, 10);
		btnSearch.click();
	}
	
	public int getNoOfRows() {
		return tableRows.size();
	}
	
	public int getNoOfColumns() {
		return tableColumns.size();
	}
	
	public boolean searchCustomerByEmailId(String email) {
		Boolean flag = false;
		for(int i=1;i<getNoOfRows();i++) {
			String emailId = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
			if(emailId.equals(email)) {
				flag = true;
			}
		}
		return flag;
	}
	
	public boolean searchCutomerByName(String Name) {
		boolean flag = false;
		for(int i=1; i<getNoOfRows();i++) {
			String name = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[3]")).getText();
			String[] actualNames = name.split(" ");
			
			String[] expectedNames = Name.split(" ");
			
			if(actualNames[0].equals(expectedNames[0]) && actualNames[1].equals(expectedNames[1])){
				flag = true;
			}
			
		}
		return flag;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
