  package listasSimples;

public interface UnorderedListADT<T> extends ListADT<T> {
	
	public void addToFront(T elem);


	public void addToRear(T elem);

	public void addAfter(T elem, T target);
	// Añade elem detrás de otro elemento concreto, target,  que ya se encuentra en la lista


}
