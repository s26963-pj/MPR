package order;

import model.Pizza;
import model.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PizzaService {

    private List<Order> orderList = new ArrayList<>();
    private List<Pizza> pizzaList;

    public PizzaService(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    public Order makeOrder(List<Pizza> pizza) {
        // Sprawdzenie czy pizza jest dostępna
        for (Pizza p : pizza) {
            if (!pizzaList.contains(p)) {
                System.out.println("Niektóre z zamawianych pizz nie są dostępne.");
                return null;
            }
        }



        // Tworzenie obiektu Order
        int orderNumber = orderList.size() + 1;
        double totalPrice = calculateTotalPrice(pizza);
        Order order = new Order(orderNumber, pizza, totalPrice);



        // Dodajemy order do OrderList
        orderList.add(order);



        // Zwracamy order
        return order;
    }



    private double calculateTotalPrice(List<Pizza> pizza) {
        double totalPrice = 0.0;
        for (Pizza p : pizza) {
            totalPrice += p.getPrice();
        }
        return totalPrice;
    }


    public List<Pizza> getAvailablePizzas(){
        return pizzaList.stream()
                .filter(Pizza::isAvailable)
                .collect(Collectors.toList());
    }
}