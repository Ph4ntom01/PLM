package plm.util.dynstructures;

import java.util.Arrays;

public class PLMArrayList<E> {

    private int size;
    private Object[] array;
    private static final int ARRAY_SIZE = 10;

    public PLMArrayList() {
        array = new Object[ARRAY_SIZE];
    }

    /**
     * Check if the list is empty.
     * 
     * @return true if the list is empty, otherwise false.
     */
    public boolean isEmpty() {
        return (size == 0);
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
     * Set the size to 0 and instanciate a new initial array.
     */
    public void clear() {
        size = 0;
        array = new Object[ARRAY_SIZE];
    }

    /**
     * Insert a new element.
     * 
     * @param element The element to insert.
     */
    public void add(E element) {
        if (array.length == size) {
            // Increase the initial array capacity when an element is out of bounds.
            array = Arrays.copyOf(array, array.length + ARRAY_SIZE);
        }
        array[size] = element;
        size++;
    }

    /**
     * Get the element at the specified position.
     * 
     * @param index The desired position.
     * @return The element at the specified position.
     * @throws IndexOutOfBoundsException If the index is out of range.
     */
    public Object get(int index) {
        if (isEmpty() || (index < 0 || index >= size())) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        } else {
            return array[index];
        }
    }

    /**
     * Remove the element at the specified position.
     * 
     * @param index The desired position.
     * @throws IndexOutOfBoundsException If the index is out of range.
     */
    public void remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        } else {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            size--;
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
    }

}