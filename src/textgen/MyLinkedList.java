package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException("NullPointer Exception");
		}
		
		LLNode<E> newelement  = new LLNode<E>(element);
		newelement.next = tail;
		newelement.prev = newelement.next.prev;
		newelement.next.prev = newelement;
		newelement.prev.next = newelement;
		
		size += 1; 
		
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Out Of Bounds");
		}
		LLNode<E> current = new LLNode<E>(null);
		current = head.next;
		//System.out.println(current.data);
		for(int i = 0 ; i != index ; i++) {
			current = current.next;
		}
		
		return current.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		LLNode<E> n = new LLNode<E>(element);
		if(element == null) {
			throw new NullPointerException();
		}
		if(this.size == 0 && index == 0) {
			n.next = head.next;
			n.prev = n.next.prev;
			n.next.prev = n;
			head.next = n;
			size++;
		}
		else if(index >= 0 && index < this.size ){
			n.next = head.next;
			for(int i = 0; i < index; i++) {
				n.next = n.next.next;
			}
			n.prev = n.next.prev;
			n.next.prev = n;
			n.prev.next = n;
			size++;
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}
	


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Out Of Bounds");
		}
		LLNode<E> current = new LLNode<E>(null);
		current = head.next;
		//System.out.println(current.data);
		for(int i = 0 ; i != index ; i++) {
			current = current.next;
		}
		
		current.prev.next = current.next;
		current.next.prev = current.prev;
		
		size -= 1;
		
		
		return current.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Out Of Bounds");
		}
		
		if(element == null) {
			throw new NullPointerException("NullPointer Exception");
		}
		
		LLNode<E> current = new LLNode<E>(null);
		current = head.next;
		//System.out.println(current.data);
		for(int i = 0 ; i != index ; i++) {
			current = current.next;
		}
		
		LLNode<E> n = new LLNode<E>(element);
		
		n.next = current.next;
		n.next = current.prev;
		current.prev.next = n;
		current.next.prev = n;
		
		
		
		return current.data;
		
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e , LLNode<E> prevNode , LLNode<E> nextNode) {
		this.data = e;
		this.prev = prevNode;
		this.next = nextNode.next;
		
	}

}
