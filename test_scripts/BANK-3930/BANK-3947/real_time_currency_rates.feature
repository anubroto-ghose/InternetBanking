# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3947
# Epic: BANK-3930
# Generated on: 2025-07-18 10:55:39
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Real-Time Currency Rates API Testing

  Scenario: Retrieve real-time currency rates
    Given the system is up and running
    And APIs for retrieving real-time rates are accessible
    When a request is made to the currency rate API
    Then the API should return real-time rates accurately
    And the response time should be within acceptable limits