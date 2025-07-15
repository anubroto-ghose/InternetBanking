# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3471
# Epic: BANK-3409
# Generated on: 2025-07-15 13:27:55
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Display risk scores for transactions

  Scenario: User views transactions with risk scores
    Given the user is logged in
    When the user generates transactions
    Then each transaction should display a risk score
    And the risk scores should be visible to the user
