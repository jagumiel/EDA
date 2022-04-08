package lab3;

public class Cola<T> {

	private int max;
	private T[] cola;
	private int numeroelementos;
	private int fin;
	private int frente;
	
	
	@SuppressWarnings("unchecked")
	public Cola(int pMax){
		max=pMax;
		cola = (T[]) new Object[max];
		numeroelementos=0;
		frente=0;
		fin=-1;
	}
	
	public int getTamano(){
		return numeroelementos;
	}
	
	public void anadir(T anade){
		//Si llega al final de la cola inserta en la posicion 0.
		if(fin==max-1){
			fin = -1;
		}
		cola[++fin] = anade;
		numeroelementos++;
	}
	
	public T sacarPrimerElemento(){
		T temp = cola[frente++];
		if(frente == max){
			frente=0;
		}
		numeroelementos--;
		return temp;
	}
	
}
