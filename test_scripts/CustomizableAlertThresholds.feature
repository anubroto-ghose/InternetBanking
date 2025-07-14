# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3467
# Epic: BANK-3409
# Generated on: 2025-07-14 10:48:31
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Customizable Alert Thresholds

  Scenario: Change risk threshold and trigger alert
    Given the alert thresholds are configurable
    When I change the risk threshold for triggering an alert
    And I trigger a test transaction that meets the new threshold
    Then the alert should be generated only if the transaction risk score exceeds the custom threshold set by the analyst