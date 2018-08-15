package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class QuestionAnswerPage extends BasePage {

    public QuestionAnswerPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String heder = "Вопросы и ответы";

    public void checkQuestionAnswerPageOpen (){
        checkCorrectPageOpen(heder);
    }
}
