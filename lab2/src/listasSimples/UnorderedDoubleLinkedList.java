package listasSimples;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	public void addToFront(T elem) {
		Node <T>nuevo=new Node<T>(elem);
		nuevo.data=elem;
		nuevo.next=first;
		first=nuevo;

	}

	public void addToRear(T elem) {
		Node<T> nuevo,actual;
		nuevo=new Node<T>(elem);
		nuevo.data=elem;
		nuevo.next=null;
		if (first==null){
			first=nuevo;
		}
		else{
			actual=first;
			while(actual.next!=null){
				actual=actual.next;
			}
		actual.next=nuevo;
		}
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
	}

	public int tomarPos(T elem){
		Node<T> actual=first;
		int cont=1;
		boolean enc=false;
		while(!(enc||actual==null)){
			if(actual.data.equals(elem)){
				enc=true;
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
		return cont;
		}
	}
}