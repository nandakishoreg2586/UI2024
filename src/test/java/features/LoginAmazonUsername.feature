Feature: Login Feature

  Scenario: Successful login with valid credentials
    Given User is on the Amazon Home page
    Then User clicks on Signin button
    When User enters "nandakishore.shopping@gmail.com" and click continue
    Then User should be on Signin page