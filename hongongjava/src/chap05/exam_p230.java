package chap05;

import java.util.Calendar;

public class exam_p230 {

	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		int date = now.get(Calendar.DAY_OF_MONTH);
		int day = now.get(Calendar.DAY_OF_WEEK);
		
		Week day_week = null;
		switch (day) {
		case 1:
			day_week = Week.sunday;
			break;
		case 2:
			day_week = Week.monday;
			break;
		case 3:
			day_week = Week.tuesday;
			break;
		case 4:
			day_week = Week.wednesday;
			break;
		case 5:
			day_week = Week.thursday;
			break;
		case 6:
			day_week = Week.friday;
			break;
		case 7:
			day_week = Week.saturday;
			break;
		}
		
		System.out.println(year + " " + month + " " + date + " " + day_week);
		
		LoginResult result = LoginResult.FAIL_PASSWORD;
		if (result == LoginResult.SUCCESS) {
			System.out.println("success");
		} else if (result == LoginResult.FAIL_ID) {
			System.out.println("fail id");
		} else if (result == LoginResult.FAIL_PASSWORD) {
			System.out.println("fail password");
		}
	}

}
