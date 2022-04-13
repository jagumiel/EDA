package lab3;

import java.util.concurrent.TimeUnit;

public class Cola<T> {
	
	private T[] micola;
	private int primero;
	private int ultimo;
	private int numeroelementos;
	private int capacidadmaxima;
	
	public Cola(int pCapacidadMaxima){
		this.capacidadmaxima = pCapacidadMaxima;
		this.primero = 0;
		this.ultimo = -1;
		this.numeroelementos = 0;
		this.micola = (T[])(new Object[capacidadmaxima]);
	}
	
	public boolean anadirElemento(T elem){
		//Devuelve true si lo he añadido
		boolean anadido = false;
		
		if(numeroelementos!=capacidadmaxima){
			if(ultimo+1==capacidadmaxima){
				ultimo=-1;
			}
			this.micola[++ultimo] = elem;
			numeroelementos++;
			anadido=true;
		}
		
		return anadido;		
	}
	
	public T sacarPrimerElemento(){
		T elem = null;
		
		if(numeroelementos!=0){
			elem = this.micola[primero];
			primero++;
			numeroelementos--;
			if(primero==capacidadmaxima){
				primero = 0;
			}
		}
		
		return elem;
	}
	
	public void imprimir(){
		if(ultimo!=-1){
			boolean salir = false;
			int contactual = primero;
			int fin = ultimo;
			while(!salir){
				if(contactual==fin){
					salir=true;
				}
				
				T actual = micola[contactual];
				System.out.print(actual+"-");
				if(contactual==capacidadmaxima-1){
					contactual=0;
				}else{
					contactual++;
				}
			}
		}
	}

	public int getTamano() {
		return this.numeroelementos;
	}

}
