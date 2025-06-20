Feature: Exchange Rate API Downtime
  Scenario: User tries to access exchange rate during API downtime
    Given the API is down
    When the user opens the app and navigates to the exchange rate display
    Then the app displays an error message indicating that the exchange rate is currently unavailable due to API issues