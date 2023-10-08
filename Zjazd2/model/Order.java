package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Data
public class Order {
    private int number;
    private List<Pizza> orderedPizzas;
    private double price;

    public Order(int number, List<Pizza> orderedPizzas, double price) {
        this.number = number;
        this.orderedPizzas = orderedPizzas;
        this.price = price;
    }
}