/**
 * Test Case ID: TC_Conversion_001
 * Generated from Jira Ticket: BANK-2957
 * Epic: BANK-749
 * Generated on: 2025-07-04 15:52:39
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
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
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/currency-conversion");
    }

    @Test
    public void testCurrencyConversion() {
        // Mocking the service response
        when(accountService.convertCurrency(1000.00, "INR", "USD")).thenReturn(13.50);

        // Input a valid amount in INR
        WebElement amountInput = driver.findElement(By.id("amount-input"));
        amountInput.sendKeys("1000");

        // Trigger conversion
        WebElement convertButton = driver.findElement(By.id("convert-button"));
        convertButton.click();

        // Verify that the application displays the converted value in USD
        WebElement convertedValue = driver.findElement(By.id("converted-value"));
        assertEquals("13.50 USD", convertedValue.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}