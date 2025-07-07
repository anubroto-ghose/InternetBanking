# Test Case ID: TC_ForexConverter_005
# Generated from Jira Ticket: BANK-3173
# Epic: BANK-3125
# Generated on: 2025-07-07 11:33:16
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Admin access requirement for currency conversion

  Scenario: User without admin privileges tries to access currency conversion
    Given the user is not logged in or has regular user privileges
    When the user attempts to access the /admin/forex/convert endpoint
    Then the access is denied with an error message indicating the need for admin privileges
