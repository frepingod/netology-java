package ru.netology.multithreading.homework03.task1;

public class ToyThread extends Thread {

    private final ToggleSwitch toggleSwitch;

    public ToyThread(String name, ToggleSwitch toggleSwitch) {
        super(name);
        this.toggleSwitch = toggleSwitch;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            if (toggleSwitch.isToggleSwitch()) {
                System.out.println(Thread.currentThread().getName() + " выключил тумблер!" + UserThread.counter);
                toggleSwitch.setToggleSwitch(false);
            }
        }
    }
}