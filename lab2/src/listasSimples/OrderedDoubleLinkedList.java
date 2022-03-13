package listasSimples;

public class OrderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {
	
	

	public void add(T elem) {
		int pos=buscarPosAnt(elem);
		if (pos==0){
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
            int cont=0;
            boolean salir=false;
            Node<T> anterior=first;
            Node<T> actual=new Node <T> (elem);
            if(first!=null)
	            while(!(salir||(anterior==first&&cont>0))){ 
	            	Comparable c_act = (Comparable)actual.data;
	            	Comparable c_ant = (Comparable)anterior.data;
	                if(c_act.compareTo(c_ant)==-1){
	                    salir=true;
	                }
	                else{
	                    anterior=anterior.next;
	                    cont++;
	                }
	            }
            return cont;
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
