package ru.netology.patterns.homework04.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Product {

    private String name;
    private int price;
    private String brand;
    private final List<Integer> allRatings;
    private double rating;

    public Product(String name, int price, String brand) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        allRatings = new ArrayList<>();
        rating = 0;
    }

    public void rateProduct(int rate) {
        if (rate < 1) {
            rate = 1;
        }

        if (rate > 5) {
            rate = 5;
        }

        allRatings.add(rate);
        rating = allRatings.stream().mapToDouble(value -> value).sum() / allRatings.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Integer> getAllRatings() {
        return allRatings;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price
                && Double.compare(product.rating, rating) == 0
                && Objects.equals(name, product.name)
                && Objects.equals(brand, product.brand)
                && Objects.equals(allRatings, product.allRatings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, brand, allRatings, rating);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", allRatings=" + allRatings +
                ", rating=" + rating +
                '}';
    }
}