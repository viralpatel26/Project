package Utility;

public interface MyQueue<E> {
	/**pre conditions- must have a valid queue object to add to
	 * must have a valid object to add to the queue
	 * 
	 * post conditions - object will be first in the queue and new items will be added behind it
	 * 
	 * this method adds a new object to the end of a queue object and adheres to first in first out principles
	 * 
	 * @exception NullPointerException thrown if the element to be added is null
	 * 
	 * @param element the element you would like to add to the queue first in first out
	 */
	public void enqueue (E element) throws NullPointerException;
	
	/**pre conditions - must have a valid queue object to take from
	 * must have atleast one object inside of the Queue to take
	 * 
	 * post conditions - must return the first element in the Queue (first in first out)
	 * 
	 * this method returns and removes the element that was put into the Queue first.
	 * 
	 * @return returns the object at the very front of the line(was added first
	 * 
	 * @exception NoSuchElementException thrown if the Queue is completely empty
	 */
	public E dequeue() throws NoSuchElementException;
	
	/**pre conditions - must have a valid queue object to peek at
	 * must be atleast one element in the Queue object to peek at
	 * 
	 * post conditions - must return a reference to the first element in the queue without removing it
	 * 
	 * This method returns a reference to the first element of the queue without removing it
	 * 
	 * @return returns a reference to the first element in the Queue without removing it
	 * @exception NoSuchElementException thrown if there are no elements within the queue
	 */
	public E first() throws NoSuchElementException;
	
	/**pre conditions- must have a valid queue object to reference
	 * 
	 * post conditions- must return a boolean that is true if the queue is empty or false if the queue is not empty
	 * 
	 * this method tells you whether a queue is empty or not
	 * 
	 * @return returns a boolean that is true or false depending on if the queue object is empty or has atleast one element in it
	 * @exception NoSuchElementException is thrown if the queue object does not exist
	 */
	
	public boolean isEmpty() throws NoSuchElementException;
	
	/**pre conditions - must have a valid queue object to reference
	 * 
	 * post conditions- must return the amount of objects or elements within the queue object
	 * 
	 * This method tells you how many objects are within the queue object
	 * 
	 * @return returns how many elements are within the queue
	 */
	
	public int size();
	
	/**pre conditions - must have a valid queue object to clear from
	 * 
	 * post conditions - queue must have no remaining objects store in it and size is set to 0
	 * 
	 * this method clears all of the objects from a queue
	 * 
	 * @exception NoSuchElemenException is thrown if the queue object does not exist 
	 */
	
	public void clear() throws NoSuchElementException;
	
	/**preconditions - must have a valid queue object to reference
	 * preconditions- must have a valid object to pass into the method
	 * post conditions- must tell the user if the queue contains the object they are passing in
	 * 
	 * this method searches the queue for the object passed within it
	 * 
	 * @param contains - the object that you are searching for within the queue
	 * 
	 * @return returns a true or false boolean.  returns true if the item exists in the queue and false if it does not
	 */
	
	public boolean contains(E contains);

}
