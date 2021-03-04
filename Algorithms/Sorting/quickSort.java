import java.util.Scanner;
import java.util.Arrays;

public class quickSort {

    void swap(int[] arr,int start,int end){
        int temp =arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    int ascendingPartition(int[] arr,int lb,int ub){
        int pivot = arr[lb];
        int start = lb;
        int end = ub;
        while(start<end){
            while(arr[start]<=pivot)
                start++;
            while(arr[end]>pivot)
                end--;
            if(start<end)
                swap(arr,start,end);
        }
        swap(arr,lb,end);
        return end;
    }

    int descendingPartition(int[] arr,int lb,int ub){
        int pivot = arr[ub];  
        int i = (lb - 1);  
        for (int j = lb; j <= ub- 1; j++)
        {
            if (arr[j] > pivot)
            {
                i++; 
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,ub);
        return (i + 1);
    }

    void quickSortCall(int[] arr,int lb,int ub,int choice){
        int loc;
        if(lb<ub){
            if(choice==1)
                loc = ascendingPartition(arr, lb, ub);
            else
                loc = descendingPartition(arr,lb,ub);
            quickSortCall(arr, lb, loc-1,choice);
            quickSortCall(arr, loc+1, ub,choice);
        }
        else
            return;
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
        quickSort qs = new quickSort();
        System.out.println("Enter your choice:\n1. to sort array in ascending order\t2. to sort array in descending order");
        int choice = sc.nextInt();
        if(choice == 1){
            qs.quickSortCall(arr,0,n-1,choice);
            System.out.println("The elements of the Sorted array in the ascending order are: ");
            System.out.println(Arrays.toString(arr));
        }else if(choice == 2){
            qs.quickSortCall(arr,0,n-1,choice);
            System.out.println("The elements of the Sorted array in the descending order are: ");
            System.out.println(Arrays.toString(arr));
        }else{
            System.out.println("Please enter a vaild option!");
        }
    }
}
