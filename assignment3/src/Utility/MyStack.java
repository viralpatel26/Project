package Utility;

/**This interface is for a stack ADT data structure
 * 
 * 
 * @author 709488
 *
 * @param <E> generic value type to be used with any generic value
 */

public interface MyStack<E> {
	
	/** Preconditions: must have an object to push on
	 * Must have an object to push onto the stack
 	 * post conditions: object should be on the top of the stack
 	 * this method pushes an object onto the top of the stack
	 * @param value the value you would like to push on top of the stack
	 * @exception NullPointerException is thrown if a null value is passed through
	 */
	public void push(E value) throws NullPointerException;
	
	
	
	
	/**Preconditions: must have an object to pop from
	 * Post Conditions: Object from the top of the stack should be returned from this method
	 * Object should be removed from the top of the stack and the next element is at the top now
	 * this method returns the top element of your stack and removes it from the stack
	 * @return returns the object at the top of the stack
	 * @exception NoSuchElementException is thrown if there are no elements in the stack
	 */
	
	public E pop() throws NoSuchElementException;
	
	
	
	
	/**Preconditions: must have a stack object to check if its empty
	 * postConidtions: Stack should remain unchanged
	 * this method tells you whether the stack is empty or not
	 * @return boolean true or false depending on whether the stack is empty or not
	 */
	
	public boolean isEmpty();
	
	
	
	
	/**Preconditions: Must have a stack object to peek at
	 * Must have at least one object in the stack to peek at or it returns null
	 * Postconditions: elements in the stack should remain unchanged and in the same order
	 * this method views the top element of a stack without changing/removing it
	 * @return reference to object at the top of the stack but does not remove it
	 */
	
	public E peek();
	
	
	
	
	/**Preconditions: Must have a stack object to clear from
	 * PostConditions: Stack should be completely cleared and have its size reduced to 0
	 * this method clears all of the elements within the stack 
	 * 
	 */
	
	public void clear();

}
