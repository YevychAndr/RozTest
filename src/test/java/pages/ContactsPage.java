package pages;

import org.openqa.selenium.WebDriver;

public class ContactsPage extends BasePage {

    public ContactsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public static String hederExpected = "Консультации и заказ по телефонам";

}
