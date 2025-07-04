/**
 * Test Case ID: TC_Exchange_003
 * Generated from Jira Ticket: BANK-2964
 * Epic: BANK-749
 * Generated on: 2025-07-04 17:43:58
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.webapp.bankingportal.services.AccountService;
import com.webapp.bankingportal.services.TokenService;
import com.webapp.bankingportal.repositories.UserRepository;
import com.webapp.bankingportal.dto.AmountRequest;
import com.webapp.bankingportal.dto.LoginRequest;
import com.webapp.bankingportal.dto.PinRequest;
import com.webapp.bankingportal.entities.User;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@SpringBootTest
public class ExchangeRateDisplayTest {

    @MockBean
    private AccountService accountService;

    @MockBean
    private TokenService tokenService;

    @MockBean
    private UserRepository userRepository;

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testExchangeRateDisplay() {
        // Mocking the exchange rate response
        String expectedExchangeRate = "INR 73.56";
        String expectedTimestamp = "Last updated: 2023-10-01 12:00:00";
        when(accountService.getExchangeRate()).thenReturn(expectedExchangeRate);
        when(accountService.getLastUpdatedTimestamp()).thenReturn(expectedTimestamp);

        // Navigate to the banking portal
        driver.get("http://localhost:8080/bankingportal");

        // Assuming the exchange rate is displayed in an element with id 'exchange-rate'
        String displayedRate = driver.findElement(By.id("exchange-rate")).getText();
        String displayedTimestamp = driver.findElement(By.id("timestamp")).getText();

        // Assertions
        assertTrue(displayedRate.contains(expectedExchangeRate), "Exchange rate is not displayed correctly.");
        assertTrue(displayedTimestamp.contains(expectedTimestamp), "Timestamp is not displayed correctly.");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}