package ru.netology.basics.homework08.task1.weapons;

public class Slingshot extends Weapon {
    public Slingshot() {
        super("Рогатка");
    }

    @Override
    public void shot() {
        System.out.println("Пиу");
    }
}