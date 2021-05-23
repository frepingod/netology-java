package ru.netology.basics.homework8.task1.weapons;

public class Pistol extends Weapon {
    public Pistol() {
        super("Пистолет");
    }

    @Override
    public void shot() {
        System.out.println("Пив-пав");
    }
}