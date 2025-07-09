# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3322
# Epic: BANK-3298
# Generated on: 2025-07-09 09:35:08
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Transaction

  Scenario: Successful forex transaction from INR to JPY
    Given User has sufficient funds in their INR account
    And User has selected to convert from INR to JPY
    And Conversion rate is currently favorable
    When User initiates a forex transaction from INR to JPY
    And System processes the request in real-time
    Then Confirmation message is displayed to the user
    And User's INR balance is deducted accordingly
    And User receives a notification of successful transaction