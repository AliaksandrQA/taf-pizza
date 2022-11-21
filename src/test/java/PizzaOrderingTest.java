import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PizzaOrderingTest extends TestConfiguration {
    PizzaHomePage pizzaHomePage;

    @Test
    public void addPizzaToBasket() {
        pizzaHomePage = new PizzaHomePage(driver);
        pizzaHomePage.openHomePage()
                .closeAdvertisementPopUp()
                .addPizzaToBasket();

        Assertions.assertTrue(pizzaHomePage.isBasketIconPresent());

    }

    @Test
    public void checkPizzaOrder() {
        pizzaHomePage = new PizzaHomePage(driver);
        String expected = pizzaHomePage.openHomePage()
                .closeAdvertisementPopUp()
                .submitOrder()
                .getOrderTitle();

        Assertions.assertEquals(expected,"4 Сезона","Необходимая пицца не добавлена");


    }

}
