package scenerio;

import base.BaseTest;
import base.ConfigReader;
import org.junit.Test;
import page.BasketPageObj;
import page.ShopPageObj;
import stepDef.StepDef;

public class Scenerio extends BaseTest {
    StepDef stepDef = new StepDef();

    @Test()
    public void test() throws InterruptedException {

        stepDef.waitForPageToLoad(20); //WAIT LOAD FOR HOMEPAGE
        stepDef.existElementClick(BasketPageObj.closeCookie, 5); //IF EXIST,CLOSE COOKIE
        //stepDef.hover(HomePageObj.loginIcon, 5); //HOVER LOGIN ICON
        //stepDef.clickWithWait(HomePageObj.loginPageButton, 5); // CLICK LOGIN BUTTON
        //stepDef.sendTextWithWait(HomePageObj.userNameTextBox, ConfigReader.userName, 5); //SEND USERNAME
        //stepDef.sendTextWithWait(HomePageObj.passWordTextBox, ConfigReader.passWord, 5); //SEND PASSWORD
        //stepDef.clickWithWait(HomePageObj.loginButton, 5); //CLICK LOGIN BUTTON
        //stepDef.wait(10); //FOR MANUEL LOGIN BECAUSE BAN
        //stepDef.loginControl(HomePageObj.myAccountText,ConfigReader.userName,5);
        stepDef.sendTextWithWait(ShopPageObj.searchTextBox, ConfigReader.keyWord, 5); //SEARCH 'BİLGİSAYAR'
        stepDef.clickWithWait(ShopPageObj.searchButton, 5); //CLICK SEARCH BUTTON
        stepDef.selectPageNumber(ShopPageObj.listPageNumbers, ConfigReader.pageNumber, 7); //SELECT PAGE NUMBER
        stepDef.controlPageNumber(ShopPageObj.selectedPageNumber, 7); //CONTROL FOR NUMBER OF PAGE
        stepDef.randomSelectProduct(ShopPageObj.productList, 5); //SELECT RANDOM PRODUCT
        stepDef.keepProductPrice(BasketPageObj.highPriceOnPage, BasketPageObj.lowPriceOnPage, 5); //SAVE PRICE
        stepDef.clickWithWait(BasketPageObj.addBasketButton, 5); //ADD BASKET
        stepDef.clickWithWait(BasketPageObj.basketIcon, 5); //CLICK BASKET
        stepDef.controlForStrValues(BasketPageObj.basketPrice, 5); //CONTROL PRICE
        stepDef.selectElement(BasketPageObj.selectList, BasketPageObj.selectOption, 5); // ADD AMOUNT(TOTAL=2)
        stepDef.productAmountControl(BasketPageObj.selectList, BasketPageObj.productAmountBasket, 5); //CONTROL AMOUNT
        stepDef.clickWithWait(BasketPageObj.deleteButton, 5); //DELETE PRODUCT IN BASKET
        stepDef.emptyBasketControl(BasketPageObj.emptyCardInfo, 15); //CONTROL FOR EMPTY BASKET
    }
}
