import model.MainMenu;
import model.SubMenu;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

public class TestRun extends BaseTest{

    @DataProvider(name = "loginData")
    public Object[][] getData(){
        return new String[][]{
                {"yevych.a@ya.ru", "Vvs1983"}

                };
    }

    @Test(dataProvider = "loginData")
    public void test(String login, String password) throws InterruptedException {
        AuthorizedPage authorizedPage = new AuthorizedPage(driver);
        authorizedPage.checkNotLogged();
        LoginPage loginPage = authorizedPage.callLoginPage();
        loginPage.login(login, password);
        authorizedPage.checkLogged();

        authorizedPage.openCatalogGoods();
        authorizedPage.openCategoryGoods(MainMenu.SPORT);
        GoodsPage goodsPage = authorizedPage.openSubcategoryGoods(SubMenu.KATUSHKY);

        AddedToCartPage addedToCartPage = goodsPage.buyGoods();
        addedToCartPage.continueShopping();
        authorizedPage.openCatalogGoods();
        authorizedPage.openCategoryGoods(MainMenu.DACHA);
        authorizedPage.openSubcategoryGoods(SubMenu.TACHKY);
        goodsPage.buyGoods();
        addedToCartPage.continueShopping();
        authorizedPage.openCatalogGoods();
        authorizedPage.openCategoryGoods(MainMenu.DYTYACHITOVARY);
        authorizedPage.openSubcategoryGoods(SubMenu.RADIONYANYA);
        goodsPage.buyGoods();
        addedToCartPage.continueShopping();

        CartPage cartPage = authorizedPage.goCart();
        cartPage.checkSumCart();
        cartPage.dellAllGoods();

        cartPage.checkCartEmpty();

        QuestionAnswerPage questionAnswerPage = authorizedPage.callQuestionAnswer();
        questionAnswerPage.checkQuestionAnswerPageOpen();
        CreditPage creditPage = authorizedPage.callCreditPage();
        creditPage.checkCreditPageOpen();
        ShippingPaymenPage shippingPaymenPage = authorizedPage.callShippingPaymen();
        shippingPaymenPage.checkShippingPaymenPageOpen();
        GuaranteePage guaranteePage = authorizedPage.callGuaranteePage();
        guaranteePage.checkGuaranteePageOpen();
        ContactsPage contactsPage = authorizedPage.callContactsPage();
        contactsPage.checkContactsPageOpen();
    }

}
