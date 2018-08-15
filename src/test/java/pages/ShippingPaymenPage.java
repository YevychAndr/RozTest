package pages;

import org.openqa.selenium.WebDriver;

public class ShippingPaymenPage extends BasePage {


    public ShippingPaymenPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String heder = "Доставка и оплата";

    public void checkShippingPaymenPageOpen() {
        checkCorrectPageOpen(heder);
    }
}
