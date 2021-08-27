package ru.netology.multithreading.homework04.task1;

public class SpecialistThread extends Thread {

    private final Atc atc;

    public SpecialistThread(Atc atc) {
        this.atc = atc;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                String call = atc.pollCall();
                if (call != null) {
                    Thread.sleep(3000);
                    System.out.println(call + " done!");
                } else {
                    Thread.currentThread().interrupt();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}