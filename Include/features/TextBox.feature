#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: TextBox menu from DemoQA

  Scenario: Submit valid input on all fields
    Given User is on the Text Box page
    When User fills all fields with valid data
    And User clicks the Submit button
    Then The result should display the entered name "Nizam Aditya"

  Scenario: Submit with only name filled
    Given User is on the Text Box page
    When User fills only the Full Name field
    And User clicks the Submit button
    Then The result section should not appear

  Scenario: Submit with invalid email format
    Given User is on the Text Box page
    When User fills but incorrect email format
    And User clicks the Submit button
    Then The email field should be marked as error
