import java.util.Random;

import static java.lang.Thread.sleep;

public class Main{
	public static void main(String[]args){
		Pizzeria p = new Pizzeria(10);
        new Thread(p).start();
}
