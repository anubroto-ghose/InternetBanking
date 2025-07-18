# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3966
# Epic: BANK-3931
# Generated on: 2025-07-18 16:41:50
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Approval Progress

  Scenario: Filter reports by approval status
    Given financial entry statuses vary
    When accessing the report filtering section
    And applying filter for approval status
    Then reports should show entries filtered by status accurately