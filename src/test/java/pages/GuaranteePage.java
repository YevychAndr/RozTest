package pages;

import org.openqa.selenium.WebDriver;

public class GuaranteePage extends BasePage{


    public GuaranteePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String heder = "Гарантия и сервисное обслуживание";

    public void checkGuaranteePageOpen() {
        checkCorrectPageOpen(heder);
    }
}
