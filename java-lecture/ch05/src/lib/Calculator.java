package lib;

// 추상 메소드를 하나라도 가지고 있으면 추상 클래스가 되어야 한다.
public abstract class Calculator {
	public abstract int add(int a, int b);
	public abstract int subtract(int a, int b);
	public abstract double average(int[] array);
}
