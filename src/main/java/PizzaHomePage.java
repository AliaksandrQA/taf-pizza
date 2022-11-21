import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PizzaHomePage extends Page {
    protected static String pizzaSiteUrl = "https://dominos.by/";
    private final By closeAdvertisementButton = By.xpath("//button[@class='custom-button custom-button--transparent custom-button--no-paddings custom-button--size-small custom-modal__close-button']");
    private final By closeCookieButton = By.xpath("//div[@class='sm-notify-accept']");
    private final By fullBasketIcon = By.xpath("//span[@class='jss158']");
    private final By pizzaSection = By.xpath("//li[@class='horizontal-menu__list-item'][1]/a");
    private final By drinkSection = By.xpath("//span[text()='Напитки']");
    private final By addDrinkToBasket = By.xpath("//div[text()='Чай Клюква с имбирем']");
    private final By diameterPizzaValue = By.xpath("//div[text()='4 Сезона']/../div[@class='modifications']/div[@class='modifications__content']/div[1]");
    private final By enormousPizzaSize = By.xpath("//div[text()='4 Сезона']/../div[@class='modifications']/div[@class='modifications__content']/div[1]/div/div/div/select/option[2]");
    private final By addPizzaToBasket = By.xpath("//div[text()='4 Сезона']/../div[@class='product-card__modification-summary']/div[2]");
    private final By basket = By.xpath("//div[@data-test='cart-button']");
    private final By submitOrderButton = By.xpath("//div[contains(@class,'cart-button__mini-bag-actions cart-button__mini-bag-actions--bottom')]");


    public PizzaHomePage(WebDriver driver) {
        super(driver);
    }

    public PizzaHomePage openHomePage() {
        driver.navigate().to(pizzaSiteUrl);
        return this;
    }

    public PizzaHomePage closeAdvertisementPopUp() {
        driver.findElement(closeAdvertisementButton).click();
        return this;
    }

    public PizzaHomePage addPizzaToBasket() {
        driver.findElement(pizzaSection).click();
        driver.findElement(diameterPizzaValue).click();
        driver.findElement(enormousPizzaSize).click();
        driver.findElement(addPizzaToBasket).click();
        return new PizzaHomePage(driver);
    }

    public PizzaHomePage addDrinkToBasket() {
        driver.findElement(drinkSection).click();
        driver.findElement(closeCookieButton).click();
        driver.findElement(addDrinkToBasket).click();
        return new PizzaHomePage(driver);
    }

    public BasketPage submitPizzaOrder() {
        addPizzaToBasket();
        driver.findElement(basket).click();
        driver.findElement(closeCookieButton).click();
        driver.findElement(submitOrderButton).click();
        return new BasketPage(driver);
    }

    public BasketPage submitDrinkOrder() {
        addDrinkToBasket();
        driver.findElement(basket).click();
        driver.findElement(closeCookieButton).click();
        driver.findElement(submitOrderButton).click();
        return new BasketPage(driver);
    }

    public boolean isProductAddedToBasket() {
        return !driver.findElements(fullBasketIcon).isEmpty();

    }
}
