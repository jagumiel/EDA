package packSorteo;

import java.util.Random;

public class Bombonera {

	private static Bombonera mBombonera = new Bombonera();
	
	private Bombonera(){  }
	
	public static Bombonera getBombonera(){
		return mBombonera;
	}
	
	public ListaNumeros realizarSorteo(){
		ListaNumeros l = new ListaNumeros();
		Random rg = new Random();
		
		while(!l.estaCompleta()){
			int x = rg.nextInt(49);
			x++;
			if(!l.estaNumero(x)){
				l.addNumero(x);
			}
		}
		
		return l;
	}
	
}
