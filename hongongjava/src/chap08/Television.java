package chap08;

public class Television implements Remote_control {
	private int volume;

	@Override
	public void turn_on() {
		System.out.println("turn on TV");
	}

	@Override
	public void turn_off() {
		System.out.println("turn off TV");
	}

	@Override
	public void set_volume(int volume) {
		if (volume > Remote_control.MAX_VOLUME) {
			this.volume = Remote_control.MAX_VOLUME;
		} else if (volume < Remote_control.MIN_VOLUME) {
			this.volume = Remote_control.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("now TV volume : " + this.volume);
	}
}
