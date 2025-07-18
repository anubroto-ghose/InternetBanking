# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3967
# Epic: BANK-3931
# Generated on: 2025-07-18 16:33:22
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Role-Based Financial Approval Workflow

  Scenario: Approval of deal sheet
    Given the FpmDealsheetController requires updates for approvalStatus
    And the FpmVersionController records approval decisions in each version
    When the user submits the deal sheet for approval
    Then the FpmAuditController captures the approval logs
    And the FpmMailController sends approval request emails
    And the FpmUserProfileController determines the approver roles

  Scenario: Submission and approval of new travel costs
    Given the FpmTravelController entries must now pass through an approval lifecycle
    And the FpmStaffingController logs changes as draft, submitted, or approved
    When the user submits travel costs for approval
    Then the FpmAuditController captures the approval logs
    And the FpmMailController sends approval request emails
    And the FpmUserProfileController determines the approver roles