package lab4;

public class Cola<T> {
	
	private T[] cola;
	private int max;
	private int numeroelementos;
	private int primero;
	private int ultimo;
	
	public Cola(int pMax){
		cola = (T[]) new Object[pMax];
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
			cola[ultimo]=pAnade;
		}
	}
	
	public T sacarPrimerElemento(){
		T elem = null;
		if(numeroelementos!=0){
			elem=cola[primero];
			primero++;
			if(primero==max){
				primero=0;
			}
			numeroelementos--;
		}
		return elem;
	}
	
	public void imprimirCola(){
		int cont = 0;
		int aux = primero;
		while(cont<numeroelementos){
			System.out.println(cola[aux]);
			aux++;
			cont++;
			if(aux==max){
				aux=0;
			}
		}
	}

}
