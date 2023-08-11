Feature: Smoke test suite
  This feature check user login and registration functionality

  @SmokeTest
  Scenario: Login with registered user data
    Then I check the home page is displayed

    When I click login account button
    Then I check the user login page is displayed

    When I login with user credentials
    Then I check the user account page is displayed

  @SmokeTest
  Scenario: Register new user
    Then I check the home page is displayed

    When I click login account button
    And I open register new account page
    And I fill in and submit register new account form
    Then I check the user account page is displayed