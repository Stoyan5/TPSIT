import java.util.Date;
import java.util.Array;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by studente on 30/11/17.
 */
public class TovaMaggiore {
    public static void main(String[] args) throws InterruptedException {
		
    public static final int NUMERO_THREAD = 10;
    public static final int DIMENSIONE_ARRAY = 100;
    public static final int MINIMO = 0;
    public static final int MASSIMO = Integer.MAX_VALUE-1;
    public static void main(String[] args) throws InterruptedException {
        int massimo;
        CountDownLatch cdl;
        int[] array;
        int[] results;

        array = arrayRandom(DIMENSIONE_ARRAY, MINIMO, MASSIMO);
        countdownLatch = new CountDownLatch(NUMERO_THREAD);
        results = new int[NUMERO_THREAD];

        System.out.println("Array: " + Arrays.toString(array));

        for(int i=0; i<NUMERO_THREAD; i++){
            
            (new Thread(new MaxFinder(array, DIMENSIONE_ARRAY/ALL_THREADS * i, DIMENSIONE_ARRAY/ALL_THREADS * (i+1), countdownLatch, results, i))).start();
        }

        countdownLatch.await();

        massimo = array[0];
        for(int i=0; i<NUMERO_THREAD; i++)
            if(massimo < massimi[i]) massimo = massimi[i];

        System.out.println("Massimi: " + Arrays.toString(massimi));

        System.out.println("Massimo: " + massimo);
    }
    public static int[] arrayRandom(int length, int min, int max) {
        Random generatore = new Random(System.currentTimeMillis());
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = generatore.nextInt(max+1 - min) + min;
        }
        return array;
    }
}
