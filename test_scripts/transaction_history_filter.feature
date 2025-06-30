Feature: Transaction History Filter
  Scenario: Filter transaction history by date range
    Given User is logged into banking portal
    When User sets a date range from "2023-01-01" to "2023-01-31"
    Then Transaction history should display only transactions within the specified date range

  Scenario: Filter transaction history with no transactions in date range
    Given User is logged into banking portal
    When User sets a date range from "2023-02-01" to "2023-02-28"
    Then Transaction history should be empty

  @Given
  public void userIsLoggedIntoBankingPortal() {
      // Initialize test data using project entities
      testUser = new User();
      testUser.setUsername("testuser");
      testUser.setEmail("test@example.com");

      LoginRequest loginRequest = new LoginRequest();
      loginRequest.setUsername("testuser");
      loginRequest.setPassword("password123");

      // Configure mock services
      when(userRepository.findByUsername(anyString())).thenReturn(Optional.of(testUser));
      when(tokenService.generateToken(any(User.class))).thenReturn("mock-jwt-token");

      // Perform UI login
      driver.get("http://localhost:8080/login");
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

      WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
      WebElement passwordField = driver.findElement(By.id("password"));
      WebElement loginButton = driver.findElement(By.id("loginBtn"));

      usernameField.sendKeys(loginRequest.getUsername());
      passwordField.sendKeys(loginRequest.getPassword());
      loginButton.click();

      // Verify successful login
      WebElement dashboard = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dashboard")));
      assertTrue(dashboard.isDisplayed(), "User should be redirected to dashboard after login");

      logger.info("User successfully logged into banking portal");
  }

  @When
  public void userSetsADateRangeFromTo(String startDate, String endDate) {
      WebElement startDateField = driver.findElement(By.id("startDate"));
      WebElement endDateField = driver.findElement(By.id("endDate"));
      WebElement filterButton = driver.findElement(By.id("filterBtn"));

      startDateField.sendKeys(startDate);
      endDateField.sendKeys(endDate);
      filterButton.click();
  }

  @Then
  public void transactionHistoryShouldDisplayOnlyTransactionsWithinTheSpecifiedDateRange() {
      List<WebElement> transactionRows = driver.findElements(By.className("transaction-row"));
      assertFalse(transactionRows.isEmpty(), "Transaction history should not be empty for the specified date range");

      for (WebElement row : transactionRows) {
          String dateText = row.findElement(By.className("transaction-date")).getText();
          assertTrue(dateText.compareTo("2023-01-01") >= 0 && dateText.compareTo("2023-01-31") <= 0,
              "Transaction date is out of the specified range");
      }
      logger.info("Transaction history filtered successfully by date range");
  }

  @Then
  public void transactionHistoryShouldBeEmpty() {
      List<WebElement> transactionRows = driver.findElements(By.className("transaction-row"));
      assertTrue(transactionRows.isEmpty(), "Transaction history should be empty for the specified date range");
      logger.info("Transaction history is empty as expected");
  }