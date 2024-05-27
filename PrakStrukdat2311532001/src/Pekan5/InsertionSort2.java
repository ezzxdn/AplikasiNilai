package Pekan5;

public class InsertionSort2 {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n ; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    public static void main(String[] args) {
        int arr[] = {3, 10, 4, 6, 8, 9, 7, 2, 1, 5};
        int n = arr.length;
        System.out.printf("Array yang belum terurut: \n");
        
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        
        System.out.println("");
        insertionSort(arr);
        
        System.out.printf("Array yang sudah terurut: \n");
        
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        
        System.out.println();
    }
}
