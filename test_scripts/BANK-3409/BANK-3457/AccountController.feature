# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3457
# Epic: BANK-3409
# Generated on: 2025-07-15 13:32:05
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Account Management

  Scenario: Successful account creation
    Given I am on the account registration page
    When I enter "testUser" as username
    And I enter "SecurePassword123" as password
    And I click on the register button
    Then I should see "Account created successfully!"

  Scenario: Fetching transactions for an account
    Given I am on the transactions page
    When I enter "12345" as the account ID
    And I click on the fetch transactions button
    Then I should see "Transaction Details"

  Scenario: Updating account status
    Given I am on the account status update page
    When I select "Active" from the status dropdown
    And I click on the confirm button
    Then I should see "Account status updated successfully!"