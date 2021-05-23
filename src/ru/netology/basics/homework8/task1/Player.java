package ru.netology.basics.homework8.task1;

import ru.netology.basics.homework8.task1.weapons.*;

public class Player {
    private Weapon[] weaponSlots;

    public Player() {
        weaponSlots = new Weapon[] {
                new Bazooka(),
                new MachineGun(),
                new Pistol(),
                new Slingshot(),
                new WaterGun()
        };
    }

    public String[] weaponNames() {
        String[] names = new String[getSlotsCount()];
        for (int i = 0; i < getSlotsCount(); i++) {
            names[i] = weaponSlots[i].getName();
        }
        return names;
    }

    public int getSlotsCount() {
        return weaponSlots.length;
    }

    public void shotWithWeapon(int slot) {
        if (slot < 0 || slot >= getSlotsCount()) {
            throw new IllegalArgumentException();
        }

        Weapon weapon = weaponSlots[slot];
        System.out.println(weapon.getName());
        weapon.shot();
    }
}