package packSorteo;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaNumeros {
	
	private ArrayList<Integer> listaNumeros;
	
	public ListaNumeros(){
		this.listaNumeros = new ArrayList<Integer>();
	}
	
	private ArrayList<Integer> getLista(){
		return this.listaNumeros;
	}
	
	public boolean estaNumero(int pNum){
		return this.getLista().contains(pNum);
	}
	
	public void addNumero(int pNum){
		try{
			if(!this.estaCompleta()){
				this.getLista().add(pNum);
			}else{
				throw new Exception();
			}
		}catch(Exception e){
			System.out.println("La lista está llena");
		}
	}
	
	public boolean estaCompleta(){
		return this.getLista().size()>=6;
	}
	
	public Iterator<Integer> getIterador(){
		return this.getLista().iterator();
	}
	
	public void imprimir(){
		Iterator<Integer> itr = this.getIterador();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}

}
