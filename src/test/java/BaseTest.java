import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.sprint4.pom.HomePageScooter;

public abstract class BaseTest {

    protected WebDriver driver;

    @Before
    public void setUp() {

        String browser = System.getProperty("browser", "chrome").toLowerCase();

        switch (browser) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
            default:
                driver = new ChromeDriver();
                break;
        }

        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(1920, 1080));

        driver.get(HomePageScooter.SCOOTER_URL);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
