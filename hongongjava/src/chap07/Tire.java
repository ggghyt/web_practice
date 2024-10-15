package chap07;

public class Tire {
	public int max_rotation;
	public int accumulated_rotation = 0;
	public String location;
	
	public Tire (String location, int max_rotation) {
		this.location = location;
		this.max_rotation = max_rotation;
	}
	
	public boolean roll() {
		accumulated_rotation++;
		if (accumulated_rotation < max_rotation) {
			System.out.println(location + " : tire left : " + (max_rotation - accumulated_rotation));
			return true;
		} else {
			System.out.println(location + " : tire left : 0");
			return false;
		}
	}
}
