package Service;

import Model.Pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import Model.*;
import Exception.*;

public class PizzaService {
    private List<Order> orderList = new ArrayList<>();
    private List<Pizza> pizzaList;

    public PizzaService(List<Pizza> pizzaList){
        this.pizzaList = pizzaList;
    }

    public Order makeOrder(List<Pizza> orderedPizzas){
        if (getAvailablePizzas().containsAll(orderedPizzas)){
            double sum = orderedPizzas.stream()
                    .map(Pizza::getPrice)
                    .reduce(0D, (current, price) -> current + price);
            Order order = new Order(orderList.size(), orderedPizzas, sum);

            orderList.add(order);

            return order;
        } else {
            throw new PizzaNotFoundException();
        }
    }

    public List<Pizza> getAvailablePizzas(){
        return pizzaList.stream()
                .filter(Pizza::isAvailable)
                .collect(Collectors.toList());
    }
}
