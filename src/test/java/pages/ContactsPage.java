package pages;

import org.openqa.selenium.WebDriver;

public class ContactsPage extends BasePage {

    public ContactsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String heder = "Консультации и заказ по телефонам";

    public void checkContactsPageOpen() {
        checkCorrectPageOpen(heder);
    }
}
