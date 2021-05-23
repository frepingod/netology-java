package ru.netology.basics.homework8.task1.weapons;

public abstract class Weapon {
    protected String name;

    public abstract void shot();

    public Weapon(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}