# About

This is my own implementation of:

- Arraylist
- Linkedlist
- Sorting algorithms

## Examples
### ArrayList
```java
// Instanciate the list.
PLMArrayList<Integer> list = new PLMArrayList<>();
list.add(3);
list.add(1);
list.add(9);
// Display the list in a user-friendly way.
list.display();
// Remove the element at the specified position.
list.remove(2);
list.display();
```
> [3, 1, 9]

> [3, 1]

### LinkedList
```java
// Instanciate the list.
PLMLinkedList<String> list = new PLMLinkedList<>();
list.add("Hello");
list.add("World");
list.add("!");
// Remove an element, only the first element who matches with the parameter will be deleted.
list.remove("World");
// Display the list in a user-friendly way.
list.display();
```
> [Hello, !]
