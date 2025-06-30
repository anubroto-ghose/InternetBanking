import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class FilterTransactionHistoryTest {
    @Autowired
    private WebDriver driver;

    @Test
    public void testFilterTransactionHistoryByDateRange() {
        driver.get("http://banking-portal.com/transaction-history");
        driver.findElement(By.id("date-range-start")).sendKeys("2022-01-01");
        driver.findElement(By.id("date-range-end")).sendKeys("2022-12-31");
        driver.findElement(By.id("apply-filter-btn")).click();

        // Add assertions to validate filtered results
    }
}