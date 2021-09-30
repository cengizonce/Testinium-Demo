package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShopPageObj extends BaseTest {

    @FindBy (css = "[data-cy='header-search-input']")
    public static WebElement searchTextBox;

    @FindBy (css = "[data-cy='search-find-button']")
    public static WebElement searchButton;

    @FindBy (css = "[data-testid='pagination-list-item']>a>span")
    public static List<WebElement> listPageNumbers;

    @FindBy (css = "[aria-current='true']")
    public static WebElement selectedPageNumber;

    @FindBy (css = "[class='sc-1nx8ums-0 dyekHG']")
    public static List<WebElement> productList;

}
