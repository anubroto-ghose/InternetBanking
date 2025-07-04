# Test Case ID: TC_Forex_003
# Generated from Jira Ticket: BANK-3097
# Epic: BANK-3083
# Generated on: 2025-07-04 14:12:02
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Logging attempt to access new forex conversion endpoint

  Scenario: Attempt to access the new forex conversion endpoint
    Given new forex conversion endpoint is created
    When attempt to access the new forex conversion endpoint
    Then system logs the attempt to access the new endpoint