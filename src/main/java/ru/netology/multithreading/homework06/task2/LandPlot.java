package ru.netology.multithreading.homework06.task2;

public class LandPlot {

    private final int length;
    private final int width;
    private final int price;

    public LandPlot(int length, int width, int price) {
        this.length = length;
        this.width = width;
        this.price = price;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "LandPlot{" +
                "length=" + length +
                ", width=" + width +
                ", price=" + price +
                '}';
    }
}