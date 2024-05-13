package Pekan2;
import java.util.*;
public class ContohStack {

	public static void main(String[] args) {
		ArrayStack test = new ArrayStack();
		Integer[] a = {4, 8, 15, 16, 23, 42};
		for (int i = 0; i < a.length; i++) {
			System.out.println("Nilai a " + i + "= " + a[i]);
			test.push(a[i]);
		}
		System.out.println("Size stack-nya: " + test.size());
		System.out.println("Paling atas: " + test.top());
		System.out.println("Nilainya: " + test.pop());

	}

}
