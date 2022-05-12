package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Utility.MyDLLNode;
import Utility.Iterator;
import Utility.MyDLL;

public class MyDLLTestes<E> {
	MyDLL<E> e = new MyDLL<E>();
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void test() {
		
	}
	@Test
	public void testSize() {
		assertEquals(0, e.size());
		assertTrue(e.isEmpty());
	}
	@Test
	public void testadd() {
		e.add(0,(E) "0");
		e.add(1,(E) "1");
		e.add(2,(E) "2");
		e.add(3,(E) "3");
		assertEquals(true,e.add((E) "4"));
	}
	@Test
	public void testAddToIndex() {
		e.add(0,(E) "0");
		e.add(1,(E) "1");
		e.add(2,(E) "2");
		e.add(3,(E) "3");
		assertEquals(true,e.add(2,(E) "4"));
	}
	
	@Test
	public void testGet() {
		e.add(0,(E) "0");
		e.add(1,(E) "1");
		e.add(2,(E) "2");
		e.add(3,(E) "3");
		assertEquals((E)"0",e.get(0));
	}
	@Test
	public void testRemoveByIndex() {
		e.add(0,(E) "0");
		e.add(1,(E) "1");
		e.add(2,(E) "2");
		e.add(3,(E) "3");
		assertEquals((E)"0",e.remove(0));
	}
	@Test
	public void testRemoveByElement() {
		e.add(0,(E) "0");
		e.add(1,(E) "1");
		e.add(2,(E) "2");
		e.add(3,(E) "3");
		assertEquals("2",e.remove((E)"2"));
	}
	@Test
	public void testSet() {
		e.add(0,(E) "0");
		e.add(1,(E) "1");
		e.add(2,(E) "2");
		e.add(3,(E) "3");
		assertEquals((E)"1",e.set(1,(E)"2"));
	}
	@Test
	public void testEmpty() {
		assertEquals(true,e.isEmpty());
	}
	
	@Test
	public void testToArray() {
		e.add(0,(E) "0");
		e.add(1,(E) "1");
		e.add(2,(E) "2");
		e.add(3,(E) "3");
		assertEquals(E[],e.toArray((E[]) e.toArray()));
	}
	
	@Test
	public void testContains() {
		e.add(0,(E) "0");
		e.add(1,(E) "1");
		e.add(2,(E) "2");
		e.add(3,(E) "3");
		assertEquals(true,e.contains((E) "3"));
	}
	@Test
	public void testIterator() {
		e.add(0,(E) "0");
		e.add(1,(E) "1");
		e.add(2,(E) "2");
		e.add(3,(E) "3");
		Iterator iterator = e.iterator();
		assertEquals("0",iterator.next());
	}
}
