
public class Sincronizacion {

	static int contador=0;
	
	public static void main(String[] args) throws InterruptedException
	{
		System.out.println("Empieza el main");
		
		Thread []hilos=new Thread[5];
		for(int i=0; i<5; i++)
		{
			hilos[i]= new Thread(new miRunable(i));
			hilos[i].start();
		}
		
		System.out.println("Pausa de 10 segundos");
		for(int i=0; i<5; i++)
			hilos[i].join();
			
		System.out.println("Valor del contador: "+contador);
		System.out.println("Acaba el main");
	}
	
	private static class miRunable implements Runnable
	{
		int numero;
		public miRunable(int num)
		{
			numero=num;
			Thread.currentThread().setName("Hilo "+numero);
		}
		
		public static synchronized void sumar()
		//public void sumar()
		{
			contador++;
		}
		
		public void run()
		{
			//Thread.currentThread().setName("Hilo "+numero);
			try
			{
				Thread.sleep(1_000);
			}catch(Exception e)
			{
				
			}
				for(int i=0; i<500;i++) 
					sumar();
				String name=Thread.currentThread().getName();
				System.out.println("Acaba el "+name);
		}
	}
}
