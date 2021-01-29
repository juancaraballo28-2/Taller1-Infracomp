import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreadParteBRunnable implements Runnable {

private int n;
	
	private boolean par;
	
	private int segundosADormir;
	
	public ThreadParteBRunnable(int n, boolean par){
		
		this.n = n;
		
		this.par = par;
		
		//Acá se modifica la cantida de ms a dormir el Thread
		
		this.segundosADormir = 1000;

	}

	
	public void run(){
		
		for(int i=1; i<=this.n; i++){
			
			if(this.par && i%2==0) System.out.println(i);
			
			else if(!this.par && i%2==1) System.out.println(i);
			
			try {
				Thread.sleep(this.segundosADormir);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	public static void main(String[]args){
		
		
		
		System.out.println("Ingrese el número de la cota superior: ");
		
		BufferedReader input = new BufferedReader (new InputStreamReader (System.in));
		
		Integer num = 1;
		
		try {
			num = Integer.parseInt(input.readLine());
		} 
		catch (NumberFormatException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		Thread hilo1 = new Thread(new ThreadParteBRunnable(num,true));
		
		Thread hilo2 = new Thread(new ThreadParteBRunnable(num,false));
		
		
		
		hilo1.start();
		
		hilo2.start();
		
	}
	
}
