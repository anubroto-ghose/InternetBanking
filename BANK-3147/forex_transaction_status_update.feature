# Test Case ID: TC_Forex_002
# Generated from Jira Ticket: BANK-3147
# Epic: BANK-3124
# Generated on: 2025-07-07 16:10:09
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Transaction Status Update

  Scenario: User updates transaction status in real-time
    Given the user is logged into the banking portal
    When the user initiates a forex transaction
    Then the system should update the transaction status in real-time without refreshing the page

  Background:
    Given the user has valid credentials
    And the user is on the login page
    When the user enters their username and password
    And clicks the login button
    Then the user should be redirected to the dashboard

  Given the user has valid credentials:
    | username   | password   |
    | testUser   | testPassword |

  When the user initiates a forex transaction:
    Given the user clicks on the forex button

  Then the system should update the transaction status in real-time without refreshing the page:
    Then the transaction status should be 'Completed'