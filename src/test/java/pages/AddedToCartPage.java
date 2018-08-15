package pages;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

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


    public GoodsPage continueShopping() throws InterruptedException {
/*
        Function<WebDriver, Boolean> closeWindow = driver -> { click(closeAddedToCartPage);
            {
                //return !closeAddedToCartPage.isEnabled();
                if (wait.until(ExpectedConditions.stalenessOf(windowAddedToCartPage)))
                    return true;
                else
                    return false;
            }

    };

        wait.until(closeWindow);

        wait.until(driver1 -> {click((WebElement) closeAddedToCartPage);
            if(listAddedToCartPage.isEmpty())
                return true;
            else
                return false;
        });
*/

        Thread.sleep(3000);
        closeAddedToCartPage.click();
        return new GoodsPage(driver);
    }

}
