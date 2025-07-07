# Test Case ID: TC_ForexConverter_002
# Generated from Jira Ticket: BANK-3170
# Epic: BANK-3125
# Generated on: 2025-07-07 11:34:40
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency conversion from INR to JPY with unauthorized access

  Scenario: Unauthorized access currency conversion
    Given the user is not logged in or has regular user privileges
    When the /admin/forex/convert endpoint is accessed without proper admin authentication
    Then the request is denied with an unauthorized access error message
    And no currency conversion takes place
