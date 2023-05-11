import java.util.NoSuchElementException;

/**
 *	SinglyLinkedList - (description)
 *
 *	@author	
 *	@since	
 */
public class SinglyLinkedList<E extends Comparable<E>>
{
	/* Fields */
	private ListNode<E> head, tail;		// head and tail pointers to list
	
	/* No-args Constructors */
	public SinglyLinkedList() {}
	
	/** Copy constructor */
	public SinglyLinkedList(SinglyLinkedList<E> oldList) {}
	
	/**	Clears the list of elements */
	public void clear() {
		head = null;
		tail = null;
	}
	
	/**	Add the object to the end of the list
	 *	@param obj		the object to add
	 *	@return			true if successful; false otherwise
	 */
	public boolean add(E obj) {
		ListNode<E> node = new ListNode<E>(obj, null);
		if(tail == null) {
			tail = node;
			head = tail;
		}
		else {
			tail.setNext(node);
			tail = node;
		}
		
		if(tail == node)
			return true;
		return false;
	}
	
	/**	Add the object at the specified index
	 *	@param index		the index to add the object
	 *	@param obj			the object to add
	 *	@return				true if successful; false otherwise
	 *	@throws NoSuchElementException if index does not exist
	 */
	public boolean add(int index, E obj) {
		ListNode<E> node = new ListNode<E>(obj);
		
		if(index == 0) {
			node.setNext(head);
			head = node;
		}
		else {
			ListNode<E> add = head;
			for(int i = 0; i < index - 1; i++) {
				if(add == null)
					throw new NoSuchElementException;
				add = add.getNext();
			}
			node.setNext(add.getNext());
			add.setNext(node);
			if(node.getNext() == null)
				tail = node;
		}
		return true;
	}
	
	/**	@return the number of elements in this list */
	public int size() {
		int count = 0;
		ListNode<E> temp = head;
		while(temp != null) {
			count++;
			temp = temp.getNext();
			//~ if(temp == null)
				//~ return count;
		}
		return count;
	}
	
	/**	Return the ListNode at the specified index
	 *	@param index		the index of the ListNode
	 *	@return				the ListNode at the specified index
	 *	@throws NoSuchElementException if index does not exist
	 */
	public ListNode<E> get(int index) {
		ListNode<E> add = head;
		for(int i = 0; i < index - 1; i++) {
			if(add == null)
				throw new NoSuchElementException;
			add = add.getNext();
		}
		return add;
	}
	
	/**	Replace the object at the specified index
	 *	@param index		the index of the object
	 *	@param obj			the object that will replace the original
	 *	@return				the object that was replaced
	 *	@throws NoSuchElementException if index does not exist
	 */
	public E set(int index, E obj) {
		ListNode<E> node = get(index);
		E val = node.getValue();
		node.setValue(obj);
		return val;
	}
	
	/**	Remove the element at the specified index
	 *	@param index		the index of the element
	 *	@return				the object in the element that was removed
	 *	@throws NoSuchElementException if index does not exist
	 */
	public E remove(int index) {
		ListNode<E> node = head;
		if(index == 0) {
			E val = head.getValue();
			head = head.getNext();
			return val;
		}
		
		for(int i = 1; i < index; i++) {
			if(node == null)
				throw new NoSuchElementException();
			node = node.getNext();
		}
		E val = node.getNext().getValue();
		node.setNext(node.getNext().getNext());
		if(node.getNext() == null)
			tail = node;
		return val;
	}
	
	/**	@return	true if list is empty; false otherwise */
	public boolean isEmpty() {
		//~ if(head != null)
			//~ return false;
			
		//~ ListNode<E> node = head;
		//~ while(node == null) {
			//~ node = node.getNext();
			//~ if(node != null)
				//~ return false;
		//~ }
		
		//~ return true;
		
		return head == null;
	}
	
	/**	Tests whether the list contains the given object
	 *	@param object		the object to test
	 *	@return				true if the object is in the list; false otherwise
	 */
	public boolean contains(E object) {
		ListNode<E> node = head;
		while(node != null) {
			if(node.getValue().equals(object))
				return true;
			
			node = node.getNext();
		}
		return false;
	}
	
	/**	Return the first index matching the element
	 *	@param element		the element to match
	 *	@return				if found, the index of the element; otherwise returns -1
	 */
	public int indexOf(E element) {
		int index = 0;
		if(head.getValue().equals(element))
			return index;
		ListNode<E> node = head;
		while(node != null) {
			node = node.getNext();
			index++;
			if(node.getValue().equals(element))
				return index;
		}
		
		return -1;
	}
	
	/**	Prints the list of elements */
	public void printList()
	{
		ListNode<E> ptr = head;
		while (ptr != null)
		{
			System.out.print(ptr.getValue() + "; ");
			ptr = ptr.getNext();
		}
	}
	

}
