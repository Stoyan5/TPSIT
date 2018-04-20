/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

/**
 *
 * @author sraem
 */
public class Pizzeria implements Runnable {

    private static final int NUMERO_POSTI = 12;
    private Lock sezioneCritica;
    protected Semaphore postiLiberi;
    private String name;
    private final int MIN = 5;
    private final int MAX = 7;
    private Random randomNum;

    public Pizzeria() {
        postiLiberi = new Semaphore(NUMERO_POSTI);
        randomNum = new Random();
    }

    @Override
    public void run() {
        int time = 0;
        int entrano = 0;
        int wait = 2;
        int fine = 0;

        while ((fine <= NUMERO_POSTI) && (time < 60)) {
            entrano = randomNum(NUMERO_POSTI, fine);
            fine += entrano;
            for (int j = 0; j < entrano; j++) {
                int tempo = MIN + randomNum(MAX, MIN);
                new Thread(new Cliente()).start();
            }
            try {
                Thread.sleep(wait * 1000);
            } catch (InterruptedException ex) {
            }
            time += wait;
        }
    }
    
    private static int randomNum(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min) + min;
    }
    
}
