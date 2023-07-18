Feature: Login Action

Scenario: Successful Login with valid credentials
Given User opens browser
When User navigate to Login page
And User Enters Username and Password
Then Message displayed Login successfully 

Scenario: Successful logout
When User Logout from application
Then Message displayed Logout successfully