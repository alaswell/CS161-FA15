// Alex Laswell
// CS161


public class LinkedList<T>
{
	Node<T> head;
	protected int size;
		
	public LinkedList()
	{
		head = null;
		size = 0;
	}

	public void addToFront(T item) 
	{
		head = new Node(item, head);		
		size++;
	}

	public void addToBack(T item)
	{
		Node<T> current = head;

		if(head == null)
			addToFront(item);
		else
		{
			for(int i = 0; i < size - 1; i++)
				current = current.getNext();
			current.setNext(new Node(item, null));
			size++;
		}	
	}

	public void remove(int index)
	{
		Node<T> current = head;

		if(index == 0)
			head = head.getNext();
		else 
		{
			for(int i = 0; i < index - 1; i++)
				current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
		size--;
	}

	public T get(int index) 
	{
		Node<T> current = head;

		for(int i = 0; i < index; i++)
			current = current.getNext();
		return current.getItem();
	}

	public void clear()
	{
		head = null;
		size = 0;
	}

	public int size() 
	{
		return size;
	}

	@Override
	public String toString()
	{
		String result = "";
		if(head == null)
			return result;
		for(Node<T> p = head; p != null; p = p.getNext())
			result += p.getItem() + "\n";
		return result.substring(0, result.length()-1); // remove last \n
	}
}
