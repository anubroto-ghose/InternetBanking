import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.webapp.bankingportal.dto.LoginRequest;
import com.webapp.bankingportal.entity.User;
import com.webapp.bankingportal.repository.UserRepository;
import com.webapp.bankingportal.service.AccountService;
import com.webapp.bankingportal.service.TokenService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TransactionHistoryFilterTest {
    private static final Logger logger = LoggerFactory.getLogger(TransactionHistoryFilterTest.class);

    @Autowired
    private WebDriver driver;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private AccountService accountService;

    @MockBean
    private TokenService tokenService;

    private User testUser;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        testUser = new User();
        testUser.setUsername("testuser");
        testUser.setEmail("test@example.com");
        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(testUser));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testFilterTransactionHistoryByDateRange() {
        // Login to the banking portal
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(testUser.getUsername());
        loginRequest.setPassword("password123");

        driver.get("http://localhost:8080/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginBtn"));

        usernameField.sendKeys(loginRequest.getUsername());
        passwordField.sendKeys(loginRequest.getPassword());
        loginButton.click();

        // Navigate to transaction history
        driver.get("http://localhost:8080/transaction-history");

        // Set date range filter
        WebElement startDateField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("startDate")));
        WebElement endDateField = driver.findElement(By.id("endDate"));
        WebElement filterButton = driver.findElement(By.id("filterBtn"));

        startDateField.sendKeys("2023-01-01");
        endDateField.sendKeys("2023-01-31");
        filterButton.click();

        // Verify filtered transactions
        List<WebElement> transactionRows = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("transaction-row")));
        assertFalse(transactionRows.isEmpty(), "Transaction history should not be empty for the specified date range");

        for (WebElement row : transactionRows) {
            String dateText = row.findElement(By.className("transaction-date")).getText();
            assertTrue(dateText.compareTo("2023-01-01") >= 0 && dateText.compareTo("2023-01-31") <= 0,
                "Transaction date is out of the specified range");
        }

        logger.info("Transaction history filtered successfully by date range");
    }
}