package pruebas;

import java.util.ArrayList;

import lab4.*;

public class Pruebas {
	public void pruebaPos(){
		ArrayList<Actor> miLista = new ArrayList<Actor>();
		Actor a1=new Actor("Pedro");
		Main.getMain().buscarPosMin(miLista);
	}
	
}
