@tag
Feature: Second Feature file Testing

  @tag1
  Scenario: Second Feature file Testing
    Given User enters the Url "https://opensource-demo.orangehrmlive.com/"
    When User landed on webpage
    Then User enter the username and password from Excel and Json File
    Then User click on submit button
    Then User take screenshot
    Then User landed on home page
    Then User close the Browser
