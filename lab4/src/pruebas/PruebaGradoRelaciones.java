package pruebas;

import java.io.File;

import lab4.Main;

public class PruebaGradoRelaciones {

	public static void main(String[] args){
		File archivo = new File("C:\\Documents and Settings\\HP_Propietario\\Escritorio\\aaaa.txt");
		Main.getMain().cargarFichero(archivo);
		System.out.println(Main.getMain().gradoRelaciones());
	}
	
}
