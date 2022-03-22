package pruebasListasSimples;

import actoresApp.Actor;
import actoresApp.ListaActores;

public class PruebaListaActores {
	
	public static void main(String args[]){
		ListaActores l = new ListaActores();
		Actor a1 = new Actor("a");
		Actor a2 = new Actor("b");
		Actor a3 = new Actor("c");
		Actor a4 = new Actor("d");
		
		l.anadirActor(a1);
		l.anadirActor(a4);
		l.anadirActor(a4);
		l.anadirActor(a2);
		l.anadirActor(a3);
		l.eliminarActor(a1);
		
		
		System.out.println("Lista....");
		l.imprimir();
		System.out.println("Número de elementos: "+l.getTamano());
		
		
		System.out.println("Prueba Find ...............");
		System.out.println("b? " + l.buscarActor(a2).getNombre());
		System.out.println("d? " + l.buscarActor(a4).getNombre());
		System.out.println("null? "+l.buscarActor(a1));
		
	}

}
