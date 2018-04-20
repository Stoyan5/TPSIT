/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.Random;
import java.lang.Thread;
import java.util.concurrent.Semaphore;

/**
 *
 * @author sraem
 */
public class Cliente implements Runnable {

    private Semaphore postiLiberi;
    private Pizzeria pizzeria;

    public Cliente() {
    }

    @Override
    public void run() {
        try {
            this.postiLiberi.acquire();
            Thread.sleep(randomNum(1000, 12000));
        } catch (InterruptedException e) {
        } finally {
            this.postiLiberi.release();
        }
    }

    private static int randomNum(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
