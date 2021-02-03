import java.util.Arrays;
import java.util.Scanner;

class bubbleSort{
    void increaseBubbleSort(int[] arr, int n){
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    void decreaseBubbleSort(int[] arr, int n){
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]<arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
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
        bubbleSort bs = new bubbleSort();
        System.out.println("Enter your choice:\n1. to sort array in ascending order\t2. to sort array in descending order");
        int choice = sc.nextInt();
        if(choice == 1){
            bs.increaseBubbleSort(arr,n);
            System.out.println("The elements of the Sorted array in the ascending order are: ");
            System.out.println(Arrays.toString(arr));
        } else if(choice == 2){
            bs.decreaseBubbleSort(arr,n);
            System.out.println("The elements of the Sorted array in the descending order are: ");
            System.out.println(Arrays.toString(arr));
        } else{
            System.out.println("Please enter a vaild option!");
        }
    }
}

