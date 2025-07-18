# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3958
# Epic: BANK-3931
# Generated on: 2025-07-18 16:57:33
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Email Notification upon Financial Entry Submission

  Scenario: User receives email notification upon submitting financial entry
    Given System user has submitted a financial entry
    When Submitting a financial entry
    Then An email notification is sent upon submission of the financial entry