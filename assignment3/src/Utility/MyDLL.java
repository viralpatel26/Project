package Utility;

import java.lang.reflect.Array;
import java.util.*;

//import Utility.Iterator;
//import Utility.ListADT.iterator;

public class MyDLL<E> implements ListADT<E>{
	private MyDLLNode<E> ele;
	private MyDLLNode<E> first,last;
	private E[] array;
	private int size;
	public MyDLL() {
		size= 0;
	}
	@Override
	public int size() {
		return size;
	}
	@Override
	public void clear() {
		ele = null;
		first= null;
		last= null;
		size= 0;
		array = null;
	}
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if(toAdd == null) {
			throw new NullPointerException();
		}
		if(index > size) {
			throw new IndexOutOfBoundsException();
		}
		ele = new MyDLLNode<E>(toAdd);
		boolean test = false;
		if(first == null) {
		 first = ele;
		 last= ele;
		 size++;
		}
		else if(index == 0 ) {
			ele.succ = first;
			first.pre= null;
			first = ele;
			size++;
		}
		else if(index == size)
		{
			ele.pre = last;
			last.succ = ele;
			last = ele;
			size++;
		}
		else {
			MyDLLNode<E> e = first;
			
			for(int i = 1; i<index; i++) {
				e=e.succ;
			}
			ele.succ = e.succ;
			e.succ = ele;
			ele.pre = e;
			ele.succ.pre = ele;
			size++;
			test = true;
		}
		return test;
	}
	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if(toAdd == null) {
			throw new NullPointerException();
		}
		boolean test = false;
		if(toAdd != null){
			last = first;
			ele = new MyDLLNode<E>(toAdd);
			ele.succ =null;
			if(first == null) {
				ele.pre =null;
				first = ele;
				size++;	
			}
			while(last.succ!=null) {
				last= last.succ;
			}
			last.succ = ele;
			ele.pre = last;
			size++;
			test= true;
		}
		return test;
	}
	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		boolean test = false;
		ele = (MyDLLNode<E>) toAdd;
		if(toAdd == null) {
			test= false;
		}
		else {
			last=first;
			while(last.succ!=null) {
				last=last.succ;
			}
			last.succ=ele;
			last.succ.pre=last;
			ele.pre =last;
			size++;
			
		}
		return test;
	}
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		ele = first;
		for(int i = 0; i<index; i++) {
			ele=ele.succ;
		}
		return ele.getElement();
	}
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		ele = first;
		if(first == null || ele == null) {
			return null;
		}
		
		for(int i = 0; i<index; i++) {
			ele=ele.succ;
		}
		if(first == ele) {
			first = ele.succ;
			first.pre= null;
			size--;
		}
		else if(ele.succ == null) {
			last = ele.pre;
			ele.pre.succ=null;
			size--;
		}
		else {
		ele.pre.succ = ele.succ;
		ele.succ.pre = ele.pre;
		size--;
		}
		return ele.getElement();
	}
	@Override
	public E remove(E toRemove) throws NullPointerException {
		if(toRemove == null) {
			throw new NullPointerException();
		}
		boolean test = false;
		ele = first;
		while(ele.succ!=null) {
			ele = ele.succ;
			if(first.element==toRemove) {
				first = first.succ;
				first.pre = null;
				size--;
				test = true;
				break;
			}
			else if(last.element == toRemove) {
				last= last.pre;
				last.succ =null;
				size--;
				test = true;
				break;
			}
			else if(ele.element == toRemove && ele.pre !=null && ele.succ!=null) {
				ele.pre.succ = ele.succ;
				ele.succ.pre = ele.pre;
				size--;
				test = true;
				break;
			}	
		}
		return test?toRemove:null;
	}
	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {

		if(toChange == null) {
			System.out.println("it cannot be null");
		}
		ele = new MyDLLNode<E>(toChange);
		if (index == 0) {
			MyDLLNode<E> e = first;
			ele.succ = first.succ;
			first.succ.pre= ele;
			first = ele;
			return e.getElement();
		}
		else if(index == size) {
			ele.pre =last.pre;
			last.pre.succ = ele;
			last= ele;
		}
		else{
			MyDLLNode<E> e = first;
		for(int i = 0; i<index; i++) {
			e=e.succ;
			ele.succ= e;
			e.pre=ele;
			ele.pre =e.pre.pre;
			ele.pre = e.pre;
			ele = e;
		}
		}
		return ele.getElement();
	}
	@Override
	public boolean isEmpty() {
		
		boolean empty = false;
		if(first==null && last == null) {
			empty = true;
		}
		return empty;
	}
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		boolean returnValue = false;
		if (toFind == null) {
			returnValue = true;
			throw new NullPointerException();
		}
		else if(first.element == toFind || last.element == toFind) {
			returnValue = true;
		}
		else {
		ele = first;
		while(ele.succ!=null) {
			ele = ele.succ;
			if(ele.element == toFind) {
				
				returnValue = true;
				break;
			}
		}
		}
		return returnValue;
	}
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if(toHold == null) {
			throw new NullPointerException();
		}
		Arrays.sort(toHold);;
		for(int i=0; i<=size;i++) {
		array[i]=toHold[i];
		}
		return array;
	}
	@Override
	public Object[] toArray() {
		return null;
	}
	@Override
	public Iterator<E> iterator() {
		return new MyDLLIterator();
	}
	public class MyDLLIterator implements Iterator<E>
	{
		//Attribute 
		private int pos=0;

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
