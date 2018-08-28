package pages;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddedToCartPage extends BasePage {

    protected AddedToCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(name = "close")
    public WebElement closeAddedToCartPage;

    @FindBy(xpath = "//div[@id='cart-popup']")
    public WebElement windowAddedToCartPage;

    @FindBy(xpath = "//div[contains(@class,'without-cart-amount')]")
    public WebElement windowAddedToCartPage2;

    @FindBy(xpath = "//span[contains(@class,'cart-return-link')]")
    public WebElement closeAddedToCartPage2;


    public GoodsPage continueShopping() {

        Function<WebDriver, Boolean> closeWindow = driver -> {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='cart-popup']")));
                click(wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("close"))));
                return false;
            }
            catch (Exception e) {
                return true;
            }
        };

        wait.until(closeWindow);

        /*
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(closeAddedToCartPage);
*/
        return new GoodsPage(driver);
    }

}
