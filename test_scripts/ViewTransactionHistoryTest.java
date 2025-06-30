@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestWebDriver
public class ViewTransactionHistoryTest {

    @Autowired
    private WebDriver driver;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private AccountService accountService;

    @MockBean
    private TokenService tokenService;

    private User testUser;

    private Logger logger = LoggerFactory.getLogger(ViewTransactionHistoryTest.class);

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testViewTransactionHistoryWithDefaultFilters() {
        // Initialize test data using project entities
        testUser = new User();
        testUser.setUsername("testuser");
        testUser.setEmail("test@example.com");

        // Configure mock services
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.of(testUser));
        when(accountService.getTransactionHistory(any(User.class))).thenReturn(Arrays.asList("Transaction 1", "Transaction 2", "Transaction 3"));

        // Perform UI actions
        driver.get("http://localhost:8080/transaction-history");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Verify default filters
        WebElement filterDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("filterDropdown")));
        assertTrue(filterDropdown.isDisplayed(), "Filter dropdown should be visible by default");

        // Verify transaction history data
        WebElement transactionList = driver.findElement(By.id("transactionList"));
        List<WebElement> transactions = transactionList.findElements(By.tagName("li"));
        assertEquals(3, transactions.size(), "Expected 3 transactions to be displayed");

        for (int i = 0; i < 3; i++) {
            assertEquals("Transaction " + (i + 1), transactions.get(i).getText(), "Transaction data should match");
        }

        logger.info("Transaction history page loaded with default filters and data displayed accurately");
    }
}