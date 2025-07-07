# Test Case ID: TC_Forex_002
# Generated from Jira Ticket: BANK-3152
# Epic: BANK-3124
# Generated on: 2025-07-07 16:08:33
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Forex Transaction

  Scenario: Initiate forex transaction with insufficient funds
    Given the customer has insufficient JPY amount for the transaction
    When the customer tries to initiate a forex transaction from JPY to INR
    Then an error message indicating insufficient funds should be displayed
    And the customer's JPY amount should remain unchanged

  Background:
    Given the RESTful API endpoint for forex transactions is available

  Given the customer has insufficient JPY amount for the transaction:
    | userId | balance | currency |
    | 12345  | 1000    | JPY      |

  When the customer tries to initiate a forex transaction from JPY to INR:
    | amount |
    | 2000   |

  Then an error message indicating insufficient funds should be displayed:
    | errorMessage          |
    | Insufficient funds    |

  And the customer's JPY amount should remain unchanged:
    | userId | expectedBalance |
    | 12345  | 1000           |
