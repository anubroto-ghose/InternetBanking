@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureWebMvc
@TestPropertySource(locations = "classpath:application-test.properties")
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
    public void setup() {
        MockitoAnnotations.openMocks(this);
        PageFactory.initElements(driver, this);
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testCurrencyConversionPrecision() {
        // Initialize test data
        AmountRequest amountRequest = new AmountRequest();
        amountRequest.setAmount(new BigDecimal("140.25"));

        // Mock service responses
        when(accountService.convertCurrency(any(AmountRequest.class))).thenReturn(new BigDecimal("1.75"));

        // Perform currency conversion
        driver.get("http://localhost:8080/conversion");

        // Entering amount to convert
        WebElement amountField = driver.findElement(By.id("amount"));
        amountField.sendKeys(amountRequest.getAmount().toString());

        // Trigger conversion
        WebElement convertButton = driver.findElement(By.id("convertButton"));
        convertButton.click();

        // Verify precision
        WebElement convertedAmount = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("convertedAmount"));
        BigDecimal expectedAmount = new BigDecimal("1.75");
        BigDecimal actualAmount = new BigDecimal(convertedAmount.getText());
        assertEquals(expectedAmount, actualAmount, "Currency conversion precision does not match");

        logger.info("Currency conversion precision test passed");
    }
}