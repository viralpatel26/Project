package Utility;

public class MyStackADT<E> {
MyArrayList<E> stackList;

MyStackADT(){
	stackList = new MyArrayList<E>();
}


// must have an object to push on
// must be an object to push (pre conditions)
// (post conditions) object should be on the top of the stack

void push (E value) {
	stackList.add(value);
}

E pop() {
	if (stackList.isEmpty() != true) {
		E popValue = stackList.get(stackList.size()- 1);
		stackList.remove(stackList.size()-1);
		return popValue;
		
	}
	else {
		Object E;
		return (E) (E = null);
	}
	
	
}
boolean isEmpty() {
	if (stackList.isEmpty()) {
		return true;
	}
	else {
		return false;
	}
}
E peek() {
	return stackList.get(stackList.size()- 1);
}
}
