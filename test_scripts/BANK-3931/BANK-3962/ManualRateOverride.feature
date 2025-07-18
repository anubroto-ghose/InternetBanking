# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3962
# Epic: BANK-3931
# Generated on: 2025-07-18 16:42:33
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Manual Rate Override

  Scenario: Override Specific Currency Rate Manually
    Given Live exchange rates are available
    And Need to override a specific currency rate manually
    When I access the manual rate override feature
    And Input the desired currency pair and rate to override
    Then the system accepts the manual rate override
    And uses the specified rate in currency conversions