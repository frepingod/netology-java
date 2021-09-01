package ru.netology.multithreading.homework03.task1;

public class ToyThread extends Thread {

    @Override
    public void run() {
        while (!isInterrupted()) {
            if (Main.isToggleSwitchOn) {
                System.out.println("Поток-игрушка выключил тумблер!" + UserThread.counter);
                Main.isToggleSwitchOn = false;
            }
        }
    }
}