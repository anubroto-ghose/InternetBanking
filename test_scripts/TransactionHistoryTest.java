/**
 * Test Case ID: TC_ViewTransaction_005
 * Generated from Jira Ticket: BANK-2956
 * Epic: BANK-749
 * Generated on: 2025-07-04 15:52:58
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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TransactionHistoryTest {

    private WebDriver driver;

    @MockBean
    private UserRepository userRepository;
    
    @MockBean
    private AccountService accountService;
    
    @MockBean
    private TokenService tokenService;
    
    @InjectMocks
    private User user;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        user = new User("testUser", "password123");
        when(userRepository.findByUsername("testUser")).thenReturn(user);
        when(accountService.getTransactionHistory(user.getId())).thenReturn(generateLargeTransactionList());
    }

    @Test
    public void testViewTransactionHistory() {
        driver.get("http://localhost:8080/login");
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameField.sendKeys("testUser");
        passwordField.sendKeys("password123");
        loginButton.click();

        driver.findElement(By.id("transactionHistoryLink")).click();

        WebElement transactionHistory = driver.findElement(By.id("transactionHistoryTable"));

        assertNotNull(transactionHistory);
        assertTrue(transactionHistory.isDisplayed(), "Transaction history should be displayed.");
        assertEquals(1000, transactionHistory.findElements(By.tagName("tr")).size(), "Transaction history should load efficiently with a large dataset.");
    }

    private List<Transaction> generateLargeTransactionList() {
        List<Transaction> transactions = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            transactions.add(new Transaction(i, "Transaction " + i, 100 + i, LocalDate.now().minusDays(i))); 
        }
        return transactions;
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}