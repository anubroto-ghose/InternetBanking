# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3962
# Epic: BANK-3931
# Generated on: 2025-07-18 17:22:31
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Manual Rate Override

  Scenario: Override a specific currency rate
    Given live exchange rates are available
    When I access the manual rate override feature
    And I input the currency pair "USD/INR" and rate "80.0"
    Then the system should accept the manual rate override
    And the specified rate should be used in currency conversions
