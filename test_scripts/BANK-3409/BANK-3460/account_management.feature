# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3460
# Epic: BANK-3409
# Generated on: 2025-07-15 13:31:03
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Account Management

  Scenario: Create a new account
    Given I am on the account creation page
    When I enter the username "testuser" and password "SecureP@ssw0rd"
    And I submit the account creation form
    Then I should see a success message that says "Account created successfully"

  Scenario: Retrieve transactions for an account
    Given I am logged in as "testuser" with password "SecureP@ssw0rd"
    When I navigate to the transactions page
    Then I should see my transactions listed
