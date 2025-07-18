# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3948
# Epic: BANK-3930
# Generated on: 2025-07-18 10:55:13
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Review Submitted Dealsheet

Scenario: Approver reviews a submitted dealsheet
    Given the dealsheet is submitted for review
    When the approver logs in
    And navigates to the review section
    And selects the submitted dealsheet for review
    Then the details of the dealsheet are displayed accurately
    And all necessary information is visible
    And no unauthorized changes can be made
    And the approver can see the history of modifications
    And the status is clearly indicated