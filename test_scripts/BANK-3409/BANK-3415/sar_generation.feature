# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3415
# Epic: BANK-3409
# Generated on: 2025-07-10 09:07:58
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: SAR generation for flagged transaction

  Background:
    Given the transaction is flagged by the fraud detection system

  Scenario: SAR generation for flagged transaction
    When SAR generation is triggered for the flagged transaction
    Then SAR is successfully generated and associated with the flagged transaction