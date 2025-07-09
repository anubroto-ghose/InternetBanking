# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3324
# Epic: BANK-3298
# Generated on: 2025-07-09 09:34:26
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: User performs forex transaction

  Scenario: Real-time confirmation of forex transaction from JPY to INR
    Given User has sufficient funds in their JPY account
    And User has selected to convert from JPY to INR
    And Conversion rate is currently favorable
    When User initiates a forex transaction from JPY to INR
    Then System processes the request in real-time
    And Confirmation message is displayed to the user
    And User's JPY balance is deducted accordingly
    And User receives a notification of successful transaction