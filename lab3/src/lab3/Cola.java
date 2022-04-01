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
	
	public void anadir(Actor pActor){
		cola[numeroelementos] = pActor;
		numeroelementos++;
	}
	
	public Actor sacarUltimoElemento(){
		Actor retorno = cola[numeroelementos-1];
		cola[numeroelementos-1]=null;
		numeroelementos--;
		return retorno;
	}
	
}
