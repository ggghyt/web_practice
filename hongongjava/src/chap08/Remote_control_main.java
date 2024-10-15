package chap08;

public class Remote_control_main {

	public static void main(String[] args) {
		Remote_control rc;
		rc = new Television();
		rc.turn_on();
		rc.turn_off();
		rc.set_volume(256);
		rc = new Audio();
		rc.turn_on();
		rc.turn_off();
		rc.set_volume(-5);
	}

}
