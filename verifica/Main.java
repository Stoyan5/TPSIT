import java.util.Random;

import static java.lang.Thread.sleep;

public class Main{
	public static void main(String[]args){
		Pizzeria p = new Pizzeria();
        new Thread(p).start();
}
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.*;

public class Pizzeria implements Runnable{
	private static final int NUMERO_POSTI = 12;
	private Lock sezioneCritica;
	private Semaphore postiLiberi;
	private String name;
	private final int MIN = 5;
	private final int MAX = 7;
	private Random randomNum;
	
	public Pizzeria(){
		postiLiberi = new Semaphore(NUMERO_POSTI);
		randomNum=new Random();
	}
	
	@Override
    public void run() {
		int time = 0;
        int entrano = 0;
        int wait = 2;
        int fine = 0;
		
		while((fine <= NUMERO_POSTI) && (time<60)) {
            entrano = r.nextInt(NUMERO_POSTI-fine);
            fine+=entrano;
            for (int j = 0; j < entrano; j++) {
                int tempo = MIN+r.nextInt(MAX-MIN);
                new Thread(new Cliente(nomi[r.nextInt(nomi.length)]+j)).start();
            }
            try {Thread.sleep(wait*1000);} catch (InterruptedException ex) {}
            time+=wait;
        }
	}
}

public class Cliente implements Runnable{
	private Pizzeria pizzeria;
	
	public Cliente(String name){
	}
	
	public void run(){
			try {
				Pizzeria.postiLiberi.acquire;
				sleep(randomNum(1000,12000));
			} catch (InterruptedException e) {}
			finally{
				Pizzeria.postiLiberi.release;
			}
	}
	
	private static int randomNum(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
