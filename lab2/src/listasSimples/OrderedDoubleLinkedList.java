package listasSimples;

public class OrderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {
	
	

	public void add(T elem) {
            Node<T>elemact=new Node<T>(elem);
            String elem_act=elemact.data.toString();
            if(esInteger(elem_act)){
                int pos=buscarPosAntInt(elem);
                if (pos==0){
			addToFront(elem);
		}
		else{
			Node<T> nuevo,anterior;
			nuevo=new Node<T>(elem);
			anterior=first;
			int cont=1;
			while(cont!=pos){
				anterior=anterior.next;
				cont++;
			}
			nuevo.next = anterior.next;
			nuevo.prev = anterior;
			anterior.next = nuevo;
			nuevo.next.prev = nuevo;
                }
                
            }
            else{
		int pos=buscarPosAnt(elem);
		if (pos==0){
			addToFront(elem);
		}
		else{
			Node<T> nuevo,anterior;
			nuevo=new Node<T>(elem);
			anterior=first;
			int cont=1;
			while(cont!=pos){
				anterior=anterior.next;
				cont++;
			}
			nuevo.next = anterior.next;
			nuevo.prev = anterior;
			anterior.next = nuevo;
			nuevo.next.prev = nuevo;
		}
		count++;
            }
	}
        
        private int buscarPosAnt(T elem){
            int cont=0;
            boolean salir=false;
            Node<T> anterior=first;
            Node<T> actual=new Node <T> (elem);
            if(first!=null)
	            while(!(salir||(anterior==first&&cont>0))){ 
	            	Comparable c_act = (Comparable)actual.data.toString();
	            	Comparable c_ant = (Comparable)anterior.data.toString();
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
			siguiente.prev = nuevo;
			anterior.next = nuevo;
			nuevo.prev = anterior;
			nuevo.next = siguiente;
		}
	}
        
        private boolean esInteger( String input )  {  
            try  
            {  
               Integer.parseInt( input );  
               return true;  
            }  
            catch( Exception ex)  
            {  
               return false;  
            }  
         }  
        
        
        private int buscarPosAntInt(T elem){
            int cont=0;
            boolean salir=false;
            Node<T> anterior=first;
            Node<T> actual=new Node <T> (elem);
            if(first!=null)
	            while(!(salir||(anterior==first&&cont>0))){ 
                        String c_act_str=actual.data.toString();
                        int c_act= Integer.parseInt(c_act_str);
                        String c_ant_str=actual.data.toString();
                        int c_ant= Integer.parseInt(c_ant_str);	                
                        if(c_act<(c_ant)){
	                    salir=true;
	                }
	                else{
	                    anterior=anterior.next;
	                    cont++;
	                }
	            }
            return cont;
        }
	
}
