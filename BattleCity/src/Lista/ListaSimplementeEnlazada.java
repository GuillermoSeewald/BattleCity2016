package Lista;

import java.util.Iterator;

public class ListaSimplementeEnlazada<E> implements PositionList<E>{
	protected int longitud;
	protected Nodo<E> head,tail;
	
	public ListaSimplementeEnlazada(){
		longitud=0;
		head=tail=null;
	}
	
	public boolean isEmpty(){
		return head==null;
	}
	public int size(){
		return longitud;
	}
	public Position<E> first() throws EmptyListException{
		if(isEmpty()) throw new EmptyListException("Lista vacia");
		return head;
	}
	public Position<E> last() throws EmptyListException{
		if(isEmpty()) throw new EmptyListException("Lista vacia");
		return tail;
	}
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		try{
			if(p==first()) throw new BoundaryViolationException("Error, se pide la posición previa a la primera");
			Nodo<E> nodo= checkPosition(p);
			Nodo<E> aux= head;
			while((aux.getSiguiente()!=nodo)&&(aux.getSiguiente()!=null)){
				aux=aux.getSiguiente();
			}
			if(aux.getSiguiente()==null){
				throw new InvalidPositionException("La posicion no pertenece a la lista");
			}
			return aux;
		}
		catch(EmptyListException e){
			throw new InvalidPositionException("e: "+e.getMessage());
		}
	}
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		try{
			if(p==last()) throw new BoundaryViolationException("Error, se pide la posición siguiente a la última");
			Nodo<E> nodo= checkPosition(p);
			return nodo.getSiguiente();
		}
		catch(EmptyListException e){
			throw new InvalidPositionException("e: "+e.getMessage());
		}
	}
	public void addFirst(E elem){
		if(isEmpty()){
			head=new Nodo<E>(elem);
			tail=head;
		}
		else{
			Nodo<E> aux= new Nodo<E>();
			aux.setElement(elem);
			aux.setSiguiente(head);
			head=aux;
		}
		longitud++;
	}
	public void addLast(E elem){
		if(isEmpty()){
			addFirst(elem);
		}
		else{
			Nodo<E> aux= new Nodo<E>();
			aux.setElement(elem);
			tail.setSiguiente(aux);
			tail=aux;
			longitud++;
		}
	}
	public void addBefore(Position<E> p, E elem) throws InvalidPositionException{
		Nodo<E> nodo= checkPosition(p);
		try{
			if(p==first()){
				addFirst(elem);
			}
			else{
				Nodo<E> anterior= (Nodo<E>) prev(p);
				Nodo<E> nuevo= new Nodo<E>(elem,nodo);
				anterior.setSiguiente(nuevo);
				longitud++;
			}
		}catch(EmptyListException | BoundaryViolationException e){
			throw new InvalidPositionException("e: "+e.getMessage());
		}
	}
	public void addAfter(Position<E> p,E elem) throws InvalidPositionException{
		Nodo<E> nodo= checkPosition(p);
		Nodo<E> nuevo= new Nodo<E>(elem,nodo.getSiguiente());
		nodo.setSiguiente(nuevo);
		longitud++;
	}
	public E remove(Position<E> p) throws InvalidPositionException{
		if(isEmpty()) throw new InvalidPositionException("Lista vacia, no hay nada que remover");
		Nodo<E> nodo= checkPosition(p);
		E retorno= nodo.element();
		if(nodo==head){
			head=head.getSiguiente();
		}
		else{
			try{
				Nodo<E> n= (Nodo<E>) prev(p);
				n.setSiguiente(nodo.getSiguiente());
			}catch(BoundaryViolationException e){
				throw new InvalidPositionException("e: "+e.getMessage());
			}
		}
		longitud--;
		return retorno;
	}
	public E set(Position<E> p, E elem) throws InvalidPositionException{
		Nodo<E> nodo= checkPosition(p);
		E aux= nodo.element();
		nodo.setElement(elem);
		return aux;
	}
	public Iterator<E> iterator(){
		return new ElementIterator<E>(this);
	}
	
	private Nodo<E> checkPosition(Position<E> p) throws InvalidPositionException{
		try{
			if(p==null) throw new InvalidPositionException("Posicion nula");
			return (Nodo<E>) p;
		}
		catch(ClassCastException e){
			throw new InvalidPositionException("e: "+e.getMessage());
		}
	}
}