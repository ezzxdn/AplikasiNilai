package Pekan1;
import java.util.ArrayList;
public class ArrayListSisip {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer> ();
		
		//tambahkan angka
		
		list.add(1);
		list.add(2);
		list.add(4);
		System.out.println(list);
		
		//masukkan elemen yang hilang
		list.add(2, 3);
		System.out.println(list);
	}

}
