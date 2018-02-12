// Alex Laswell
// CS161
// Program 6
// Email: alaswell@cs.colostate.edu

public class Node<T> implements Node161<T> 
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

	public T getItem()
	{
		return item;
	}
	
	public void setItem(T x)
	{
		item = x;
	}

	public Node<T> getNext()
	{
		return next;
	}
	
	public void setNext(Node<T> n)
	{
		next = n;
	}

	@Override
	public String toString()
	{
		return item.toString();
	}	
}
