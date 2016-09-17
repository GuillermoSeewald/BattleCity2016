package Lista;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ElementIterator<E> implements Iterator<E>{
	protected PositionList<E> list;
	protected Position<E> cursor;
	
	public ElementIterator(PositionList<E> l){
		list=l;
		try{
			cursor=list.first();
		}
		catch(EmptyListException e){
			cursor=null;
		}
	}
	
	public boolean hasNext(){
		return cursor!=null;
	}
	public E next() throws NoSuchElementException{
		if(cursor==null)
			throw new NoSuchElementException("No tiene siguiente");
		E aux=cursor.element();
		try {
			if(cursor==list.last())
				cursor=null;
			else
				cursor=list.next(cursor);
		} catch (EmptyListException | BoundaryViolationException | InvalidPositionException e) {
		}
		return aux;
	}
}