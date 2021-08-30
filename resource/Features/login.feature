Feature: Feature to test login functionality

  Scenario: Check login is successful with valid credintials
    Given user is login page
    When user enters correct username and password
    And clicks  on loging button
    Then user is navigated to home page
