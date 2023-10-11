import Model.Order;
import Model.Pizza;
import Service.PizzaService;


import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {


    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args){
        Pizza pizza1 = new Pizza("Roman", 25.50, true);
        Pizza pizza2 = new Pizza("Chicago", 37.99, true);
        Pizza pizza3 = new Pizza("California", 42.99, false);

        PizzaService pizzaService = new PizzaService(List.of(pizza1, pizza2, pizza3));

        logger.info(pizzaService.getAvailablePizzas());
        Order order1 = pizzaService.makeOrder(List.of(pizza1));
        logger.info(order1);
        Order order2 = pizzaService.makeOrder(List.of(pizza1, pizza2));
        logger.info(order2);
        try {
            Order order3 = pizzaService.makeOrder(List.of(pizza3));
        } catch (Exception ex) {
            logger.error("Taka pizza nie istnieje", ex);
        }

    }
}
