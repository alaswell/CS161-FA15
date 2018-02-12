public interface Node161<T> {

    // Return the data item stored in this Node.
    public T getItem();

    // Set the data item for this Node.
    public void setItem(T x);

    // Return the next Node reference stored in this Node.
    public Node<T> getNext();

    // Set the next Node reference for this node.
    public void setNext(Node<T> n);

    // Return the result of the toString method applied to the data item of this Node.
    public String toString();
}
