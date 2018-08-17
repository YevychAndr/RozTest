package pages;

import org.openqa.selenium.WebDriver;


public class CreditPage extends BasePage {

    public CreditPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public static String hederExpected = "Покупка в кредит";


}
