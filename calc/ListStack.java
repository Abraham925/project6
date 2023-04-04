package calc;

import java.util.NoSuchElementException;

/**
 * ListStack.java
 *
 * Implementation of a stack using a linked list.  You may not modify this class.
 *
 * @author Thomas VanDrunen
 * CSCI 245, Wheaton College, Spring 2009
 * In-class example
 * Mar 4, 2009
 */

public class ListStack<T> {

    private class Node {
        public T datum;
        public Node next;
        public Node(T datum, Node next) {
            this.datum = datum;
            this.next = next;
        }
    }

    private Node top;

    public ListStack() { top = null; }

    public void push(T item) { 

        top = new Node(item, top);

    }

    public T pop() { 

        if (top == null)
            throw new NoSuchElementException();
        
        T toReturn = top.datum;
        top = top.next;
        return toReturn;

    }

    public T top() { 

        if (top == null)
            throw new NoSuchElementException();

        return top.datum;
        
    }

    public boolean empty() { 

        return top == null;

    }

    public boolean full() { 
        
        return false;

    }

}