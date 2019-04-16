package ueb04;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

class StackImpl<T> implements Stack<T> {
	/**
	 * Gibt einen Reverse-Iterator zurück, d.h. ein Iterator, welcher die Elemente
	 * in umgekehrter Reihenfolge zurück gibt. Also als erstes das letzte (also "unterste"),
	 * Element, dann das zweit-unterste etc.
	 */
	@Override
	public Iterator<T> iterator() {
		// Iterator implementieren...
		return new Iterator<T>() {
			StackImpl<Element> liste = new StackImpl<>();
			{	if(top !=null){
				Element it = top;
				while (it!=null){
					liste.push(it);
					it=it.next;
				}}
			}

			@Override
			public boolean hasNext() {
				boolean bool =liste.size()>0;
				return bool;
			}

			@Override
			public T next() {
				return liste.pop().value;
			}
		};
	}

	private class Element {
		T value;
		Element next;
		Element(T value, Element next) {
			this.value = value;
			this.next = next;
		}
	}

	private Element top;
	private int s = 0;

	@Override
	public void push(T c) {
		top = new Element(c, top);
		s++;
	}

	@Override
	public T pop() {
		if (top == null)
			throw new NoSuchElementException();
		T v = top.value;
		top = top.next;
		s--;
		return v;
	}

	@Override
	public int size() {
		return s;
	}
}
