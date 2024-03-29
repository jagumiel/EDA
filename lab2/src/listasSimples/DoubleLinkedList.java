package listasSimples;

import java.util.Iterator;

public class DoubleLinkedList<T> implements ListADT<T> {

	// Atributos
	protected Node<T> first; // apuntador al primero
	protected String descr;  // descripci�n
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

	public Node<T> getFirst(){
		return first;
	}
	
	public void setFirst(Node<T> pFirst){
		this.first = pFirst; 
	}
	
	
	public T removeFirst() {
	//Elimina el primer elemento de la lista
    
		T resultado = null;
			
		if (!isEmpty()){
		     Node<T> result = first; 
		     if (first == first.next)
			     //Solo hay un elemento, luego despu�s de borrar la lista est� vacia
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
	}
	
	
	public T removeLast() {
	//Elimina el �ltimo elemento de la lista
	
		Node<T> rdo = null;
		
		if(!isEmpty()){	
			rdo = first.prev;
			if(first==rdo){
				//Solo hay un elemento en la lista que es el que quiero borrar
				first = null;
			}else{
				//Hay mas de un elemento
				Node<T> anterior = rdo.prev;
				Node<T> siguiente = rdo.next;
				
				anterior.next = siguiente;
				siguiente.prev = anterior;
				
				first = siguiente;
			}
		count--;
		}
		
		if (rdo==null)
			return null;
		else
			return rdo.data;
		
	//COSTE O(1)
    }


	public T remove(T elem) {
	//Elimina un elemento concreto de la lista

	Node<T> rdo	= null;
		
	if(contains(elem)){
		rdo = findDevuelveNodo(elem);
		
		if(rdo==first){
			this.removeFirst();
		}else{	
			Node<T> anterior = rdo.prev;
			Node<T> siguiente = rdo.next;
			
			anterior.next = siguiente;
			siguiente.prev = anterior;
		}	
			
		count--;	
	}
	
	if (rdo==null)
		return null;
	else
		return rdo.data;
		
	//COSTE	O(1)
	};

	public T first() {
	//Da acceso al primer elemento de la lista
	      if (isEmpty())
	          return null;
	      else return first.data;
	}

	public T last() {
	//Da acceso al �ltimo elemento de la lista
	      if (isEmpty())
	          return null;
	      else return first.prev.data;
	}

	public boolean contains(T elem) {
	//Determina si la lista contiene un elemento concreto
      if (isEmpty())
          return false;

      Node<T> actual = first;
      boolean hapasadofirst = false;
      boolean esta = false;
      
      while((!hapasadofirst)||(actual!=first)){
    	  if(actual.prev == first){
    		  hapasadofirst = true;
    	  }
    	  
    	  if(actual.data.equals(elem)){
    		  esta=true;
    		  break;
    	  }else{
    		  actual = actual.next;
    	  }
      }
      
      return esta;
   }

	private Node<T> findDevuelveNodo (T elem) {
	//Determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no est�
		
		Node<T> aux = null;
		
		if(contains(elem)){
				aux = first;
			boolean encontrado = false;
			while((!aux.data.equals(last()))&&(!encontrado)){
				if(aux.data.equals(elem)){
					encontrado=true;
				}else{
					aux=aux.next;
				}
			}
		}
		
		//Si aux es el �ltimo justo habr� salido del while y lo devolver� bien
		return aux;
		
		//COSTE O(n)
	}
	public T find(T elem) {
	//Determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no est�

       Node<T> nodo = findDevuelveNodo(elem);
       if (nodo == null) return null;
       else return nodo.data;
		
	//COSTE O(n)
	}

	public boolean isEmpty() 
	//Determina si la lista est� vac�a
	{ return first == null;};
	
	public int size() 
	//Determina el n�mero de elementos de la lista
	{ return count;};
	
	/** Return an iterator to the stack that iterates through the items . */ 
	public Iterator<T> iterator() { return new ListIterator(this); } 

	   // an iterator, doesn't implement remove() since it's optional 
	   private class ListIterator implements Iterator<T> {
		   
		   private Node<T> actual;
		   private int indice;
		   
		   public ListIterator(DoubleLinkedList l){
			   if(l.first!=null){
				   actual = l.first.prev;
				   indice = 0;
			   }
		   }
		   
			public boolean hasNext() {
				if(indice==count){
					return false;
				}else{
					return true;
				}
			}
	
			public T next() {
				try{
					if(hasNext())
					{
						T rdo = actual.next.data;
						actual = actual.next;
						indice++;
						return rdo;
					}
					else
					{
		                throw new NoHayNextException();
					}
				}
					catch(NoHayNextException ex)
					{
						//System.out.println("No hay siguiente.");
						T rdo = actual.data;
						return rdo;
					}
			}

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
