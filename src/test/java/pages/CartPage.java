package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span[@name='sum']")
     public List<WebElement> listPrice;

    @FindBy(xpath = "//span[@name='cost']")
    public WebElement costGoods;

    @FindBy(xpath = "(//img[@alt='✓'])[1]")
    public WebElement delGoods;

    @FindBy(name = "delete")
    public WebElement delWithoutSave;

    @FindBy(xpath = "//h2[@class='empty-cart-title inline sprite-side']")
    public WebElement cartEmpty;

    public void checkSumCart(){
        checkSum(listPrice, costGoods);
    }

    public void dellAllGoods() throws InterruptedException {
        dellGoods(listPrice, delGoods, delWithoutSave);
    }

    public void checkCartEmpty(){
        checkCart(cartEmpty);
    }
}
