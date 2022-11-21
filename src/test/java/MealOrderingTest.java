import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MealOrderingTest extends TestConfiguration {
    PizzaHomePage pizzaHomePage;

    @Test
    public void addPizzaToBasket() {
        pizzaHomePage = new PizzaHomePage(driver);
        pizzaHomePage.openHomePage()
                .closeAdvertisementPopUp()
                .addPizzaToBasket();

        Assertions.assertTrue(pizzaHomePage.isProductAddedToBasket());

    }

    @Test
    public void addDrinkToBasket() {
        pizzaHomePage = new PizzaHomePage(driver);
        pizzaHomePage.openHomePage()
                .closeAdvertisementPopUp()
                .addDrinkToBasket();

        Assertions.assertTrue(pizzaHomePage.isProductAddedToBasket());
    }

    @Test
    public void checkPizzaOrder() {
        pizzaHomePage = new PizzaHomePage(driver);
        String expected = pizzaHomePage.openHomePage()
                .closeAdvertisementPopUp()
                .submitPizzaOrder()
                .getOrderTitle();

        Assertions.assertEquals(expected, "4 Сезона", "Необходимая пицца не добавлена");


    }
    @Test
    public void checkDrinkOrder() {
        pizzaHomePage = new PizzaHomePage(driver);
        String expected = pizzaHomePage.openHomePage()
                .closeAdvertisementPopUp()
                .submitDrinkOrder()
                .getOrderTitle();

        Assertions.assertEquals(expected, "Чай Клюква с имбирем", "Необходимый напиток не добавлен");


    }

}
