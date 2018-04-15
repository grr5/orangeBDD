Feature: Orange HRM employee management

As an admin
I want to login to orangeHRM
So that I can add employees and manage records

@nrun
Scenario: Login to orangeHRM

Given admin is on login page
When admin enters username and password
Then the admin should successfully login

@run
Scenario Outline: create an employee

Given admin is logged in and is on homepage
When admin click on pim link
Then admin clicked on add employee button
And admin enters employee details as "<firstname>" and "<lastname>" and click on save button
And admin can add more details


Examples:
| firstname | lastname |
| raj       | rej      |
| Ram       | Sur      |
| David     | Dave     |


@nrun
Scenario: employee list
Given admin is logged in and is on homepage
When admin click on pim link
And admin clicked on employee list button
Then admin should see the list of employees

