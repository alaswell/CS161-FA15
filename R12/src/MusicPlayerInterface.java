public interface MusicPlayerInterface
{
	public void turnOn();
	public void turnOff();
	public boolean isOn();
	
	public void add(String song);
	public int indexOf(String song);
	public void play(int songINdex);
	public int isPlaying();
}
