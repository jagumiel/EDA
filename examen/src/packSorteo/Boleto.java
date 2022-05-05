package packSorteo;

import java.util.Iterator;

public class Boleto {

	private int identificador = 1;
	private String nombre;
	private String direccion;
	private int telefono;
	private ListaNumeros misNumeros;
	
	public Boleto (String pNombre, String pDireccion, int pTelf){
		this.nombre=pNombre;
		this.direccion=pDireccion;
		this.telefono=pTelf;
		this.misNumeros = new ListaNumeros();
	}
	
	public int getId(){
		return this.identificador;
	}
	
	public ListaNumeros getMisNumeros(){
		return this.misNumeros;
	}
	
	public void rellenar(ListaNumeros l){
		Iterator<Integer> it = l.getIterador();
		while(it.hasNext()){
			this.getMisNumeros().addNumero(it.next());
		}
	}
	
	public int obtNumeroAciertos(ListaNumeros pListaNumeros){
		Iterator<Integer> it = pListaNumeros.getIterador();
		int x;		
		int aciertos = 0;
		
		while(it.hasNext()){
			x=it.next();
			if(this.getMisNumeros().estaNumero(x)){
				aciertos++;
			}
		}
		
		return aciertos;
	}
	
	//Para las pruebas
	public void imprimir(){
		System.out.println("ID: "+this.getId()+"     Numeros: ");
		int x;
		Iterator<Integer> it = this.getMisNumeros().getIterador();
		while(it.hasNext()){
			x = it.next();
			System.out.print(x+"  ");
		}
		System.out.println(); //Salto de linea
	}
}
