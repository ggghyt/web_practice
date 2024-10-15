package chap07;

public class Computer extends Calculator {
	@Override
	double area_circle(double r) {
		return Math.PI * r * r;
	}
	
}
