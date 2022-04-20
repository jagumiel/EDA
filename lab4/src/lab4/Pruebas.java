package lab4;

import java.util.ArrayList;

public class Pruebas {
	public void pruebaPos(){
		ArrayList<Actor> miLista = new ArrayList<Actor>();
		Actor a1=new Actor("Pedro");
		Main.getMain().buscarPosMin(miLista);
	}
	
}
