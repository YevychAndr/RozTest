package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

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

    //@FindBy(xpath = "(//img[@alt='✓'])[1]")
    @FindBy(css = "[name=activate]")
    public WebElement delGoods;

    @FindBy(name = "delete")
    public WebElement delWithoutSave;

    @Step("Перевіряємо правильність сумми в корзині")
    public void checkSumCart(){
        int sum = 0;
        for (int i = 0; i < listPrice.size(); i++) {
            sum = sum + (Integer.parseInt(listPrice.get(i).getText().replace(" ", "")));
        }
        int realCostGoods = Integer.parseInt(costGoods.getText().replace(" ", ""));
        Assert.assertEquals(realCostGoods, sum, "Загальна сума, вказана вкорзині НЕ відповідає сумі цін, всіх добавлених.");
    }

    public CartPage dellAllGoods() {
        int k = listPrice.size();
        {
            for (int i = 0; i < k; i++) {
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@alt='✓'])[1]")));
                    click(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@alt='✓'])[1]"))));
                    click(wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("delete"))));
                    WebElement closeSendingWindow = driver.findElement(By.cssSelector("img[alt=\"Отправка данных\"]"));
                    wait.until(ExpectedConditions.stalenessOf(closeSendingWindow));

                /*
                click(delGoods);
                click(delWithoutSave);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                */
            }
        }



        return new CartPage(driver);

    }
    public void checkCartEmpty() {
        Assert.assertTrue((listPrice).isEmpty(), "Корзина НЕ пуста.");
        }
}
