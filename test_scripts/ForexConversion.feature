# Test Case ID: TC_Forex_Conversion_001
# Generated from Jira Ticket: BANK-3105
# Epic: BANK-3083
# Generated on: 2025-07-04 14:08:07
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Conversion

  Scenario: Successful forex conversion initiated by admin
    Given Admin is logged in to the system
    When Admin accesses the endpoint POST /admin/forex/convert
    And Admin provides the required input for currency conversion
    Then The system successfully converts the currency and displays a confirmation message