/**
 * Test Case ID: TEST_CASE
 * Generated from Jira Ticket: BANK-3961
 * Epic: BANK-3931
 * Generated on: 2025-07-18 17:22:56
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CurrencyConversionTest {

    private WebDriver driver;

    @MockBean
    private AccountService accountService;

    @MockBean
    private TokenService tokenService;

    @MockBean
    private UserRepository userRepository;

    @InjectMocks
    private CurrencyConversionController currencyConversionController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/currency-conversion");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCurrencyConversionReflectsLiveExchangeRates() {
        // Mocking the service response
        when(accountService.getLiveExchangeRates()).thenReturn(new ExchangeRateResponse("USD", "INR", 82.65));

        // Trigger currency rate synchronization job
        WebElement syncButton = driver.findElement(By.id("syncRatesButton"));
        syncButton.click();

        // Perform currency conversion
        WebElement baseCurrencyInput = driver.findElement(By.id("baseCurrency"));
        baseCurrencyInput.sendKeys("USD");

        WebElement targetCurrencyInput = driver.findElement(By.id("targetCurrency"));
        targetCurrencyInput.sendKeys("INR");

        WebElement amountInput = driver.findElement(By.id("amount"));
        amountInput.sendKeys("100");

        WebElement convertButton = driver.findElement(By.id("convertButton"));
        convertButton.click();

        // Verify the conversion result
        WebElement resultField = driver.findElement(By.id("result"));
        String resultText = resultField.getText();
        assertEquals("8265.0", resultText);
    }
}