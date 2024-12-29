Feature: Validating the login feature of an salesforce application

  @TS01 @RegressionTest
  Scenario: To validate the error message
    Given User launch the browser and nagivates to the URL
    When User enters the username "Saniya"  and password "Saniya@123"
    And user clicks the login button
    Then Validating the error message

    @TS02 @SmokeTest @RegressionTest
  Scenario: User validate the login functionality
    Given User launch the browser and nagivates to the URL
    When User enters the username "Saniya2"  and password "San@123"
    And user clicks the login button
    Then Validate whether the user is nagivated to the Homepage.

@TS03
  Scenario Outline:Multiple user validation
    Given User launch the browser and nagivates to the URL
    When User enters the username "<User Name>"  and password "<Password>"
    And user clicks the login button
    Then Validate whether the user is nagivated to the Homepage.
    Examples:
      | User Name | Password      |
      | Username1 | userpassword1 |
      | Username2 | userpassword2 |
      | Username3 | userpassword3 |






