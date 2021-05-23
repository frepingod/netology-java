package ru.netology.basics.homework8.task1.weapons;

public class Bazooka extends Weapon {
    public Bazooka() {
        super("Базука");
    }

    @Override
    public void shot() {
        System.out.println("Бум бабах");
    }
}