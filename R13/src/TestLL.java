// Alex Laswell
// CS161
// Recitation 13

public class TestLL 
{

	public static void main(String[] args)
	{
		LinkedList<String> names = new LinkedList<String>();
	
		names.addToFront("AAA");
		names.addToFront("BBB");
		names.addToBack("ZZZ");
		names.addToBack("YYY");
		names.addToFront("humm");
		System.out.println(names);
	
		System.out.println("size = " + names.size());

		System.out.println("get(2) = " + names.get(2));	

		names.remove(2);
		System.out.println("after remove(2) size is " + names.size() + " and list is ");
		System.out.println(names);

		names.remove(1);
		System.out.println("after remove(1) size is " + names.size() + " and list is ");
		System.out.println(names);

		names.clear();
		System.out.println("after clear(), size is " + names.size() + " and list is ");
		System.out.println(names);
	}
}		

