Feature: Login
 Background: Below are common steps
 		Given User launch chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    
  Scenario: Successful Login with Valid Credentials    
    And User enters Email as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on logout link
    Then Page Title should be "Your store. Login"
    And Close browser
    
  Scenario Outline: Login Data Driven
    And User enters Email as "<email>" and password as "<password>"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on logout link
    Then Page Title should be "Your store. Login"
    And Close browser
    
    Examples:
    	| email | password |
    	| admin@yourstore.com | admin |
    	| admin@yourstore.com | admin123 |