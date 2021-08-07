package ru.netology.patterns.homework04.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Order {

    private final LocalDateTime date;
    private final int sum;

    public Order(LocalDateTime date, int sum) {
        this.date = date;
        this.sum = sum;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return sum == order.sum && Objects.equals(date, order.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, sum);
    }

    @Override
    public String toString() {
        return "Order{" +
                "date=" + date +
                ", sum=" + sum +
                '}';
    }
}