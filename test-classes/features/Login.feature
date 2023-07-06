Feature: LoginFeature
  This feature deals with the login functionality of the application

  Scenario: Login with correct username and password 1
    Given I click login in Home Page
    And I enter the following for Login
      | username | password      |
      | admin    | password      |
    And I click login button
    Then I should see the userform page


  Scenario: Login with correct username and password 2
    Given I click login in Home Page
    And I enter the following for Login
      | username | password      |
      | admin    | password2      |
    And I click login button
    Then I should see the userform page
