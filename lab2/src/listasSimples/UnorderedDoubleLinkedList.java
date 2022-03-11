package listasSimples;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	public void addToFront(T elem) {
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
			anterior.next=nuevo;
		}
		count++;
	}

	public void addToRear(T elem) {
		Node<T> nuevo = new Node<T>(elem);
		if (first==null){
			//Lista vacia
			first=nuevo;
			first.prev = nuevo;
			first.next = nuevo;
		}else{
			Node<T> anterior;
			anterior = first.prev;
			nuevo.prev = anterior;
			anterior.next = nuevo;
			nuevo.next = first;
			first.prev = nuevo;
		}
		count++;
	}

	public void addAfter(T elem, T target) {
		int pos=tomarPos(target);
		if (pos==-1){
			System.out.println("No se ha encontrado el elemento.");
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
		count++;
	}

	public int tomarPos(T elem){
		Node<T> actual=first;
		int cont=0;
		boolean salir=false, enc=false;
		while(!(enc||salir||actual==null)){
			if(actual.data.equals(elem)){
				enc=true;
		}
			else{
				actual=actual.next;
				cont++;
                                if(actual.equals(first)){
                                    actual=null;
                                    salir=true;
                                }
			}
		}
		if (actual==null){
			return -1;
		}
		else{
		return cont;
		}
	}
}