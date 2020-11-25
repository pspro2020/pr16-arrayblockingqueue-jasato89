package com.jasato.pr16;


import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Drier implements Runnable {

    private final Tray cleanTray;
    private final Tray toDryTray;




    public Drier(Tray cleanTray, Tray toDryTray){
        this.cleanTray = cleanTray;
        this.toDryTray = toDryTray;
    }


    @Override
    public void run() {
        Plates plate;
        while(!Thread.currentThread().isInterrupted()){
            try {
                plate= cleanTray.removeFromTray();
            } catch (InterruptedException e) {
                return;
            } try {
                dryPLate(plate);
            } catch (InterruptedException e) {
                return;
            }

        }

    }

    private void dryPLate(Plates plate) throws InterruptedException {
        Random random = new Random();
        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(3)+1);
        toDryTray.addTray(plate);
    }

}
