package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddedToCartPage extends BasePage {

    protected AddedToCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(name = "close")
    public WebElement closeAddedToCartPage;

    public GoodsPage continueShopping() throws InterruptedException {
        Thread.sleep(3000);
        click(closeAddedToCartPage);
        return new GoodsPage(driver);
    }
}
