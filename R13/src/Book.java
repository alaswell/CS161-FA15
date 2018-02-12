// Alex Laswell
// CS161
// Recitation 13

public class Book
{

	protected double price;
	protected int rank;
	protected int year;
	protected String title; 
	protected String authors;
	protected String publisher;

	public void Book(double price, int rank, int year, String title, String authors, String publisher)
	{
		setPrice(price);
		setRank(rank);
		setYear(year);
		setTitle(title);
		setAuthors(authors);
		setPublisher(publisher);
	}


	public void setPrice(double p)
	{
		price = p;
	}

	public double getPrice()
	{
		return price;
	}	

	public void setRank(int r)
	{
		rank = r;
	}

	public int getRank()
	{
		return rank;
	}	

	public void setYear(int y)
	{
		year = y;
	}
	
	public int getYear()
	{
		return year;
	}

					
	public void setTitle(String t)
	{
		title = t;
	}

	public String getTitle()
	{
		return title;
	}

	public void setAuthors(String a)
	{
		authors = a;
	}
	
	public String getAuthors()
	{
		return authors;
	}

	public void setPublisher(String p)
	{
		publisher = p;
	}

	public String getPublisher()
	{
		return publisher;
	}

	@Override
	public String toString()
	{
		return String.format("%2d. %s, %s, %s, %d, $%.2f", getRank(), getTitle(), 
			getAuthors(), getPublisher(), getYear(), getPrice());
	}
}	
