package com.jasato.pr16;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;


public class Tray {
    private final static int NUMBER_PLATES = 10;
    private ArrayBlockingQueue<Plates> arrayBlockingQueue = new ArrayBlockingQueue<>(NUMBER_PLATES);
    private final DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Tray() {}

    public Tray(List<Plates> plates) {
        for (Plates plato: plates) {
            arrayBlockingQueue.add(plato);
        }
    }




    protected void addTray(Plates plato) throws InterruptedException {
        System.out.printf("%s - %s plato nº %d\n", LocalTime.now().format(format), Thread.currentThread().getName(), plato.getNum());
        arrayBlockingQueue.put(plato);

    }

    protected Plates removeFromTray() throws InterruptedException {
        Plates plato = null;
        plato = arrayBlockingQueue.take();
        return plato;

    }


}

