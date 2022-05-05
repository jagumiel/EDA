package packSorteo;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaBoletos {

	private static ListaBoletos miListaBoletos=new ListaBoletos();
	private ArrayList<Boleto> lista;
	
	private ListaBoletos() 
	{
		this.lista=new ArrayList<Boleto>();
	}
	
	public static ListaBoletos getListaBoletos()
	{
		return miListaBoletos;
	}
	
	//Cambiar a public para pasar los tests
	public ArrayList<Boleto> getLista(){
		return this.lista;
	}
	
	
	//Cambiar a public para pasar los tests
	public ArrayList<Boleto> getPremiados(){
		ArrayList<Boleto> lb = new ArrayList<Boleto>();
		ListaNumeros ganadores = Bombonera.getBombonera().realizarSorteo();
		
		//Para las pruebas:
		Iterator<Integer> it = ganadores.getIterador();
		System.out.println("Ganadores: ");
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
		
		System.out.println();//Salto de línea
		
		for(Boleto b:this.getLista()){
				if(b.obtNumeroAciertos(ganadores)>=4){
					lb.add(b);
				}
		}
		return lb;
	}
	
	
}
