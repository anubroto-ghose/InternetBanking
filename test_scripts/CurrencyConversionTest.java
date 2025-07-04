import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import com.webapp.bankingportal.dto.AmountRequest;
import com.webapp.bankingportal.entity.User;
import com.webapp.bankingportal.repository.UserRepository;
import com.webapp.bankingportal.service.AccountService;
import com.webapp.bankingportal.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureWebMvc
public class CurrencyConversionTest {
    private static final Logger logger = LoggerFactory.getLogger(CurrencyConversionTest.class);

    @Autowired
    private WebDriver driver;

    @MockBean
    private AccountService accountService;

    @MockBean
    private TokenService tokenService;

    @MockBean
    private UserRepository userRepository;

    private User testUser;

    @BeforeEach
    public void setUp() {
        testUser = new User();
        testUser.setUsername("testuser");
        testUser.setEmail("test@example.com");
        testUser.setPassword("password123");
        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(testUser));
        logger.info("Test user setup completed.");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        logger.info("WebDriver closed.");
    }

    @Test
    public void testCurrencyConversionPrecision() {
        // Given
        AmountRequest amountRequest = new AmountRequest();
        amountRequest.setAmount(new BigDecimal("1234.56"));
        amountRequest.setCurrencyFrom("INR");
        amountRequest.setCurrencyTo("USD");

        // Mock conversion service
        when(accountService.convertCurrency(any(AmountRequest.class))).thenReturn(new BigDecimal("15.00"));

        // When
        driver.get("http://localhost:8080/currency-conversion");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement amountField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("amount")));
        WebElement convertButton = driver.findElement(By.id("convertBtn"));

        amountField.sendKeys(amountRequest.getAmount().toString());
        convertButton.click();

        // Then
        WebElement resultField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("result")));
        BigDecimal conversionResult = new BigDecimal(resultField.getText());
        assertEquals(new BigDecimal("15.00"), conversionResult.setScale(2, BigDecimal.ROUND_HALF_UP), "The converted amount should match the expected precision.");

        logger.info("Currency conversion precision test passed.");
    }
}