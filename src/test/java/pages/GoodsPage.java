package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoodsPage extends BasePage {

    public GoodsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@name='goods_list']//div[2]//button[1]")
    public WebElement btnBuyFirstGoods;

    @FindBy(xpath = "//div[@name='goods_list']//div[5]//button[1]")
    public WebElement btnBuySecondGoods;

    @FindBy(xpath = "//div[@name='goods_list']//div[5]//button[1]")
    public WebElement btnBuyThirdGoods;


    public AddedToCartPage buyGood() {
        click(btnBuyFirstGoods);
        return new AddedToCartPage(driver);
    }

    public AddedToCartPage buyGoods2() {
        click(btnBuySecondGoods);
        return new AddedToCartPage(driver);
    }

    public AddedToCartPage buyGoods3(){
        click(btnBuyThirdGoods);
        return new AddedToCartPage(driver);
    }

}
