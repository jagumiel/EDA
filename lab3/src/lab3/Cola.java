package lab3;

public class Cola {

	private int max;
	private Actor[] cola;
	private int numeroelementos;
	
	
	public Cola(int pMax){
		max=pMax;
		cola = new Actor[max];
		numeroelementos=0;
	}
	
	public int getTamano(){
		return numeroelementos;
	}
	
	public void anadir(Actor pActor){
		cola[numeroelementos] = pActor;
		numeroelementos++;
	}
	
	public Actor sacarUltimoElemento(){
		if(numeroelementos==0){
			System.out.println("La cola está vacía");
			return null;
		}else{
			Actor retorno = cola[numeroelementos-1];
			cola[numeroelementos-1]=null;
			numeroelementos--;
			return retorno;
		}
	}
	
}
