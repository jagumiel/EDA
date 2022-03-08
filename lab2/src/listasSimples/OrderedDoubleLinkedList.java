package listasSimples;

public class OrderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {
	
	

	public void add(T elem) {
		int pos=buscarPosAnt(elem);
		if (pos==-1){
			addToFront(elem);
		}
		else{
			Node<T> nuevo,actual;
			nuevo=new Node<T>(elem);
			actual=first;
			int cont=1;
			while(cont!=pos){
				actual=actual.next;
				cont++;
			}
			nuevo.next=actual.next;
			actual.next=nuevo;
		}
	}
	
	
	private int buscarPosAnt(T elem){
		Node<T> actual=first;
		Node<T> elemento=new Node <T> (elem);
		int cont=1;
		boolean salir=false;
		String element=elemento.data.toString();
		while(!(salir||actual==null)){
			String act=actual.data.toString();
			int num=act.compareTo(element);
			if(num==0 ||num<0){
				salir=true;
		}
			else{
				actual=actual.next;
				cont++;
			}
		}
		if (actual==null){
			return -1;
		}
		else{
		return cont-1;
		}
	}
	
	private void addToFront(T elem) {
		Node <T> nuevo= new Node<T>(elem);
		if (first==null){
			//Lista vacia
			first=nuevo;
			first.prev = nuevo;
			first.next = nuevo;
		}else{
			Node<T> anterior, siguiente;
			anterior = first.prev;
			siguiente = first;
			first = nuevo;
			nuevo.next = siguiente;
			siguiente.prev = nuevo;		
			nuevo.prev = anterior;
			nuevo.next = siguiente;
		}
	}
	
}
