package plm.util.dynstructures;

public class PLMNode<E> {

    private E element;
    private PLMNode<E> prev;
    private PLMNode<E> next;

    /**
     * Insert or replace the specified element at the first node.
     * 
     * @param element The element to be stored at the first node.
     */
    public PLMNode(E element) {
        this.element = element;
        this.prev = null;
        this.next = null;
    }

    /**
     * Get the element at the current node.
     * 
     * @return The element at the current node.
     */
    public E getElement() {
        return element;
    }

    /**
     * Get the previous node.
     * 
     * @return the previous node or null if the current node is the head.
     */
    public PLMNode<E> getPrev() {
        return prev;
    }

    /**
     * Get the next node.
     * 
     * @return The next node or null if the current node is the tail.
     */
    public PLMNode<E> getNext() {
        return next;
    }

    /**
     * Insert or replace an element at the current node with the specified value.
     * 
     * @param element The element to be stored at the current node.
     */
    public void setElement(E element) {
        this.element = element;
    }

    /**
     * Insert the previous node.
     * 
     * @param prev The previous node.
     */
    public void setPrev(PLMNode<E> prev) {
        this.prev = prev;
    }

    /**
     * Insert the next node.
     * 
     * @param next The next node.
     */
    public void setNext(PLMNode<E> next) {
        this.next = next;
    }

}