package listasSimples;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> implements ListADT<T> {

	// Atributos
	protected Node<T> first; // apuntador al primero
	protected String descr;  // descripción
	protected int count;

	// Constructor
	public DoubleLinkedList() {
		first = null;
		descr = "";
		count = 0;
	}
	
	public void setDescr(String nom) {
	  descr = nom;
	}

	public String getDescr() {
	  return descr;
	}

	public T removeFirst() {
	//Elimina el primer elemento de la lista
    if (isEmpty())
        return null;
     
     Node<T> result = first; 
     if (first == first.next)
        first = null;
	 else { first = first.next;
	        first.prev = result.prev;
			result.prev.next = first;
			}
     count--;
     return result.data;
	}

	public T removeLast() {
	//Elimina el último elemento de la lista
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE

    }


	public T remove(T elem) {
	//Elimina un elemento concreto de la lista

	
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE

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

	public T find(T elem) {
	//Determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no esté

			// COMPLETAR EL CODIGO Y CALCULAR EL COSTE

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

		// COMPLETAR EL CODIGO

	   } // private class
		
		
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
