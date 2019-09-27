import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Listas {
	
	private static List<Integer> lista = Collections.synchronizedList(new ArrayList<Integer>());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				while(true) {
					lista.add(1);
					System.out.println("Añadido 1 - "+ lista);
				}
			}
		});
		
		t.start();
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				while(true) {
					if(!lista.isEmpty()) {
						lista.remove(0);
						System.out.println("Eliminado - " + lista);
					}
					
				}
			}
		});
		
		t2.start();
	}

}
