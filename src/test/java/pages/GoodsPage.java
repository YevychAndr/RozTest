package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;


public class GoodsPage extends BasePage {

    public GoodsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@name='goods_list']//button[1]")
    public List<WebElement> listGoodsItems;


    public AddedToCartPage buyGoods() {
        Random rnd = new Random();
        int i = rnd.nextInt(listGoodsItems.size());
        listGoodsItems.get(i).click();
        return new AddedToCartPage(driver);
    }


}
