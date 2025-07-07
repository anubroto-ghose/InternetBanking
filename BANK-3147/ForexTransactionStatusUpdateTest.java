/**
 * Test Case ID: TC_Forex_002
 * Generated from Jira Ticket: BANK-3147
 * Epic: BANK-3124
 * Generated on: 2025-07-07 15:56:28
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
@AutoConfigureMockMvc
public class ForexTransactionStatusUpdateTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private AccountService accountService;

    @Mock
    private TokenService tokenService;

    @InjectMocks
    private ForexTransactionController forexTransactionController;

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testForexTransactionStatusUpdate() throws Exception {
        // Mocking user login
        User user = new User();
        user.setUsername("testUser");
        user.setPin("1234");
        doReturn(user).when(userRepository).findByUsername("testUser");

        // Mocking account service response
        doReturn(HttpStatus.OK).when(accountService).initiateForexTransaction(any(AmountRequest.class));

        // Start the browser and log in
        driver.get("http://localhost:8080/login");
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement pinField = driver.findElement(By.id("pin"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameField.sendKeys("testUser");
        pinField.sendKeys("1234");
        loginButton.click();

        // Initiate a forex transaction
        WebElement forexButton = driver.findElement(By.id("forexButton"));
        forexButton.click();

        // Wait for the status update
        Thread.sleep(5000); // Wait for status update

        // Check the transaction status
        WebElement statusElement = driver.findElement(By.id("transactionStatus"));
        String statusText = statusElement.getText();

        // Assert that the status is updated
        assertEquals("Transaction Successful", statusText);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
