package Utility;

public class MyDLLNode<E> {
	protected E element;
	
	protected MyDLLNode<E> pre;
	protected MyDLLNode<E> succ;
	public MyDLLNode (E element,MyDLLNode<E> pre,MyDLLNode<E> succ) {
		this.element= element;
		this.pre=pre;
		this.succ=succ;
	}
	public MyDLLNode(E element) {
		this.element=element;
	}
	public E getElement() {
		return element;
	}
	public void setElement(E element) {
		this.element = element;
	}
	public MyDLLNode<E> getPre() {
		return pre;
	}
	public void setPre(MyDLLNode<E> pre) {
		this.pre = pre;
	}
	public MyDLLNode<E> getSucc() {
		return succ;
	}
	public void setSucc(MyDLLNode<E> succ) {
		this.succ = succ;
	}
	
}
