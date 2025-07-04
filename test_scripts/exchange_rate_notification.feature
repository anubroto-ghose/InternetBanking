# Test Case ID: TC_Conversion_002
# Generated from Jira Ticket: BANK-2950
# Epic: BANK-749
# Generated on: 2025-07-04 15:40:00
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Exchange Rate Notification

  Scenario: User informed of cached vs real-time exchange rates
    Given the system is using cached exchange rates
    When the user navigates to the banking portal
    Then the user should see a notification that cached rates are being used

  Scenario: System switches to real-time exchange rates
    Given the system is using cached exchange rates
    When the API comes back online
    And the user refreshes the banking portal
    Then the user should see a notification that real-time rates are now being used
