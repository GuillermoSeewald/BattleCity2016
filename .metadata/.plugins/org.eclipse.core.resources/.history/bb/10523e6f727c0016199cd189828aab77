package Lista;

public class Nodo<E> implements Position<E>{
	private E rotulo;
	private Nodo<E> siguiente;
	
	public Nodo(){
		rotulo=null;siguiente=null;
	}
	public Nodo(E elem){
		rotulo=elem;siguiente=null;
	}
	public Nodo(E elem, Nodo<E> s){
		rotulo=elem;siguiente=s;
	}
	
	public void setElement(E elem){
		rotulo=elem;
	}
	public void setSiguiente(Nodo<E> s){
		siguiente=s;
	}
	public E element(){
		return rotulo;
	}
	public Nodo<E> getSiguiente(){
		return siguiente;
	}
}