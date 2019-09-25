import Pages.MainPage;
import Pages.SubmitPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests {
    protected static WebDriver driver;
    private static String startPage =  "https://www.wrike.com";

    @BeforeClass
    public static void starter() {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(startPage);
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Rule
    public RetryRule rule = new RetryRule(1);

    @Test
    @DisplayName("Get started for free")
    public void a_get_started() throws InterruptedException {
        new MainPage(driver).started();
        new SubmitPage(driver).submit();
    }
}