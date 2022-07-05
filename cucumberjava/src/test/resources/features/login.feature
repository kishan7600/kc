Feature: Login Action

  Scenario: Successful Login with valid credentails
    When User click on login link
    Then User enter memberID
    Then User enter password
    And User click on login button
    Then User verify member welcome text
