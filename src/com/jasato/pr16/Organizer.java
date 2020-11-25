package com.jasato.pr16;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Organizer implements Runnable {


    private final Tray dryTray;
    private final Tray storeTray;



    public Organizer(Tray dryTray, Tray storeTray){
        this.dryTray = dryTray;
        this.storeTray = storeTray;
    }


    @Override
    public void run() {
        Plates plate;
        while(!Thread.currentThread().isInterrupted()){
            try {
                plate= dryTray.removeFromTray();
            } catch (InterruptedException e) {
                return;
            } try {
                storePlate(plate);
            } catch (InterruptedException e) {
                return;
            }

        }

    }

    private void storePlate(Plates plate) throws InterruptedException {
        Random random = new Random();
        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(2)+1);
        storeTray.addTray(plate);

    }


}