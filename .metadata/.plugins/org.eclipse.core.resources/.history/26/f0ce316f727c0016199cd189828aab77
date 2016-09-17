package Lista;

import java.util.Iterator;

public interface PositionList<E> extends Iterable<E>{
	public boolean isEmpty();
	public int size();
	public Position<E> first() throws EmptyListException;
	public Position<E> last() throws EmptyListException;
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException;
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException;
	public void addFirst(E elem);
	public void addLast(E elem);
	public void addBefore(Position<E> p, E elem) throws InvalidPositionException;
	public void addAfter(Position<E> p, E elem) throws InvalidPositionException;
	public E remove(Position<E> p) throws InvalidPositionException;
	public E set(Position<E> p, E elem) throws InvalidPositionException;
	public Iterator<E> iterator();
}