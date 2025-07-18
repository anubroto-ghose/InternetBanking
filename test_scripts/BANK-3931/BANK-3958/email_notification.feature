# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3958
# Epic: BANK-3931
# Generated on: 2025-07-18 11:02:47
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Email notifications for financial entries

Scenario: Email notification sent upon submission
    Given a system user has submitted a financial entry
    When the financial entry is submitted
    Then an email notification is sent
