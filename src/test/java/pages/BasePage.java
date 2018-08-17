package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class BasePage {

    protected WebDriverWait wait;
    protected WebDriver driver;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        wait = new WebDriverWait(driver, 5);
        actions = new Actions(driver);
    }



    protected void click(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }


    protected void checkMenuItemPresent (List<WebElement> element){
        Assert.assertTrue(element.size() > 0, "Потрібного пункту меню немає.");
    }

    protected void moveTo (WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(element).build().perform();
    }

}
