package Pekan3;
import java.util.*;
public class ReverseData {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		q.add(2);
		q.add(3); // [1, 2, 3]
		System.out.println("Sebelum reverse: " + q);
		
		Stack<Integer> s = new Stack<Integer>();
		while (!q.isEmpty()) { //q -> s
			s.push(q.remove());
		}
		while (!s.isEmpty()) { //s -> q
			q.add(s.pop());
		}
		System.out.println("Sesudah reverse: " + q);
	}

}
