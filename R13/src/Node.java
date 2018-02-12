// Alex Laswell
// CS161

public class Node<T>
{

	protected T item;
	protected Node<T> next;

	public Node(T item, Node<T> next)
	{
		setItem(item);
		setNext(next);
	}

	public Node(T item)
	{
		this(item, null);
	}

	public void setItem(T i)
	{
		item = i;
	}

	public T getItem()
	{
		return item;
	}

	public void setNext(Node<T> n)
	{
		next = n;
	}

	public Node<T> getNext()
	{
		return next;
	}

	@Override
	public String toString()
	{
		return item.toString();
	}
}
