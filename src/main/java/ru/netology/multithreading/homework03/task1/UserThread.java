package ru.netology.multithreading.homework03.task1;

public class UserThread extends Thread {

    private static final int NUMBER = 5;
    public static int counter = 0;

    private final ToggleSwitch toggleSwitch;

    public UserThread(String name, ToggleSwitch toggleSwitch) {
        super(name);
        this.toggleSwitch = toggleSwitch;
    }

    @Override
    public void run() {
        while (counter != NUMBER) {
            if (!toggleSwitch.isToggleSwitch()) {
                try {
                    Thread.sleep(1000);
                    counter++;
                    System.out.println(Thread.currentThread().getName() + " включил тумблер!" + counter);
                    toggleSwitch.setToggleSwitch(true);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}