# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3467
# Epic: BANK-3409
# Generated on: 2025-07-15 13:29:03
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Customizable Alert Thresholds

  Scenario: Verify customizable alert thresholds
    Given the risk threshold is set to 50
    When I change the risk threshold to 75
    And I trigger a test transaction with a risk score of 80
    Then an alert should be generated

  Scenario: No alert generated below threshold
    Given the risk threshold is set to 75
    When I trigger a test transaction with a risk score of 70
    Then no alert should be generated