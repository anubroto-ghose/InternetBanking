# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3455
# Epic: BANK-3409
# Generated on: 2025-07-14 10:50:59
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Verify Fraud Assessment Action Timestamp

  Scenario: Verify action is logged with a timestamp
    Given a fraud assessment action is logged
    When verifying the action timestamp
    Then the action should have a timestamp
