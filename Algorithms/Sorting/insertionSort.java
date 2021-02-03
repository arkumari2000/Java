import java.util.Arrays;
import java.util.Scanner;

public class insertionSort {
    void ascendingInsertionSort(int[] arr,int n){
        for(int i=0;i<n;i++){
            int key = arr[i];
            int j=i-1;
            while(j>=0 && key<arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
    void descendingInsertionSort(int[] arr,int n){
        for(int i=0;i<n;i++){
            int key = arr[i];
            int j=i-1;
            while(j>=0 && key>arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array: ");
        int n = sc.nextInt();
        int[] arr = new int[n]; 
        System.out.println("Enter the elements of array: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        insertionSort is = new insertionSort();
        System.out.println("Enter your choice:\n1. to sort array in ascending order\t2. to sort array in descending order");
        int choice = sc.nextInt();
        if(choice == 1){
            is.ascendingInsertionSort(arr,n);
            System.out.println("The elements of the Sorted array in the ascending order are: ");
            System.out.println(Arrays.toString(arr));
        } else if(choice == 2){
            is.descendingInsertionSort(arr,n);
            System.out.println("The elements of the Sorted array in the descending order are: ");
            System.out.println(Arrays.toString(arr));
        } else{
            System.out.println("Please enter a vaild option!");
        }
    }
}
