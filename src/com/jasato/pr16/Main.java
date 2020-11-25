package com.jasato.pr16;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Plates> plate = new ArrayList<>(List.of(new Plates(0), new Plates(1), new Plates(2), new Plates(3), new Plates(4), new Plates(5), new Plates(6), new Plates(7)));
        Tray dirtyTray = new Tray(plate);
        Tray washingTray = new Tray();
        Tray dryingTray = new Tray();
        Tray storingTray = new Tray();
        Thread washer = new Thread(new Cleaner(dirtyTray, washingTray), "Fregar");
        Thread dryer = new Thread(new Drier(washingTray, dryingTray), "Secar");
        Thread storer = new Thread(new Organizer(dryingTray, storingTray), "Guardar");


        washer.start();
        dryer.start();
        storer.start();
        Thread.sleep(60000);
        washer.interrupt();
        dryer.interrupt();
        storer.interrupt();
        washer.join();
        dryer.join();
        storer.join();
        System.out.println("Happy Birthday!!");


    }
}
