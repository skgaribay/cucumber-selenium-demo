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

  @uut
  Scenario: User is able to submit a form
    Given User is on the form page
    When User fillse up the form
    | Test User                  |
    | test@email.com             |
    | 09878757678                |
    | Booking                    |
    | Lorem Ipsum Dolor Sit Amet |
    Then The form is submitted

