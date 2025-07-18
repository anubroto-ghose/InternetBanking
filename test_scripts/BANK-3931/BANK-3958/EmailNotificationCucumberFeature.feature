# Test Case ID: TEST_CASE
# Generated from Jira Ticket: BANK-3958
# Epic: BANK-3931
# Generated on: 2025-07-18 16:43:16
#
# This is an auto-generated Cucumber feature file.
# Modify with caution as changes may be overwritten.

Feature: Email Notification Feature

Scenario: Email notifications sent upon submission of financial entries (BANK-3939-TC01)
  Given System user has submitted a financial entry
  When Submit a financial entry
  Then An email notification is sent upon submission of the financial entry