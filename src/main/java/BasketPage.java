import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BasketPage extends Page {
    private final By orderCard = By.xpath("//div[@data-test='product-card-title']");

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public String getOrderTitle() {
        return driver.findElement(orderCard).getText();
    }

}