@tag
Feature: Second Feature file Testing

  @tag3
  Scenario: Second Feature file Testing
    Given User enters the Url "https://opensource-demo.orangehrmlive.com/"
    When User landed on webpage
    When User enters the Username as "Admin" and Password as "admin123"
    Then User click on submit button
    Then User take screenshot
    Then User landed on home page
    Then User close the Browser
