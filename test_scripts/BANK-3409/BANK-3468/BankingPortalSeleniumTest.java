/**
 * Test Case ID: TEST_CASE
 * Generated from Jira Ticket: BANK-3468
 * Epic: BANK-3409
 * Generated on: 2025-07-15 13:28:47
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class BankingPortalSeleniumTest {

    private WebDriver driver;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080"); // Adjust URL as needed
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testMarkAlertAsReviewed() throws InterruptedException {
        // Preconditions: An unreviewed alert is present on the dashboard
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Step 1: Log in as a fraud analyst
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginButton")));
        loginButton.click();

        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        usernameField.sendKeys("fraudAnalyst");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("securePassword");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Step 2: Select the alert on the dashboard
        WebElement alertElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-item.unreviewed")));
        alertElement.click();

        // Step 3: Mark the alert as reviewed
        WebElement markReviewedButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("markReviewedButton")));
        markReviewedButton.click();

        // Validate that the alert is flagged as reviewed
        WebElement reviewedAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-item.reviewed")));
        assertTrue(reviewedAlert.isDisplayed(), "The alert should be marked as reviewed");
    }
}