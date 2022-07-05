Feature: Login Action
   Login      

  Scenario: User get validation message with enter Invalid Credentails
    When Click on login link
    Given Enter Invalid Member ID
    Given Enter Valid password
    Then Click on login button
    And Verify validation message

  Scenario: Successful Login with valid credentails
    When User click on login link
    Given User enter memberID
    Given User enter password
    Then User click on login button
    And User verify member welcome element
