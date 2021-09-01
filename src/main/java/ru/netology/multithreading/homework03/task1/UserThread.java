package ru.netology.multithreading.homework03.task1;

public class UserThread extends Thread {

    private static final int NUMBER = 5;
    public static int counter = 0;

    @Override
    public void run() {
        while (counter != NUMBER) {
            if (!Main.isToggleSwitchOn) {
                try {
                    Thread.sleep(1000);
                    counter++;
                    System.out.println("Поток-пользователь включил тумблер!" + counter);
                    Main.isToggleSwitchOn = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}