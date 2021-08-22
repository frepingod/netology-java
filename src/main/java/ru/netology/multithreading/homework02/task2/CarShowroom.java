package ru.netology.multithreading.homework02.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CarShowroom {

    public static final int WAITING_TIME = 1000;
    public static final int PREPARATION_TIME = 1500;

    private final Lock lock = new ReentrantLock(true);
    private final Condition condition = lock.newCondition();

    private final List<Car> cars = new ArrayList<>();

    public void sellCar() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ": зашел в автосалон");
            while (cars.size() == 0) {
                System.out.println("Продавец: Машин нет!");
                condition.await();
            }
            Thread.sleep(WAITING_TIME);
            cars.remove(0);
            System.out.println(Thread.currentThread().getName() + ": уехал на новеньком авто");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void makeCar() {
        lock.lock();
        try {
            while (cars.size() < 10) {
                Thread.sleep(PREPARATION_TIME);
                cars.add(new Car());
                System.out.println(Thread.currentThread().getName() + ": выпустил 1 авто");
                condition.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}