Feature: Login

  Scenario: User is able to log in via email
    Given User is on the landing page
    When User logs in with "standard_user" and "secret_sauce"
    Then User is Logged In