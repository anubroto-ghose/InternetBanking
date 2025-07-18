# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3946
# Epic: BANK-3930
# Generated on: 2025-07-18 10:56:08
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Retrieve Historical Currency Rate Data

  Scenario: User retrieves historical rate data
    Given the user is in the reporting and auditing section
    When the user requests historical rate data for a specific date range
    Then the system should retrieve and display historical rate data accurately
    And the data can be exported for auditing purposes