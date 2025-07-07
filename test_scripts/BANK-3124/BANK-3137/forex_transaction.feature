# Test Case ID: TC_Forex_004
# Generated from Jira Ticket: BANK-3137
# Epic: BANK-3124
# Generated on: 2025-07-07 16:45:23
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Transaction without OAuth 2.0 Token

  Scenario: Attempt to send a forex transaction request without an OAuth 2.0 token
    Given the user is logged in with valid credentials
    When the user attempts to send a forex transaction request
    Then the response code should be 401
    And the error message should indicate a missing token

  Background:
    Given the user has necessary permissions to perform forex transactions
    And no OAuth 2.0 access token is available