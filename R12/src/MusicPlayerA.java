public class MusicPlayerA implements MusicPlayerInterface
{
	//Instance vars
	protected String[] songs = new String[1];
	protected boolean isOn;
	protected int curSong;

	//Default Constructor
	public MusicPlayerA () 
	{
		this.songs = songs;
		this.isOn = false;
		this.curSong = -1;
	}

	public void turnOn()
	{
		isOn = true;		
	}

   	public void turnOff() 
	{
		isOn = false;
	}

	public boolean isOn()
	{
		return isOn;
	}

	public void add(String song)
        {
		int length = songs.length-1;

		//Make it one bigger
		resizeStringArray(songs);

		//Add new song to the end
		songs[length] = song;	
        }

	public int indexOf(String song)
        {
		for(int i = 0; i < song.length(); i++)
			if(song.equalsIgnoreCase(songs[i]))
				return i;
		return -1;
        }


	public void play(int songIndex)
        {
		if(!isOn())
			turnOn();
		curSong = Integer.parseInt(songs[songIndex]);
        }


	public int isPlaying()
        {
		return curSong;
        }
	
	public static void main(String[] args) 
	{
		MusicPlayerInterface musicplayer = new MusicPlayerA();

		musicplayer.turnOn();
		System.out.println(musicplayer.isOn());
		
		//Add 3 songs
		musicplayer.add("I Knew I Loved You");	
		musicplayer.add("Hanging by a Moment");			
		musicplayer.add("I want to Know What Love Is");		

		//Print resuts of indexOf()
		System.out.println(musicplayer.indexOf("Hanging by a Moment"));

		//Play a song
		musicplayer.play(2);			
		//Print result of isPlaying()
		System.out.println(musicplayer.isPlaying());		
		//Play another song
		musicplayer.play(0);		
		//Print result of isPlaying()
		System.out.println(musicplayer.isPlaying());			
	}

	//Resizes the array to size + 1
	public String[] resizeStringArray(String[] oldArray) 
	{
		int numberToCopy = oldArray.length;
		String[] newArray = new String[numberToCopy + 1];
		for (int i = 0; i < numberToCopy; i++)
		    newArray[i] = oldArray[i];
		return newArray;
	}
}
