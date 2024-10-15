package chap06;

public class Student {
	String std_num;
	String std_name;
	int korean;
	int english;
	int math;
	
	Student (String std_num, String std_name, int korean, int english, int math) {
		this.std_num = std_num;
		this.std_name = std_name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
	
	int sum () {
		return korean + english + math;
	}
	
	double avg () {
		return (double)sum() / 3;
	}
	
	String grade() {
		if (avg() >= 90) {
			return "A";
		} else if (avg() >= 80) {
			return "B";
		} else if (avg() >= 70) {
			return "C";
		} else if (avg() >= 60) {
			return "D";
		} else {
			return "F";
		}
	}
	
	void result () {
		System.out.println("std_num : " + std_num);
		System.out.println("name : " + std_name);
		System.out.println("korean : " + korean);
		System.out.println("english : " + english);
		System.out.println("math : " + math);
		System.out.println("sum : " + sum());
		System.out.printf("avg : %3.2f\n", avg());
		System.out.println("grade : " + grade());
		System.out.println();
		
	}
}
