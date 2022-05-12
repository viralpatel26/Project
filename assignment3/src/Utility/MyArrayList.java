package Utility;

import java.util.NoSuchElementException;

public class MyArrayList<E> implements ListADT<E> {
	//Atrributes
	
	private E[] array;
	private int size;
	
	public MyArrayList()
	{
		this(10);
	}
	
	public MyArrayList(int capacity) 
	{
		array = (E[]) new Object[capacity];
	}
	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		for (int i = 0; i < this.size; i++) {
			array[i] = null;
		}
		size = 0;
		
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (toAdd == null) {
			throw new NullPointerException();
		}
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (index==size) {
			add(toAdd);
		}
	 
		else if (index<this.size) {
				if(this.size == array.length) {
					E[] tempArray = (E[]) new Object[size * 2];
					for (int i = 0; i<this.size;i++) {
						tempArray[i]= array[i];
					}
					array = tempArray;
				}
				for(int i = this.size-1; i>=index;i--) {
					array[i+1]=array[i];
				}
				array[index]=toAdd;
				size++;
			}
		
		
		
		return true;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if (this.size == array.length) {
			E[] newArray = (E[]) new Object[size * 2];
			for (int k = 0; k < size; k++) {
				newArray[k] = array[k];
			}
			array = newArray;
		}
		array[size] = toAdd;
		size++;
		return true;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index>=this.size) throw new IndexOutOfBoundsException();
		return array[index];
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index>=this.size) throw new IndexOutOfBoundsException();
		E removeElement = array[index];
		for (int i = index+1; i<this.size;i++) {
			array[i-1]=array[i];
		}
		array[this.size]=null;
		this.size--;
		return removeElement;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
			if (toRemove == null) {
				throw new NullPointerException();
			}
			
		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if (index>=this.size) throw new IndexOutOfBoundsException();
		if (toChange == null) throw new NullPointerException();
		E setElement = array[index];
		array[index]= toChange;
		return setElement;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
			throw new NullPointerException();
		}
		boolean returnIndex = false;
		for (int i =0; i<this.size;i++) {
			if(array[i].equals(toFind)) {
				returnIndex = true;
				break;
			}
		}
		return returnIndex;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		
		if (toHold == null)
		{
			throw new NullPointerException();
		}
		if (toHold.length < size) {
			
		toHold = (E[]) new Object[size];
		}
		else if (toHold.length == size) {
		toHold = (E[]) new Object[size * 2];
		}
		for (int i = 0; i < size; i++) {
			toHold[i] = array[i];
		}
		return toHold;
	}
	

	@Override
	public Object[] toArray() {
		Object [] toHold = new Object[size];
		for (int i = 0; i < size; i++) {
			toHold[i] = array[i];
		}
		return toHold;
	}

	@Override
	public Iterator<E> iterator() {
		return new MyArrayListIterator();
	}
	private class MyArrayListIterator implements Iterator<E>
	{
		//Attribute 
		private int pos;

		@Override
		public boolean hasNext() {
			return pos < size;
		}

		@Override
		public E next() throws NoSuchElementException {
			if(pos >= size) 
			{
				throw new NoSuchElementException();
			}
			return array[pos++];
		}
		
	}

}
