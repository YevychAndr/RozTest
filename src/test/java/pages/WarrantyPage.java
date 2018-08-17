package pages;

import org.openqa.selenium.WebDriver;

public class WarrantyPage extends BasePage{


    public WarrantyPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public static String hederExpected = "Гарантия и сервисное обслуживание";


}
