# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3318
# Epic: BANK-3298
# Generated on: 2025-07-09 09:39:55
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Exchange Rate Notification Preferences

  Scenario: Setting notification preferences for exchange rate updates
    Given User is logged into the banking portal
    When User navigates to the notification preferences section
    And User enables notifications for exchange rate updates
    Then User successfully sets the preference to receive notifications for exchange rate updates