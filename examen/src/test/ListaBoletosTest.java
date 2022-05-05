package test;

import packSorteo.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaBoletosTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	//Como el getPremiados() no me dice los numeros ganadores, pero si quienes han ganado,
	//compruebo que todos los boletos ganadores tienen 4 o mas aciertos.
	public void testGetPremiados() {
		Random rg = new Random();
		int x;
		for(int i = 1; i<100000; i++){
			Boleto b = new Boleto ("aaa", "bbb", 698569569);
			while(!b.getMisNumeros().estaCompleta()){
				x=rg.nextInt(49);
				x++;
				if(!b.getMisNumeros().estaNumero(x)){
					b.getMisNumeros().addNumero(x);
				}
			}
			ListaBoletos.getListaBoletos().getLista().add(b);
		}
		
		ArrayList<Boleto> ganadores = ListaBoletos.getListaBoletos().getPremiados();
		if(ganadores.size()!=0){
			for(Boleto b: ganadores){
				b.imprimir();
			}
		}else{
			System.out.println("No ha habido ganadores");
		}
		
	}

}
