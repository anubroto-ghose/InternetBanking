/**
 * Test Case ID: TC_ExchangeRate_005
 * Generated from Jira Ticket: BANK-3078
 * Epic: BANK-749
 * Generated on: 2025-07-04 18:23:28
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import static org.junit.jupiter.api.Assertions.assertTrue;
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
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@SpringBootTest
public class ExchangeRateValidationTest {

    @MockBean
    private AccountService accountService;
    
    @MockBean
    private TokenService tokenService;
    
    @MockBean
    private UserRepository userRepository;
    
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/currency-exchange");
    }

    @Test
    public void testExchangeRateFormat() {
        // Mocking the service response
        when(accountService.getExchangeRate()).thenReturn("74.56");
        
        // Click the 'Get Exchange Rate' button
        WebElement button = driver.findElement(By.id("getExchangeRateButton"));
        button.click();

        // Observe the format of the displayed exchange rate
        WebElement exchangeRateElement = driver.findElement(By.id("exchangeRateDisplay"));
        String exchangeRateText = exchangeRateElement.getText();

        // Validating the format of the exchange rate
        assertTrue(exchangeRateText.matches("\d+\.\d{2}"), "Exchange rate format is invalid: " + exchangeRateText);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}