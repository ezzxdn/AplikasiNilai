package Pekan1;

public class ArrayReview {

	public static void main(String[] args) {
		//deklarasikan sebuah array dari integer
		int[] arr;
		//mengalokasikan memori untuk 5 integer
		arr = new int[5];
		
		//inisialisasi elemen pertama array
		arr[0] = 10;
		
		//inisialisasi elemen kedua array
		arr[1] = 20;
		
		//begitu setersunya
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;
		
		//mengakses elemen tertentu dari sebuah array
		for (int i = 0; i < arr.length; i++){
		System.out.println("Elemen pada indeks ke-" + i + ": " + arr[i]);
		}
	}

}
