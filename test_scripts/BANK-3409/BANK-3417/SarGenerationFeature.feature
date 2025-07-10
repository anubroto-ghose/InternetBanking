# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3417
# Epic: BANK-3409
# Generated on: 2025-07-10 09:06:49
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Sar Generation For Unflagged Transaction

Scenario: Trigger SAR generation for unflagged transaction
    Given a user is logged in
    And the transaction is not flagged by the fraud detection system
    When the SAR generation is triggered
    Then SAR is not generated for the unflagged transaction
