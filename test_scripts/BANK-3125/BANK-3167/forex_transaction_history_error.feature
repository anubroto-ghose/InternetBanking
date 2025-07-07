# Test Case ID: TC_Forex_003
# Generated from Jira Ticket: BANK-3167
# Epic: BANK-3125
# Generated on: 2025-07-07 11:36:24
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Error Handling for Retrieving Forex Transaction History

  Scenario: Verify error response with invalid user ID
    Given the user ID in the request does not exist
    When the endpoint to retrieve forex transaction history is requested
    Then the system should return an error response indicating invalid user ID
