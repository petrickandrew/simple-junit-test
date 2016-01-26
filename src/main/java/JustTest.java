/**
 * Created by max on 06.08.15.
 */

    import org.junit.*;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.chrome.ChromeOptions;
    import org.openqa.selenium.remote.DesiredCapabilities;
    import java.util.HashMap;
    import java.util.Map;

public class JustTest {
    String chromedriver = "/home/max/chromedriver/chromedriver";
    WebDriver driver;

    @Before
    public void startChrome() {
        setChromeEnvVariable();
        driver = new ChromeDriver(getChromeCapabilities());
    }

    @Test
    public void testGoogleSearch() throws InterruptedException {
        driver.get("http://www.google.com/xhtml");
        Thread.sleep(5000);  // Let the user actually see something!

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("ChromeDriver");
        searchBox.submit();
        Thread.sleep(15000);  // Let the user actually see something
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    private void setChromeEnvVariable() {
        System.setProperty("webdriver.chrome.driver", chromedriver);
    }

    private DesiredCapabilities getChromeCapabilities() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, getChromeOptions());
        return capabilities;
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation", getMobileEmulation());
        return options;
    }

    private Map<String, String> getMobileEmulation() {
        Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", "Google Nexus 7");
        return mobileEmulation;
    }
}
