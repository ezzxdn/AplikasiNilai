package Pekan1;
import java.util.*;
public class ArrayListIterasi {

	public static void main(String[] args) {
		//membuat ArrayList menggunakan tipe data string
		ArrayList<String> arlistr = new ArrayList<>();
		
		//menambahkan elemen ke ArrayList menggunakan add() method standar
		arlistr.add("saya");
		arlistr.add("informatika");
		arlistr.add("mahasiswa");
		
		//menggunakan get method dan for loop
		for (int i = 0; i < arlistr.size(); i++) {
			System.out.println(arlistr.get(i) + " ");
		}
		System.out.println();
		
		//menggunakan for each loop
		for (String str : arlistr)
			System.out.println(str + " ");
		System.out.println();
		
		//print seluruh elemen ArrayList
		System.out.println("ArrayList sebelumnya: " + arlistr);
		
		//menghapus elemen dari ArrayList tersebut
		arlistr.remove(1);
		
		//print ArrayList terbaru
		System.out.println("Setelah indeks dihapus: " + arlistr);
		
		//menghapus elemen kata dari ArrayList
		arlistr.remove("saya");
		
		//printe kembali ArrayList terbaru
		System.out.println("Setelaah objek dihapus: " + arlistr);
	}

}
