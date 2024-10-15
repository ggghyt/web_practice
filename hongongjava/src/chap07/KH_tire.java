package chap07;

public class KH_tire extends Tire {
	
	public KH_tire (String location, int max_rotation) {
		super(location, max_rotation);
	}
	
	public boolean roll() {
		accumulated_rotation++;
		if (accumulated_rotation < max_rotation) {
			System.out.println(location + " : KH tire left : " + (max_rotation - accumulated_rotation));
			return true;
		} else {
			System.out.println(location + " : KH tire left : 0");
			return false;
		}
	}
}
