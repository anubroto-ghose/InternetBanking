/**
 * Test Case ID: TC_Conversion_003
 * Generated from Jira Ticket: BANK-3062
 * Epic: BANK-749
 * Generated on: 2025-07-04 18:27:24
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
public class ExchangeRateReconnectionTest {

    private WebDriver driver;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private AccountService accountService;

    @MockBean
    private TokenService tokenService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testAutomaticReconnectionToLiveAPI() throws InterruptedException {
        // Simulate API being down
        when(accountService.getExchangeRate()).thenReturn(1.0);

        // Start conversion function
        driver.get("http://localhost:8080/bankingportal");
        WebElement startConversionButton = driver.findElement(By.id("startConversion"));
        startConversionButton.click();

        // Verify fallback to cached exchange rate
        WebElement exchangeRateDisplay = driver.findElement(By.id("exchangeRateDisplay"));
        assertEquals("1.0", exchangeRateDisplay.getText());

        // Simulate API coming back online
        when(accountService.getExchangeRate()).thenReturn(1.2);

        // Trigger reconnection logic
        WebElement reconnectButton = driver.findElement(By.id("reconnectAPI"));
        reconnectButton.click();

        // Wait for reconnection to complete
        Thread.sleep(3000);

        // Verify updated exchange rate
        assertEquals("1.2", exchangeRateDisplay.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}