package listasSimples;

import java.util.Iterator;

public class DoubleLinkedList<T> implements ListADT<T> {

	// Atributos
	protected Node<T> first; // apuntador al primero
	protected String descr;  // descripción
	protected int count;

	// Constructor
	public DoubleLinkedList() {
		first = null;
		descr = "Esta es una lista circular";
		count = 0;
	}
	
	//Getters y Setters
	public void setDescr(String nom) {
	  descr = nom;
	}

	public String getDescr() {
	  return descr;
	}

	public T removeFirst() {
	//Elimina el primer elemento de la lista
    
	T resultado = null;
		
	if (!isEmpty()){
		//TODO
	     Node<T> result = first; 
	     if (first == first.next)
		     //Solo hay un elemento, luego después de borrar la lista está vacia
		     first = null;
		 else { 
			 //Hay mas de un elemento
			 Node<T> anterior = result.prev;
			 Node<T> siguiente = result.next;
		
			 first = siguiente;
		     first.prev = anterior;
			 result.prev.next = first;
				}
	     count--;
	     resultado = result.data;
	}
	
	return resultado;

	public T removeLast() {
	//Elimina el último elemento de la lista
	
		Node<T> rdo = null;
		
		if(!isEmpty()){
			return null;
		}else{	
			rdo = first.prev;
			if(first==rdo){
				//Solo hay un elemento en la lista que es el que quiero borrar
				first = null;
			}else{
				rdo.prev.next = first;
				first.prev = rdo.prev;
			}
		count--;
		return rdo.data;
		}
		
	//COSTE O(1)
    }


	public T remove(T elem) {
	//Elimina un elemento concreto de la lista

	if(!contains(elem)){
		return null;
	}else{
		Node<T> rdo = findDevuelveNodo(elem);
		Node<T> anterior = rdo.prev;
		Node<T> siguiente = rdo.next;
		
		anterior.next = siguiente;
		siguiente.prev = anterior;
		
		count--;
		
		return rdo.data;	
	}
		
	//COSTE	O(1)
	};

	public T first() {
	//Da acceso al primer elemento de la lista
	      if (isEmpty())
	          return null;
	      else return first.data;
	}

	public T last() {
	//Da acceso al último elemento de la lista
	      if (isEmpty())
	          return null;
	      else return first.prev.data;
	}

	public boolean contains(T elem) {
	//Determina si la lista contiene un elemento concreto
      if (isEmpty())
          return false;

      Node<T> current = first.next; // Empieza con el segundo elemento

      while ((current != first) && !elem.equals(current.data)) 
            current = current.next;
      return elem.equals(current.data);
   }

	private Node<T> findDevuelveNodo (T elem) {
	//Determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no esté
		
		Node<T> aux = null;
		
		if(contains(elem)){
				aux = first;
			boolean encontrado = false;
			while((aux!=last())&&(!encontrado)){
				if(aux.data==elem){
					encontrado=true;
				}else{
					aux=aux.next;
				}
			}
		}
		
		//Si aux es el último justo habrá salido del while y lo devolverá bien
		return aux;
		
		//COSTE O(n)
	}
	public T find(T elem) {
	//Determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no esté

       Node<T> nodo = findDevuelveNodo(elem);
       if (nodo == null) return null;
       else return nodo.data;
		
	//COSTE O(n)
	}

	public boolean isEmpty() 
	//Determina si la lista está vacía
	{ return first == null;};
	
	public int size() 
	//Determina el número de elementos de la lista
	{ return count;};
	
	/** Return an iterator to the stack that iterates through the items . */ 
	public Iterator<T> iterator() { return new ListIterator(); } 

	   // an iterator, doesn't implement remove() since it's optional 
	   private class ListIterator implements Iterator<T> {
		   
		   private Node<T> actual;
		   
			@Override
			public boolean hasNext() {
				if(actual.next==null){
					return false;
				}else{
					return true;
				}
			}
	
			@Override
			public T next() {
				return actual.next.data;
			}

			@Override
			public void remove() {
				actual.prev.next = actual.next;
				actual.next = actual.prev;
			} 
	   }
		
		
		public void visualizarNodos() {
			System.out.println(this.toString());
		}

		
		@Override
		public String toString() {
			String result = new String();
			Iterator<T> it = iterator();
			while (it.hasNext()) {
				T elem = it.next();
				result = result + "[" + elem.toString() + "] \n";
			}	
			return "SimpleLinkedList " + result + "]";
		}
}
