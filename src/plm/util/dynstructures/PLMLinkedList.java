package plm.util.dynstructures;

public class PLMLinkedList<E> {

    private int size;
    private PLMNode<E> head;
    private PLMNode<E> tail;
    private PLMNode<E> cursor;

    /**
     * Check if the list is empty.
     * 
     * @return true if the list is empty, otherwise false.
     */
    public boolean isEmpty() {
        return (cursor == null);
    }

    /**
     * Get the size of the list.
     * 
     * @return the size of the list.
     */
    public int size() {
        return (isEmpty()) ? 0 : size;
    }

    /**
     * Set the size to 0 and destroy the nodes.</br>
     * The list will be eligible to be garbage collected.
     */
    public void clear() {
        size = 0;
        head = null;
        tail = null;
        cursor = null;
    }

    /**
     * Insert an element in the begining of the list.
     * 
     * @param element The element to insert.
     */
    public void addFirst(E element) {
        PLMNode<E> newNode = new PLMNode<>(element);
        if (isEmpty()) {
            head = newNode;
            cursor = newNode;
            tail = newNode;
        } else {
            head.setPrev(newNode);
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }

    /**
     * Insert a new element.
     * 
     * @param element The element to insert.
     */
    public void add(E element) {
        PLMNode<E> newNode = new PLMNode<>(element);
        if (isEmpty()) {
            head = newNode;
            cursor = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
    }

    /**
     * Insert a new element at a specified position.
     * 
     * @param element The element to insert.
     * @param index   The desired position.
     */
    public void add(E element, int index) {
        positionOnHead();
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                if (cursor.getPrev() == null) {
                    addFirst(element);
                } else if (cursor.getNext() == null) {
                    add(element);
                } else {
                    PLMNode<E> newNode = new PLMNode<>(element);
                    cursor.getPrev().setNext(newNode);
                    newNode.setPrev(cursor.getPrev());
                    cursor.setPrev(newNode);
                    newNode.setNext(cursor);
                }
            } else {
                positionOnNext();
            }
        }
        size++;
        positionOnHead();
    }

    /**
     * Remove an element, only the first element who matches with the parameter will be deleted.
     * 
     * @param element The element to remove.
     */
    public void remove(E element) {
        positionOnHead();
        while (!isEmpty()) {
            if (cursor.getElement().equals(element)) {
                if (cursor.getPrev() == null) {
                    head = cursor.getNext();
                    head.setPrev(null);
                    size--;
                    return;
                } else if (cursor.getNext() == null) {
                    tail = cursor.getPrev();
                    tail.setNext(null);
                    size--;
                    return;
                } else {
                    cursor.getPrev().setNext(cursor.getNext());
                    cursor.getNext().setPrev(cursor.getPrev());
                    size--;
                    return;
                }
            }
            positionOnNext();
        }
    }

    /**
     * Remove all the elements who match with the parameter.
     * 
     * @param element The elements to remove.
     */
    public void removeAll(E element) {
        positionOnHead();
        while (!isEmpty()) {
            if (cursor.getElement().equals(element)) {
                if (cursor.getPrev() == null) {
                    head = cursor.getNext();
                    head.setPrev(null);
                    size--;
                } else if (cursor.getNext() == null) {
                    tail = cursor.getPrev();
                    tail.setNext(null);
                    size--;
                } else {
                    cursor.getPrev().setNext(cursor.getNext());
                    cursor.getNext().setPrev(cursor.getPrev());
                    size--;
                }
            }
            positionOnNext();
        }
        positionOnHead();
    }

    /**
     * Find an element in the list.
     * 
     * @param element The element to find.
     * @return true if this list contains the desired element, otherwise false.
     */
    public boolean contains(E element) {
        positionOnHead();
        while (!isEmpty()) {
            if (cursor.getElement().equals(element)) {
                return true;
            }
            positionOnNext();
        }
        return false;
    }

    /**
     * Find all the elements who match with the parameter.
     * 
     * @param element The element to find.
     * @return An integer value who represents the founded elements.
     */
    public int containsAll(E element) {
        positionOnHead();
        int numberOfElements = 0;
        while (!isEmpty()) {
            if (cursor.getElement().equals(element)) {
                numberOfElements++;
            }
            positionOnNext();
        }
        positionOnHead();
        return numberOfElements;
    }

    /**
     * Get the element at the specified position.
     * 
     * @param index The desired position.
     * @return The element at the specified position, otherwise null.
     */
    public E get(int index) {
        positionOnHead();
        for (int i = 0; i < index; i++) {
            positionOnNext();
        }
        return cursor.getElement();
    }

    /**
     * Position the cursor on the head.
     */
    private void positionOnHead() {
        cursor = head;
    }

    /**
     * Position the cursor on the next node.
     */
    private void positionOnNext() {
        if (!isEmpty()) {
            cursor = cursor.getNext();
        }
    }

    /**
     * Display the list in a user-friendly way.
     */
    public void display() {
        if (!isEmpty()) {
            int tailPosition = size - 1;
            System.out.print("[");
            for (int i = 0; i < tailPosition; i++) {
                System.out.print(get(i) + ", ");
            }
            System.out.println(get(tailPosition) + "]");
        } else {
            throw new IndexOutOfBoundsException("Size: " + size);
        }
        positionOnHead();
    }

}