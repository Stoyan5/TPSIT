/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author sraem
 */
public class Main {

    public static void main(String[] args) {
        Pizzeria p = new Pizzeria();
        new Thread(p).start();
    }
}
