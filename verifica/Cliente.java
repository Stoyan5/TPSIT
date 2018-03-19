public class Cliente implements Runnable{
	private String name;
	private Pizzeria pizzeria;
	
	public Cliente(String name){
		this.name = name;
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
