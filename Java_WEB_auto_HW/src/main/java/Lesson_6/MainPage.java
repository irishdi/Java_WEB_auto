package Lesson_6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class MainPage extends BaseView{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "responsiveAccountHeader_openAccountButtonMobile_rightSection")
    private WebElement myAccountButton;

    @Step("Нажать на кнопку Мой аккаунт")
    public MainPage clickMyAccountButton(){
        myAccountButton.click();
        return this;
    }

    @FindBy(css = ".responsiveFlyoutMenu_burgerMenu")
    private WebElement burgerMenu;

    @Step("Развернуть меню")
    public MainPage clickBurgerMenu(){
        burgerMenu.click();
        return this;
    }

    private final static String BRAND_BUTTON_LOCATOR_BY_XPATH =
            "//a[contains (@class, 'responsiveFlyoutMenu_levelOneLink') and contains (@data-context, 'Бренды')]";
        @FindBy(xpath = BRAND_BUTTON_LOCATOR_BY_XPATH)
    private WebElement brandButton;

    @Step("Нажать на Бренды")
    public MainPage clickBrandButton(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(BRAND_BUTTON_LOCATOR_BY_XPATH)));
        brandButton.click();
        return this;
    }

    private final static String LETTER_B_LOCATOR_BY_XPATH = "//a[@href='#panel-letter-B']";
    @FindBy(xpath = LETTER_B_LOCATOR_BY_XPATH)
    private WebElement letterBButton;

    @Step("Выбрать букву бренда")
    public MainPage clickBrandLetter(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LETTER_B_LOCATOR_BY_XPATH)));
        letterBButton.click();
        return this;
    }

    private final static String BRAND_LIST_LOCATOR_BY_LINKED_TEXT = "Babyliss";
    @FindBy(linkText = BRAND_LIST_LOCATOR_BY_LINKED_TEXT)
    private WebElement brandName;

    @Step("Выбрать бренд по имени")
    public MainPage clickToBrandByName() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(BRAND_LIST_LOCATOR_BY_LINKED_TEXT)));
        brandName.click();
        return new MainPage(driver);
    }

    private final static String BRAND_ITEMS_LIST_LOCATOR_BY_XPATH = "//div[@class='productBlock ']";
    @FindBy(xpath = BRAND_ITEMS_LIST_LOCATOR_BY_XPATH)
    private List<WebElement> brandItemsList;

    @Step("Выбрать товар по наименованию")
    public MainPage clickToBrandItem(){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(BRAND_ITEMS_LIST_LOCATOR_BY_XPATH)));
        brandItemsList.stream().findFirst().get().click();
        return new MainPage(driver);
    }

    private final static String ADD_TO_BASKET_BUTTON_LOCATOR_BY_XPATH = "//button[@data-component='productAddToBasket']";
    @FindBy(xpath = ADD_TO_BASKET_BUTTON_LOCATOR_BY_XPATH)
    private WebElement addToBasketButton;

    @Step("Добавить в корзину")
    public MainPage clickAddToBasket(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(ADD_TO_BASKET_BUTTON_LOCATOR_BY_XPATH)));
        addToBasketButton.click();
        return this;
    }


    @FindBy(css=".headerSearch_toggleForm > .headerSearch_spyglass")
    private WebElement searchGlass;

    @Step("Нажать поиск")
    public MainPage clickSearchGlass(){
        searchGlass.click();
        return this;
    }

    @FindBy(id="header-search-input")
    private WebElement searchInput;

    @Step("Ввести даныне для поиска")
    public MainPage fillSearchInput(String searchItem){
        searchInput.sendKeys(searchItem);
        return this;
    }

    @FindBy(css = ".headerSearch_button > .headerSearch_spyglass")
    private WebElement searchButton;

    @Step("Нажать кнопку поискового запроса")
    public MainPage clickSearchButton(){
        searchButton.click();
        return new MainPage(driver);
    }

    @FindBy(xpath = "//div//span[@class='js-enhanced-ecommerce-data hidden']")
    private List<WebElement> searchItems;

    @Step("Проверка наименования товара для поиска")
    public MainPage checkSearchItem(String searchItem){
        assertThat(String.valueOf(searchItems.stream().allMatch(s -> s.getAttribute("data-product-brand").contains(searchItem))), true);
        return this;
    }

    @FindBy(linkText = "Служба Поддержки")
    private WebElement helpLink;

    @Step("Перейти по ссылке Служба поддержки")
    public MainPage clickHelpLink(){
        helpLink.click();
        return new MainPage(driver);
    }

}
