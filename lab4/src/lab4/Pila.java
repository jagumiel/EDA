package lab4;

public class Pila<T> {
	
	private T[] pila;
	private int max;
	private int numeroelementos;
	private int primero;
	private int ultimo;
	
	public Pila(int pMax){
		pila = (T[]) new Object[pMax];
		max = pMax;
		primero = 0;
		numeroelementos=0;
		ultimo = -1;
	}
	
	public int getTamano(){
		return this.numeroelementos;
	}
	
	public void anadir(T pAnade){
		if(numeroelementos<max){
			numeroelementos++;
			if(ultimo==max-1){
				System.out.println("true");
				ultimo=-1;
			}
			ultimo++;
			pila[ultimo]=pAnade;
		}
	}
	
	
	public T sacarPrimerElemento(){
		T elem = null;
		if(numeroelementos!=0){
			elem=pila[ultimo];
			ultimo--;
			if(ultimo==max){
				ultimo=0;
			}
			numeroelementos--;
		}
		return elem;
	}
}

