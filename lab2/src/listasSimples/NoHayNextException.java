package listasSimples;

public class NoHayNextException extends Exception {

	public NoHayNextException() {}
	
	public NoHayNextException(String message){
	    super(message);
	  }
}