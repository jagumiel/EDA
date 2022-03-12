package pruebaListasSimples;

import java.util.Iterator;

import listasSimples.UnorderedDoubleLinkedList;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;


public class PruebaDoubleLinkedList {
	
	public static void visualizarNodos(UnorderedDoubleLinkedList<Integer> l) {
		Iterator<Integer> it = l.iterator();
		System.out.println();
		while (it.hasNext()) {
			Integer num = it.next();
			System.out.println(num);
		}
	}
	
	
	public static void main(String[] args)  {
		
		UnorderedDoubleLinkedList<Integer> l =new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(1);
		l.addToRear(3);
		l.addToRear(6);
		l.addToRear(7);
		l.addToRear(9);
		l.addToRear(0);
		l.addToRear(20);
		l.addToFront(8);
		l.remove(new Integer(7));

		
		System.out.print(" Lista ...............");
		visualizarNodos(l);
		System.out.println(" Num elementos: " + l.size());
				
		
		System.out.println("Prueba Find ...............");
		System.out.println("9? " + l.find(9));
		System.out.println("0? " + l.find(0));
		System.out.println("7? " + l.find(7));
                
                int aux=l.tomarPos(1);
                System.out.println("Este valor tiene que dar 1 y da " + aux);
		aux=l.tomarPos(2);
                System.out.println("El valor no se encuentra y tiene que dar -1, y da " + aux);
                aux=l.tomarPos(3);
                System.out.println("Este valor tiene que dar 2 y da " + aux);
                
                l.addAfter(2, 1);
                System.out.print(" Lista ...............");
		visualizarNodos(l);
	}
        
        public void testTomarPos(){
        		UnorderedDoubleLinkedList<Integer> l =new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(1);
		l.addToRear(3);
		l.addToRear(6);
		l.addToRear(7);
                int aux=l.tomarPos(1);
                System.out.println("este es el valor de " + aux);
        }
}
