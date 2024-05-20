package Pekan4;

public class SingleLinkedList1 {

	public static void main(String[] args) {
		ListNode list = new ListNode();
		list.data = 42;
		list.next = new ListNode();
		list.next.data = -3;
		list.next.next = new ListNode();
		list.next.next.data = 17;
		list.next.next.next = null;
		
		System.out.println(list.data + " " + list.next.data + " " + list.next.next.data);

	}

}
