import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureWebTestClient
public class UserLoginTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final Logger logger = LoggerFactory.getLogger(UserLoginTest.class);

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        logger.info("WebDriver initialized successfully");
    }

    @AfterEach  
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("WebDriver closed successfully");
        }
    }

    @Test
    public void testCompleteUserLoginFlow() {
        // Test data setup
        String testEmail = "testuser@banking.com";
        String testPassword = "SecurePass123!";
        String expectedDashboardTitle = "Account Dashboard";

        try {
            driver.get("http://localhost:8080/login");
            logger.info("Navigated to login page");

            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            emailField.clear();
            emailField.sendKeys(testEmail);

            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.clear();
            passwordField.sendKeys(testPassword);

            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
            assertTrue(loginButton.isEnabled(), "Login button should be enabled");
            loginButton.click();

            WebElement dashboardHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dashboard-header")));
            assertTrue(dashboardHeader.isDisplayed(), "Dashboard should be visible after login");

            String pageTitle = driver.getTitle();
            assertTrue(pageTitle.contains(expectedDashboardTitle), "Page title should contain: " + expectedDashboardTitle + " but was: " + pageTitle);

            String currentUrl = driver.getCurrentUrl();
            assertTrue(currentUrl.contains("/dashboard"), "URL should redirect to dashboard, current URL: " + currentUrl);

            WebElement userProfile = driver.findElement(By.id("user-profile"));
            assertNotNull(userProfile, "User profile element should be present");

            logger.info("Login test completed successfully");

        } catch (Exception e) {
            logger.error("Test failed with exception: " + e.getMessage());
            fail("Test execution failed: " + e.getMessage());
        }
    }
}