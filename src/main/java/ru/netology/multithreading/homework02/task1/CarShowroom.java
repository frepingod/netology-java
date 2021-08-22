package ru.netology.multithreading.homework02.task1;

import java.util.ArrayList;
import java.util.List;

public class CarShowroom {

    public static final int WAITING_TIME = 1000;
    public static final int PREPARATION_TIME = 1500;

    private final List<Car> cars = new ArrayList<>();

    public synchronized Car sellCar() {
        try {
            System.out.println(Thread.currentThread().getName() + ": зашел в автосалон");
            while (cars.size() == 0) {
                System.out.println("Продавец: Машин нет!");
                wait();
            }
            Thread.sleep(WAITING_TIME);
            System.out.println(Thread.currentThread().getName() + ": уехал на новеньком авто");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return cars.remove(0);
    }

    public synchronized void makeCar() {
        try {
            while (cars.size() < 10) {
                Thread.sleep(PREPARATION_TIME);
                cars.add(new Car());
                System.out.println(Thread.currentThread().getName() + ": выпустил 1 авто");
                notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}