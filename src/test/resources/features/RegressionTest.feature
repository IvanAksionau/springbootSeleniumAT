Feature: Regression test suite
  This feature checks the app functionality

  @RegressionTest
  Scenario: Register new user
    Then I check the home page is displayed

    When I click login account button
    And I open register new account page
    And I fill in and submit register new account form
    Then I check the user account page is displayed

  @RegressionTest
  Scenario: Create and order as not registered user with cash on delivery payment method
    Then I check the home page is displayed

    When I click shop now button
    Then I check the shop now page is displayed

    When I select card by name "Compressive leggings"
    Then I check the product page is displayed for product "Compressive leggings"

    When I click on the add to bag button
    Then I check the product side bar page is displayed for product "Compressive leggings"

    When I click on the checkout button
    Then I check the shippingPage is displayed

    When I fill the checkout form
    When I submit the checkout form
    Then I check the phone number is not verified popup is displayed

    When I click send code button
    When I type verify code value
    When I click verify code button
    Then I check the delivery page is displayed

    When I click continue to payment button
    Then I check the paymentPage page is displayed

    When I select cash on delivery payment method
    And I select cash on delivery payment method
    And I click submit order button
    Then I check the order page is displayed
