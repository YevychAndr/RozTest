import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

//@Listeners({ScreenShotOnFailListener.class})
public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

    @BeforeMethod
    public void start() {
        System.setProperty("webdriver.chrome.driver", "/home/ayevych/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to(" https://www.rozetka.com.ua/");
        wait = new WebDriverWait(driver, 5);
        actions = new Actions(driver);
    }

    @AfterMethod
    public void stop(){
        driver.quit();
        driver = null;
    }

    protected WebDriver getDriver() {
        return driver;
    }
}
