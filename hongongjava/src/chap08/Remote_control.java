package chap08;

public interface Remote_control {
	public int MAX_VOLUME = 10;
	public int MIN_VOLUME = 0;
	
	public void turn_on();
	public void turn_off();
	public void set_volume(int volume);
}
