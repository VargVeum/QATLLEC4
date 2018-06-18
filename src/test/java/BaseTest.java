import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {

  protected static WebDriver driver;

  private BrowserType browser = BrowserType.CHROME;

  public BaseTest(){
    driver = getConfiguredDriver();
  }

  @Parameters("browser")
  @BeforeTest
  public WebDriver getConfiguredDriver(){
    WebDriver driver = getDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    return new EventFiringWebDriver(getDriver());
  }


  private WebDriver getDriver() {
    switch (browser){
      case EDGE:
        System.setProperty(
                "webdriver.edge.driver",
                new File(BaseTest.class.getResource("WindowsDrivers/MicrosoftWebDriver.exe").getFile()).getPath());
        return new EdgeDriver();
      case IE:
        System.setProperty(
                "webdriver.ie.driver",
                new File(BaseTest.class.getResource("WindowsDrivers/IEDriverServer.exe").getFile()).getPath());
        return new InternetExplorerDriver();
      case FIREFOX:
        System.setProperty(
                "webdriver.geckodriver.driver",
                new File(BaseTest.class.getResource("WindowsDrivers/geckodriver.exe").getFile()).getPath());
        return new FirefoxDriver();
      case CHROME:
      default:
        System.setProperty(
                "webdriver.chrome.driver",
                new File(BaseTest.class.getResource("LinuxDrivers/chromedriver").getFile()).getPath());
        return new ChromeDriver();
    }
  }

  @AfterTest
  public void closeChromeDriver() {
    driver.close();
  }

  enum BrowserType {CHROME, FIREFOX, IE, EDGE}
}
