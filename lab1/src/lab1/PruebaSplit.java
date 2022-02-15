package lab1;

public class PruebaSplit {
	
	public static void main(String args[]){
		String prueba = "			Mondo (1995)  [The Magician's Friend]  <5>";
		String[] lineas = prueba.split("\t");
		System.out.println("Actriz: "+lineas[0]);
		String[] lineas2 = lineas[2].split("\\(");
		System.out.println("Pelicula: "+lineas2[0]);
		if(prueba.substring(0,3).equals("\t"+"\t"+"\t")){
			System.out.println("Dos");
		}
		else
		{System.out.println();}
	}

}
