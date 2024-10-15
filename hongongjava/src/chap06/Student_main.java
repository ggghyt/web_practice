package chap06;

public class Student_main {

	public static void main(String[] args) {
		Student[] student = new Student[5];
		student[0] = new Student("01", "first", ((int)(Math.random() * 51) + 50), ((int)(Math.random() * 51) + 50), ((int)(Math.random() * 51) + 50));
		student[1] = new Student("02", "second", ((int)(Math.random() * 51) + 50), ((int)(Math.random() * 51) + 50), ((int)(Math.random() * 51) + 50) );
		student[2] = new Student("03", "third", ((int)(Math.random() * 51) + 50), ((int)(Math.random() * 51) + 50), ((int)(Math.random() * 51) + 50));
		student[3] = new Student("04", "fourth", ((int)(Math.random() * 51) + 50), ((int)(Math.random() * 51) + 50), ((int)(Math.random() * 51) + 50));
		student[4] = new Student("05", "fifth", ((int)(Math.random() * 51) + 50), ((int)(Math.random() * 51) + 50), ((int)(Math.random() * 51) + 50));
		
		student[0].result();
		student[1].result();
		student[2].result();
		student[3].result();
		student[4].result();
		
	}

}
