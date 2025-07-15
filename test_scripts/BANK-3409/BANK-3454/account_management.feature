# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3454
# Epic: BANK-3409
# Generated on: 2025-07-15 13:32:57
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Account Management

  Scenario: Create a new account
    Given I am on the account creation page
    When I fill in the account details
      | field           | value            |
      | accountName     | Test Account     |
      | accountType     | Savings          |
      | initialDeposit  | 1000             |
    And I submit the form
    Then I should see a success message
      | message                       |
      | Account created successfully! |

  Scenario: Retrieve transactions for an account
    Given I have an account with ID "1"
    When I navigate to the transactions page
    Then I should see a list of transactions

  Scenario: Update account status
    Given I am on the account update page for account ID "1"
    When I update the account status to "Active"
    Then I should see a status update message
      | message                           |
      | Account status updated successfully! |