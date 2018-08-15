package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreditPage extends BasePage{

    public CreditPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String heder = "Покупка в кредит";

    public void checkCreditPageOpen() {
        checkCorrectPageOpen(heder);
    }
}
