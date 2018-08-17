package pages;

import org.openqa.selenium.WebDriver;

public class ShippingPaymenPage extends BasePage {


    public ShippingPaymenPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public static String hederExpected = "Доставка и оплата";

}
