# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3471
# Epic: BANK-3409
# Generated on: 2025-07-14 10:47:43
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Transaction Risk Scores Display

  Scenario: Verify risk scores are displayed for each transaction
    Given real-time transactions are being processed
    When multiple transactions are generated with varying risk levels
    Then verify that each transaction shows an accurate risk score
    And ensure risk scores are clearly visible to the user