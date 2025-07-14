# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3460
# Epic: BANK-3409
# Generated on: 2025-07-14 10:49:56
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: SAR Generation for Flagged Transactions

  Scenario: SAR generation for flagged transactions
    Given the system has flagged transactions
    And the reporting service is operational
    When SAR generation is triggered
    Then the SAR report should be successfully generated
    And the report should include transaction details, risk scores, and actions taken
