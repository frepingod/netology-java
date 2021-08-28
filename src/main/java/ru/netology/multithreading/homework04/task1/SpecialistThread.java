package ru.netology.multithreading.homework04.task1;

public class SpecialistThread extends Thread {

    private final Atc atc;

    public SpecialistThread(Atc atc) {
        this.atc = atc;
    }

    @Override
    public void run() {
        while (Main.numberOfAnsweredCalls != CallGeneratorThread.NUMBER_OF_CALLS) {
            try {
                String call = atc.pollCall();
                if (call != null) {
                    Thread.sleep(3000);
                    Main.numberOfAnsweredCalls++;
                    System.out.println(call + " done!");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}