package Pekan4;

public class DoubleLinkedList1 {

		static Node head;
		class Node {
			int data;
			Node prev;
			Node next;
			Node(int d) { data = d;
		}
		}
		public void push (int new_data) {
			Node new_Node = new Node(new_data);
			new_Node.next = head;
			new_Node.prev = null;
			
			if (head != null)
				head.prev = new_Node;
			head = new_Node;
		}
		public void display(Node head) {
			Node temp = head;
			
			while (temp != null) {
				System.out.println(temp.data + " --> ");
				temp = temp.next;
			}
			System.out.println("Null");
		}
		public static void main(String[] args) {
		    DoubleLinkedList1 dll = new DoubleLinkedList1();
		    dll.push(42);
		    dll.push(-3);
		    dll.push(17);
		    dll.display(head); 
		}


}
