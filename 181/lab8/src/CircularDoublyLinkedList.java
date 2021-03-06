/***********************************************************
 * Lab #8 (CIS 181)                                        *
 * Submitted By: Elijah Ellis
 * Date:  Thursday April 6th 
 ***********************************************************/

/**
 * @author Haiping Xu
 * Created on Nov 13, 2008
 */

/////////////////////////////////////////////////////////////
// Circular Linked List that implements ExtendedListInterface
/////////////////////////////////////////////////////////////

public class CircularDoublyLinkedList implements ExtendedListInterface {
    private DoublyNode head; // the head reference to the dummy head node
    private int numItems;    // number of items in list

    public CircularDoublyLinkedList() {
        numItems = 0;

        // create a dummy head node
        head = new DoublyNode(null);
        head.setPrev(head);
        head.setNext(head);
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public int size() {
        return numItems;
    }

    // -------------------------------------------------------------------
    // Locates a specified node in a linked list.
    // Precondition: index is the number of the desired node. Assumes that
    // 1 <= index <= numItems+1
    // Postcondition: Returns a reference to the desired node.
    // -------------------------------------------------------------------
    private DoublyNode find(int index) {
        DoublyNode curr = head;

        // due to the dummy head, we skip nodes for index times
        for (int skip = 1; skip <= index; skip++) {
            curr = curr.getNext();
        }
        return curr;
    }

    public Object get(int index) throws ListException {
        if (index >= 1 && index <= numItems) {
            // get reference to node, then data in node
            DoublyNode curr = find(index);
            Object dataItem = curr.getItem();
            return dataItem;
        } else {
            throw new ListException("List index out of bounds exception " +
                    "on get: " + index);
        }
    }

    // Reuse the get method with appropriate parameter
    public Object getFirst() throws ListException {
        if (size() >= 1) {
            return get(1);
        } else {
            throw new ListException("getFirst on an empty list");
        }
    }

    // To locate the last node without a traversal, DO NOT call the method get
    // in this method. Access the last node through head.getPrev().
    public Object getLast() throws ListException {
        if (size() >= 1) {
            DoublyNode lastNode =  head.getPrev();
            return lastNode.getItem();
        } else {
            throw new ListException("getLast on an empty list");
        }
    }

    // Insert the new node containing item at position index. Refer to
    // Figure 4-30 in the textbook on page 196.
    public void add(int index, Object item) throws ListException {
        // due to the dummy head, index == 1 is not a special case!
        if (index >= 1 && index <= numItems+1) {
            DoublyNode prev = find(index-1);
            DoublyNode curr = prev.getNext();

            DoublyNode newNode = new DoublyNode(item);
            newNode.setPrev(prev);
            newNode.setNext(curr);
            prev.setNext(newNode);
            curr.setPrev(newNode);

            numItems++;
        } else {
            throw new ListException("List index out of bounds exception " +
                    "on add: " + index);
        }
    }

    // Reuse the method add in this method with appropriate parameter.
    public void addFirst(Object item) throws ListException {
    	add(1, item); 
    }

    // To locate the last node without a traversal, DO NOT call the method add
    // in this method.
    public void addLast(Object item) throws ListException {
    	
    	DoublyNode newNode = new DoublyNode(); 
    	newNode.setItem(item);
    	newNode.setNext(head);
    	
    	newNode.setPrev(head.getPrev());
    	head.getPrev().setNext(newNode);
    	head.setPrev(newNode);
    	++numItems;
    }

    // Delete the node at position index of the list. Refer to Figure 4-29
    // in the textbook on page 195.
    public void remove(int index) throws ListException {
    	// Get the node 
    	DoublyNode node = find(index);
    	
    	// Remove it 
    	node.getPrev().setNext(node.getNext());
    	node.getNext().setPrev(node.getPrev());
    	
    	--numItems;
    }

    // Reuse the method remove in this method with appropriate parameter.
    public void removeFirst() throws ListException {
    	remove(1);
    }

    // To locate the last node without a traversal, DO NOT call the method remove
    // in this method.
    public void removeLast() throws ListException {
    	head.setPrev(head.getPrev().getNext());
    	--numItems;
    }

    public void removeAll() {
        // create a dummy head
        head = new DoublyNode(null);
        head.setPrev(head);
        head.setNext(head);
        numItems = 0;
    }
}