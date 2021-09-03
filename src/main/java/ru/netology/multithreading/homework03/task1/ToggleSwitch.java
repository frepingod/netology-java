package ru.netology.multithreading.homework03.task1;

public class ToggleSwitch {

    private volatile boolean toggleSwitch;

    public ToggleSwitch(boolean toggleSwitch) {
        this.toggleSwitch = toggleSwitch;
    }

    public boolean isToggleSwitch() {
        return toggleSwitch;
    }

    public void setToggleSwitch(boolean toggleSwitch) {
        this.toggleSwitch = toggleSwitch;
    }
}