package listasSimples;

	public class Node<T> {
		public T data; 			// dato del nodo
		public Node<T> next; 	// puntero al siguiente nodo de la lista, apunta al primero si es el ultimo
		public Node<T> prev;    // puntero al anterior nodo de la lista, apunta al último si es primero
		
		// -------------------------------------------------------------

		public Node(T dd) 		// constructor
		{
			data = dd;
			next = null;
			prev = null;
		}
	}


