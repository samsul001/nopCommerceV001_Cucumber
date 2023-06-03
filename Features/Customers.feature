Feature: Customer

 Background: Below are common steps
 		Given User launch chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then User can view Dashboard	
    When User clicks on customers menu
    And User clicks on customers menu items

  Scenario: Add a New Customer
    And User clicks on Add new button
    Then User can view Add a new Customer page
    When User enter customer info
    And Click on Save button
    Then User can view confirmation message "The new customer has been added successfully."
    And Close browser
    
   Scenario: Search Customer by EmailID
   	And Enter EMail
   	When Click on search button
   	Then User should found Emailin the search table
   	And Close browser
   	
   	
   Scenario: Search Customer by Name
   	And Enter customer FirstName
   	And Enter customer LastName
   	When Click on search button
   	Then User should found Name in the search table
   	And Close browser