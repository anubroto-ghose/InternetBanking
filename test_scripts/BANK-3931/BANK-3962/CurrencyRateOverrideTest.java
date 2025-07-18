/**
 * Test Case ID: TEST_CASE
 * Generated from Jira Ticket: BANK-3962
 * Epic: BANK-3931
 * Generated on: 2025-07-18 17:22:31
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CurrencyRateOverrideTest {

    private WebDriver driver;

    @MockBean
    private AccountService accountService;
    @MockBean
    private TokenService tokenService;
    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        // Mocking service responses
        when(accountService.getCurrencyRate("USD", "INR")).thenReturn(75.0);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testManualRateOverride() {
        driver.get("http://localhost:8080/manual-rate-override");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currencyPairInput")));

        // Input currency pair and rate
        WebElement currencyPairInput = driver.findElement(By.id("currencyPairInput"));
        currencyPairInput.sendKeys("USD/INR");

        WebElement rateInput = driver.findElement(By.id("rateInput"));
        rateInput.sendKeys("80.0");

        WebElement overrideButton = driver.findElement(By.id("overrideButton"));
        overrideButton.click();

        // Wait for success message
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("successMessage")));

        WebElement successMessage = driver.findElement(By.id("successMessage"));
        assertEquals("Manual rate override successful!", successMessage.getText());

        // Verify that the new rate is used in currency conversion
        double convertedAmount = accountService.convertCurrency(100, "USD", "INR");
        assertEquals(8000.0, convertedAmount);
    }
}