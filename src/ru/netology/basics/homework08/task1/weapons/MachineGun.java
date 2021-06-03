package ru.netology.basics.homework08.task1.weapons;

public class MachineGun extends Weapon {
    public MachineGun() {
        super("Автомат");
    }

    @Override
    public void shot() {
        System.out.println("Тра-та-та");
    }
}