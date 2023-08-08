Feature: LoginFeature
  This feature deals with the login functionality of the application

  Scenario: Login with correct username and password
    Then I check the home page is displayed

    When I click login account button
    Then I check the user login page is displayed

    When I login with user credentials
    Then I check the user account page is displayed
