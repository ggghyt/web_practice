package chap02;

import java.io.IOException;

public class system_p117 {

	public static void main(String[] args) {
		int keycode = 0;
		
		while (true) {
			try {
				keycode = System.in.read();
				System.out.println("keycode : " + keycode);
				if (keycode == 113) {
					break;
				}
			} catch (IOException e) {
				System.out.println("nothing");
			}
		}

	}

}