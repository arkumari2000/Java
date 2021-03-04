import java.util.Scanner;
import java.util.Arrays;

public class countingSort {
    void choiceCountingSort(int[] arr,int n,int choice){
        int max=Integer.MIN_VALUE;
        int[] output = new int[n];
        for(int i=0;i<n;i++){
            max = Math.max(max,arr[i]);
        }
        int[] count = new int[max+1];
        for(int i=0;i<n;i++){
            count[arr[i]]++;
        }
        for(int i=1;i<=max;i++){
            count[i] += count[i-1];
        }
        if(choice==1){
            for(int i=0;i<n;i++){
                output[count[arr[i]]-1]=arr[i];
                --count[arr[i]];
            }
        }else{
            for(int i=0;i<n;i++){
                output[((n-1)-count[arr[i]])+1]=arr[i];
                --count[arr[i]];
            }
        }
        for(int i=0;i<n;i++){
            arr[i]=output[i];
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
        countingSort cs = new countingSort();
        System.out.println("Enter your choice:\n1. to sort array in ascending order\t2. to sort array in descending order");
        int choice = sc.nextInt();
        if(choice==1 || choice==2){
            cs.choiceCountingSort(arr,n,choice);
            System.out.println("The elements of the Sorted array in the descending order are: ");
            System.out.println(Arrays.toString(arr));
        } else{
            System.out.println("Please enter a vaild option!");
        }
    }
}
