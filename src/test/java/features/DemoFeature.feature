Feature: Demo

  Scenario: User is able to log in via email
    Given User is on the login page
    When User logs in with "standard_user" and "secret_sauce"
    Then User is Logged In

  Scenario Outline: Invalid credentials are validated
    Given User is on the login page
    When User logs in with "<user>" and "<password>"
    Then The validation message is "<error>"

    Examples:
    | user | password | error                                                                     |
    | blank| blank    | Epic sadface: Username is required                                        |
    | asd  | blank    | Epic sadface: Password is required                                        |
    | asd  | asd      | Epic sadface: Username and password do not match any user in this service |
    | fail | fail     | Fail                                                                      |
    #last set should fail on purpose for the demo

  Scenario: User is able to submit a form
    Given User is on the form page
    When User fills up the form
    | Test User                  |
    | test@email.com             |
    | 09878757678                |
    | Booking                    |
    | Lorem Ipsum Dolor Sit Amet |
    Then The form is submitted

  Scenario: User verifies content in a new tab
    Given User is on the Test New Tab page
    When User clicks on the Open New Tab button
    Then the user is in the new tab

  @uut
  Scenario: User opens new tab then returns to main tab
    Given User is on the Test New Tab page
    When User clicks on the Open New Tab button
    And User closes current tab
    Then User is back on the main tab

