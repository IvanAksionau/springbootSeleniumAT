Feature: LoginFeature
  This feature deals with the login functionality of the application

  @RegressionTest
  Scenario: Create and order as not registered user
    Then I check the home page is displayed

    When I click shop now button
    Then I check the shop now page is displayed

    When I select card by name "Compressive leggings"
    Then I check the product page is displayed for product "Compressive leggings"

    When I click on the add to bag button
    Then I check the product mini cart page page is displayed for product "Compressive leggings"

    When I click on the checkout button
    Then I check the checkoutPage is displayed

    When I fill the checkout form
    When I submit the checkout form
    Then I check the phone number is not verified popup is displayed

    When I click send code button
    When I type verify code value
    When I click verify code button
