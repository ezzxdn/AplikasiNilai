package Pekan2;

import java.util.Stack;

public class NilaiMinimum {

	public static int min(Stack<Integer> s) {
		Stack<Integer> backup = new Stack<Integer>();
		int minValue = s.pop();
		backup.push(minValue);
		while (!s.isEmpty()) {
			int next = s.pop();
			backup.push(next);
			minValue = Math.min(minValue, next);
		}
		while (!backup.isEmpty()) {
			s.push(backup.pop());
		}
		return minValue;
	}
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(70);
		s.push(12);
		s.push(20);
		System.out.println("Nilai minimum: " + min(s));
		System.out.println("Stack teratas: " + s.peek());
		System.out.println("Isi stack: " + s);

	}

}
