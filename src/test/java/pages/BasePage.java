package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class BasePage {

    protected BasePage(WebDriver driver) {
        wait = new WebDriverWait(driver, 10);
        actions = new Actions(driver);
    }

    public WebDriverWait wait;
    public WebDriver driver;
    public Actions actions;


    protected void click(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }

    protected void check (WebElement element){
        Assert.assertTrue((element).isDisplayed());
    }

    protected void insertLogin (WebElement element){
        element.sendKeys("yevych.a@ya.ru");
    }

    protected void insertPassword (WebElement element){
        element.sendKeys("Vvs1983");
    }

    protected void moveTo (WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(element).build().perform();
    }

    public void checkSum(List<WebElement> listPrice, WebElement costGoods) {
        int sum = 0;
        for (int i = 0; i < listPrice.size(); i++) {
            sum = sum + (Integer.parseInt(listPrice.get(i).getText().replace(" ", "")));
        }
        int realCostGoods = Integer.parseInt(costGoods.getText().replace(" ", ""));
        if (realCostGoods == sum)
            System.out.println("Загальна сума, вказана вкорзині відповідає сумі цін, всіх добавлених.");

        else
            System.out.println("Загальна сума, вказана вкорзині НЕ відповідає сумі цін, всіх добавлених.");
    }

    public void dellGoods(List<WebElement> listPrice, WebElement delGoods, WebElement delWithoutSave) throws InterruptedException {
        int k = listPrice.size();
        {
            for (int i = 0; i < k; i++) {
                delGoods.click();
                delWithoutSave.click();
                Thread.sleep(3000);
            }
        }
    }

    public void checkCart(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue((element).isDisplayed());
        System.out.println("Корзина дійсно пуста");
    }
}
