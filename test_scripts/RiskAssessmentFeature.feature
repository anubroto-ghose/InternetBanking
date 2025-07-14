# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3470
# Epic: BANK-3409
# Generated on: 2025-07-14 10:47:54
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Real-time risk assessment

Scenario: Assess risk of a transaction
    Given the user initiates a transaction
    When the system assesses the risk
    Then the risk assessment should complete within 100ms
