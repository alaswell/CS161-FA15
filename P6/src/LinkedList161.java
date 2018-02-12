public interface LinkedList161<T> {

    // Add a new Node containing item in the first position of the linked list.
    public void addFirst(T item);

    // Return the number of elements in the linked list.
    public int size();

    // Remove all elements from the linked list.
    public void clear();

    // Add a new Node containing item to the linked list at the position given by the index.
    // If the index is out of bounds, throw an IndexOutOfboudsException.
    // For example, if index is 2, then the new Node becomes the third item in the linked list.
    public void add(T item, int index);

    // Remove the node at the position given by the index.
    // If the index is out of bounds, throw an IndexOutOfboudsException.
    // For example, if index is 2, then the third Node in the linked list is removed.
    public void remove(int index);

    // Return the data item stored in the Node at the position given by index.
    // If the index is out of bounds, throw an IndexOutOfboudsException.
    public T get(int index);

    // Sort the elements of the linked list.  
    // You choose the sort algorithm. Bubble sort is fun.
    // Try implementing a swap method first and debug that.  This is not required.
    public void sort();

    // Return a String that contains the items stored in the Nodes of the linked list.
    // The String must include a newline character "\n" after each item.
    public String toString();
}
	
