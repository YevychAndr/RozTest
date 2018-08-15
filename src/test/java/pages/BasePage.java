package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {

    protected WebDriverWait wait;
    protected WebDriver driver;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        wait = new WebDriverWait(driver, 10);
        actions = new Actions(driver);
    }


    protected void click(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }

    protected void checkCorrectPageOpen(String heder){
        Assert.assertTrue((driver.findElement(By.xpath("//h1")).isDisplayed()), "Заголовок не відображається");
        Assert.assertEquals(heder, (driver.findElement(By.xpath("//h1")).getText()), "Ви не на очікуваній сторніці!");
    }

    protected void moveTo (WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(element).build().perform();
    }

}
