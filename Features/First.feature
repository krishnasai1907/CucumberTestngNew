@tag
Feature: To test the data

  @tag1
  Scenario: Title of your scenario
    Given User enters the Url "https://opensource-demo.orangehrmlive.com/"
    When User landed on webpage
    Then User enter the username and password from Excel and Json File
    Then User click on submit button
    Then User take screenshot
    Then User landed on home page
    Then User close the Browser
       #@tag2
  #Scenario Outline: Title 2 of your scenario
  #
    #Given User enters the Url "https://opensource-demo.orangehrmlive.com/"
    #When User landed on webpage
    #Then User enter the "<username>" and "<password>"
    #Then User click on submit button
    #Then User take screenshot
    #Then User landed on home page
    #Then User close the Browser
#
    #Examples: 
      #| username | password |
      #| admin    | admin123 |
