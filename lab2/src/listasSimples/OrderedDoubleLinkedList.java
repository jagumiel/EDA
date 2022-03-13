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
            Node<T> siguiente=first;
            Node<T> actual=new Node <T> (elem);
            if(first!=null)
	            while((!salir)||(!(siguiente==first)&&(cont>0))){ 
	                String sig_aux=siguiente.data.toString();
	                String act_aux = actual.data.toString();
	                if(act_aux.compareTo(sig_aux)==0){
	                    salir=true;
	                }
	                else{
	                    actual=siguiente;
	                    siguiente=siguiente.next;
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
