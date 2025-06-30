Feature: Retrieve Transaction History

Scenario: Retrieve transaction history with valid user
    Given Preconditions are met
    When User retrieves transaction history
    Then Verify user receives valid transaction history data