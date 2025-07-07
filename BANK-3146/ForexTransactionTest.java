/**
 * Test Case ID: TC_Forex_001
 * Generated from Jira Ticket: BANK-3146
 * Epic: BANK-3124
 * Generated on: 2025-07-07 16:10:25
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class ForexTransactionTest {

    private WebDriver driver;

    @MockBean
    private TokenService tokenService;

    @MockBean
    private AccountService accountService;

    @MockBean
    private UserRepository userRepository;

    @InjectMocks
    private User user;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        user = new User();
        user.setUsername("testuser");
        user.setPassword("password");
        when(tokenService.getToken(any(LoginRequest.class))).thenReturn("mockToken");
        when(accountService.getOngoingForexTransactions(any(String.class))).thenReturn(getMockForexTransactions());
    }

    @Test
    public void testDisplayOngoingForexTransactions() {
        driver.get("http://localhost:8080/login");
        driver.findElement(By.id("username")).sendKeys(user.getUsername());
        driver.findElement(By.id("password")).sendKeys(user.getPassword());
        driver.findElement(By.id("loginButton")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("/forex-transactions"));

        List<String> pendingTransactions = Arrays.asList("Transaction 1", "Transaction 2");

        for (String transaction : pendingTransactions) {
            assertEquals(transaction, driver.findElement(By.xpath("//div[contains(text(), '" + transaction + "')]")).getText());
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private List<String> getMockForexTransactions() {
        return Arrays.asList("Transaction 1", "Transaction 2");
    }
}