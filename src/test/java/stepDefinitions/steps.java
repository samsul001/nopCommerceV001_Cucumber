package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageObjects.AddCustPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomer;

public class steps extends BaseClass {


	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		lp = new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) {
		driver.get(url);
	}

	@When("User enters Email as {string} and password as {string}")
	public void user_enters_Email_as_and_password_as(String usrEmailId, String pwd) {
		lp.setUsrEmailId(usrEmailId);
		lp.setPwd(pwd);
	}

	@When("Click on Login")
	public void click_on_Login() throws InterruptedException {
		lp.clickLoginBtn();
		Thread.sleep(4000);
	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String title) {
		if(driver.getPageSource().contains("Login was unsuccessful")) {
			driver.close();
			Assert.assertTrue(false);
		}else {
			Assert.assertEquals(title, driver.getTitle());
		}
	}

	@When("User click on logout link")
	public void user_click_on_logout_link() throws InterruptedException {
		lp.clickLogoutBtn();
		Thread.sleep(3000);
	}

	@Then("Close browser")
	public void close_browser() {
		driver.quit();
	}

	//Author : Samsul Alam
	//TestCase - TC002
	//Add new Customer
	@SuppressWarnings("deprecation")
	@Then("User can view Dashboard")
	public void user_can_view_Dashboard() {
		addCust = new AddCustPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	}

	@When("User clicks on customers menu")
	public void user_clicks_on_customers_menu() {
		addCust.clickOnCustomerMenu();
	}

	@When("User clicks on customers menu items")
	public void user_clicks_on_customers_menu_items() throws InterruptedException {
		addCust.clickonCustomerMenuItems();
		Thread.sleep(5000);
	}

	@When("User clicks on Add new button")
	public void user_clicks_on_Add_new_button() throws InterruptedException {
		addCust.clickonAddNewBtn();
		Thread.sleep(5000);
	}

	@SuppressWarnings("deprecation")
	@Then("User can view Add a new Customer page")
	public void user_can_view_Add_a_new_Customer_page() throws InterruptedException {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
		Thread.sleep(5000);
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		addCust.setEmailId(randomString());
		addCust.setPwd("test2584");
		addCust.setFirstName("Sam");
		addCust.setLastName("Alam");
		addCust.setDob("2/11/1990"); //Format: D/MM/YYYY
		addCust.setCompanyName("samsuPvt");
		addCust.setAdminCmnt("testing");

	}

	@When("Click on Save button")
	public void click_on_Save_button() throws InterruptedException {
		addCust.clickSaveBtn();
		Thread.sleep(5000);
	}

	@SuppressWarnings("deprecation")
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {

		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully."));
	}
	
	//Author : Samsul Alam
	//TestCase - TC003
	//Search Customer using EmailID
	@When("Enter EMail")
	public void enter_EMail() {
		searchCust = new SearchCustomer(driver);
		searchCust.setEmail("victoria_victoria@nopCommerce.com");
	}

	@When("Click on search button")
	public void click_on_search_button() {
		searchCust.clickSearch();
	}

	@Then("User should found Emailin the search table")
	public void user_should_found_Emailin_the_search_table() {
		boolean status = searchCust.searchCustomerByEmailId("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
	}
	
	//Author : Samsul Alam
	//TestCase - TC004
	//Search Customer using Name
	@When("Enter customer FirstName")
	public void enter_customer_FirstName() {
		searchCust = new SearchCustomer(driver);
	    searchCust.setFirstName("Victoria");
	}

	@When("Enter customer LastName")
	public void enter_customer_LastName() {
	    searchCust.setLastName("Terces");
	}

	@Then("User should found Name in the search table")
	public void user_should_found_Name_in_the_search_table() {
	   boolean status = searchCust.searchCutomerByName("Victoria Terces");
	   Assert.assertEquals(true, status);
	}

}
