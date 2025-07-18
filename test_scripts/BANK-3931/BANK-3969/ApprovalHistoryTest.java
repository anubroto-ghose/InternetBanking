/**
 * Test Case ID: TEST_CASE
 * Generated from Jira Ticket: BANK-3969
 * Epic: BANK-3931
 * Generated on: 2025-07-18 17:19:44
 * 
 * This is an auto-generated Selenium test script.
 * Modify with caution as changes may be overwritten.
 */

package com.webapp.bankingportal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ApprovalHistoryTest {

    private WebDriver driver;

    @MockBean
    private UserRepository userRepository;
    
    @MockBean
    private AccountService accountService;
    
    @MockBean
    private TokenService tokenService;
    
    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        // Mock user data
        User user = new User();
        user.setRole("PROGRAM_DIRECTOR");
        when(userRepository.findByUsername(anyString())).thenReturn(user);
    }

    @Test
    public void testApprovalHistoryDisplaysTimestamps() {
        // Given the user is logged in
        driver.get("http://localhost:8080/login");
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        usernameField.sendKeys("programDirector");
        passwordField.sendKeys("password");
        loginButton.click();

        // When the program director views the approval history
        driver.get("http://localhost:8080/approval/history");

        // Then the approval history should display timestamps
        WebElement approvalHistoryTable = driver.findElement(By.id("approvalHistoryTable"));
        assertNotNull(approvalHistoryTable, "Approval history table should be present");
        assertTrue(approvalHistoryTable.getText().contains("Approved on:"), "Approval history should show timestamps");
        
        // Cleanup
        driver.quit();
    }
}