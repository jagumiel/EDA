package listasSimples;

	public class Node<T> {
		public T data; 			// dato del nodo
		public Node<T> next; 	// puntero al siguiente nodo de la lista, null si
								// último
		public Node<T> prev;
		// -------------------------------------------------------------

		public Node(T dd) 		// constructor
		{
			data = dd;
			next = null;
			prev=null;
		}
	}


