import java.util.Arrays;
import java.util.Scanner;

class selectionSort{
    // Method to sort array in ascending order
    void ascendingSelectionSort(int[] arr,int n){
        for(int i=0;i<n-1;i++){
            int min_index = i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[min_index]){
                    min_index = j;
                }
            }
            if(i != min_index){
                int temp = arr[i];
                arr[i] = arr[min_index];
                arr[min_index]= temp;
            }
        }
    }
    //Method to sort array in descending order
    void descendingSelectionSort(int[] arr,int n){
        for(int i=0;i<n-1;i++){
            int max_index = i;
            for(int j=i+1;j<n;j++){
                if(arr[j]>arr[max_index]){
                    max_index = j;
                }
            }
            if(i != max_index){
                int temp = arr[i];
                arr[i] = arr[max_index];
                arr[max_index]= temp;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array: ");
        int n = sc.nextInt();
        int[] arr = new int[n]; 
        System.out.println("Enter the elements of array: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        selectionSort ss = new selectionSort();
        System.out.println("Enter your choice:\n1. to sort array in ascending order\t2. to sort array in descending order");
        int choice = sc.nextInt();
        if(choice == 1){
            ss.ascendingSelectionSort(arr,n);
            System.out.println("The elements of the Sorted array in the ascending order are: ");
            System.out.println(Arrays.toString(arr));
        } else if(choice == 2){
            ss.descendingSelectionSort(arr,n);
            System.out.println("The elements of the Sorted array in the descending order are: ");
            System.out.println(Arrays.toString(arr));
        } else{
            System.out.println("Please enter a vaild option!");
        }
    }
}