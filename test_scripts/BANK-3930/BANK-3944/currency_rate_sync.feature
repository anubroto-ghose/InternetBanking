# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3944
# Epic: BANK-3930
# Generated on: 2025-07-18 10:56:59
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Currency Rate Synchronization

  Scenario: System automatically syncs exchange rates
    Given Third-party currency rate service is integrated into the system
    And Scheduled intervals for rate synchronization are set up
    When Wait for the scheduled sync interval
    Then Exchange rates are automatically updated in the system
    And No errors or inconsistencies are encountered during the sync process