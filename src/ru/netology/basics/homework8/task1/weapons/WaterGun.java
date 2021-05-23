package ru.netology.basics.homework8.task1.weapons;

public class WaterGun extends Weapon {
    public WaterGun() {
        super("Водяной пистолет");
    }

    @Override
    public void shot() {
        System.out.println("Осторожно, залита горячая вода");
    }
}