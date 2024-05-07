package Pekan1;

import java.util.ArrayList;

public class ArrayList2 {

	public static void main(String[] args) {
		//ukuran ArrayList
				int n = 5;
				
		//deklarasikan ArrayList dengan ukuran awal n
				ArrayList<Integer> arrli = new ArrayList<Integer>(n);
				
		//elemen baru pada akhir list
				for(int i = 0; i <= n; i++) 
					arrli.add(i);
				
		//print elemen
				System.out.println(arrli);
				
		//menghapus elemen pada indeks ke-3
				arrli.remove(3);
				
		//menampilkan ArrayList setelah dihapus
				System.out.println(arrli);
				
		//print elemen satu persatu
				for (int i = 0; i < arrli.size(); i++)
					System.out.print(arrli.get(i)+ " ");

	}

}
