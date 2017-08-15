/**
 * Run simple selenium tests in Chrome browser
 */

    import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
    
    //java -jar /usr/share/jenkins/jenkins.war

public class JustTest {
  //  String chromePath = "C:/GitRepoJUnit/simple-junit-test/drivers/chromedriver.exe";
    WebDriver driver;

    @Before
    public void startChrome() {
   //     setChromeEnvVariable();
        driver = new ChromeDriver();
    }

    @Test
    public void testGoogleSearch() throws InterruptedException {
        openUrl("http://www.google.com/xhtml");
        Thread.sleep(5000);  // Let the user actually see something!

        searchFor("brainacad");
        Thread.sleep(5000);  // Let the user actually see something
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    private void openUrl(String url) {
        driver.get(url);
    }

    private void searchFor(String text){
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(text);
        searchBox.submit();
    }

//    private void setChromeEnvVariable() {
//        System.setProperty("webdriver.chrome.driver", getChromePath());
//    }
//
//    private String getChromePath(){
//        return System.getProperty("user.dir") + chromePath;
//    }
//
//    private DesiredCapabilities getChromeCapabilities() {
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        capabilities.setCapability(ChromeOptions.CAPABILITY, getChromeOptions());
//        return capabilities;
//    }
//
//    private ChromeOptions getChromeOptions() {
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("mobileEmulation", getMobileEmulation());
//        return options;
//    }
//
//    private Map<String, String> getMobileEmulation() {
//        Map<String, String> mobileEmulation = new HashMap<String, String>();
//        mobileEmulation.put("deviceName", "Google Nexus 10");
//        return mobileEmulation;
//    }

}
