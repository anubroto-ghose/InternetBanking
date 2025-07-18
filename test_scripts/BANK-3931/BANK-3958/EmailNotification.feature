# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3958
# Epic: BANK-3931
# Generated on: 2025-07-18 16:48:22
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Email Notifications

Scenario: Email notification sent upon submission of financial entry
    Given System user has submitted a financial entry
    When Submitting the financial entry
    Then An email notification is sent
