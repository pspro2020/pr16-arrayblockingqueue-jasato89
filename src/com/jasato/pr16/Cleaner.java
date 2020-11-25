package com.jasato.pr16;


import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Cleaner implements Runnable {

    private Tray dirtyTray;
    private Tray cleanTray;



    Cleaner(Tray dirtyTray, Tray cleanTray) {
        this.dirtyTray = dirtyTray;
        this.cleanTray = cleanTray;
    }


    @Override
    public void run() {
        Plates plate;
        while (!Thread.currentThread().isInterrupted()) {
            try {
                plate = takePlate();
            } catch (InterruptedException e) {
                return;
            }
            try {
                clean(plate);
            } catch (InterruptedException e) {
                return;
            }

        }

    }

    private void clean(Plates plate) throws InterruptedException {
        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(5) + 4);
        cleanTray.addTray(plate);

    }

    private Plates takePlate() throws InterruptedException {
        return dirtyTray.removeFromTray();
    }
}
