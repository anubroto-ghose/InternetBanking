/**
 * Test Case ID: TEST_CASE
 * Generated from Jira Ticket: BANK-3965
 * Epic: BANK-3931
 * Generated on: 2025-07-18 17:21:27
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class FinancialEntryApprovalHistoryTest {

    private WebDriver driver;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/login");

        // Log in as a financial analyst
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        usernameField.sendKeys("financialAnalyst");
        passwordField.sendKeys("password123");
        driver.findElement(By.id("loginButton")).click();
    }

    @Test
    public void testApprovalHistoryDisplay() {
        // Navigate to the financial entry history section
        driver.findElement(By.linkText("Financial Entry History")).click();

        // Verify the display of previous approvers and comments
        WebElement historySection = driver.findElement(By.id("historySection"));
        assertTrue(historySection.isDisplayed(), "History section is not displayed");

        // Check for previous approvers and comments
        WebElement approverComments = driver.findElement(By.className("approver-comments"));
        assertTrue(approverComments.getText().contains("John Doe: Approved"), "Previous approver's comment not found");
        assertTrue(approverComments.getText().contains("Jane Smith: Needs more info"), "Previous approver's comment not found");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}