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
			for(int i = 0; i < index; i++) {
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
		return null;
	}
	
	/**	Replace the object at the specified index
	 *	@param index		the index of the object
	 *	@param obj			the object that will replace the original
	 *	@return				the object that was replaced
	 *	@throws NoSuchElementException if index does not exist
	 */
	public E set(int index, E obj) {
		return null;
	}
	
	/**	Remove the element at the specified index
	 *	@param index		the index of the element
	 *	@return				the object in the element that was removed
	 *	@throws NoSuchElementException if index does not exist
	 */
	public E remove(int index) {
		return null;
	}
	
	/**	@return	true if list is empty; false otherwise */
	public boolean isEmpty() {
		return false;
	}
	
	/**	Tests whether the list contains the given object
	 *	@param object		the object to test
	 *	@return				true if the object is in the list; false otherwise
	 */
	public boolean contains(E object) {
		return false;
	}
	
	/**	Return the first index matching the element
	 *	@param element		the element to match
	 *	@return				if found, the index of the element; otherwise returns -1
	 */
	public int indexOf(E element) {
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
