# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3417
# Epic: BANK-3409
# Generated on: 2025-07-10 09:05:21
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: SAR Generation

  Scenario: Trigger SAR generation for unflagged transaction
    Given the transaction is not flagged by the fraud detection system
    When SAR generation is triggered for unflagged transaction
    Then SAR should not be generated
