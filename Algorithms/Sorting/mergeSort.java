import java.util.Arrays;
import java.util.Scanner;

public class mergeSort{
    void mergeDivide(int[] arr, int l, int u,int choice){
        if(l<u){
            int mid = (l+u)/2;
            mergeDivide(arr,l,mid,choice);
            mergeDivide(arr,mid+1,u,choice);
            if(choice==1){
                mergeAscending(arr,l,mid,u);
            } else {
                mergeDescending(arr,l,mid,u);
            }
            
        }
    }
    void mergeAscending(int[] arr, int l, int mid, int u){
        int n1 = mid-l+1;
        int n2 = u-mid;
        int[] L = new int[n1];
        int[] M = new int[n2];
        for(int i=0;i<n1;i++)
            L[i] = arr[l+i];
        for(int j=0;j<n2;j++)
            M[j] = arr[mid+j+1];
        int i=0,j=0,k=l;
        while(i<n1 && j<n2){
            if(L[i]<=M[j])
                arr[k++]=L[i++];
            else
                arr[k++]=M[j++];
        }
        while(i<n1){
            arr[k++]=L[i++];
        }
        while(j<n2){
            arr[k++]=M[j++];
        }
    }
    void mergeDescending(int[] arr, int l, int mid, int u){
        int n1 = mid-l+1;
        int n2 = u-mid;
        int[] L = new int[n1];
        int[] M = new int[n2];
        for(int i=0;i<n1;i++)
            L[i] = arr[l+i];
        for(int j=0;j<n2;j++)
            M[j] = arr[mid+j+1];
        int i=0,j=0,k=l;
        while(i<n1 && j<n2){
            if(L[i]>=M[j])
                arr[k++]=L[i++];
            else
                arr[k++]=M[j++];
        }
        while(i<n1){
            arr[k++]=L[i++];
        }
        while(j<n2){
            arr[k++]=M[j++];
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
        mergeSort is = new mergeSort();
        System.out.println("Enter your choice:\n1. to sort array in ascending order\t2. to sort array in descending order");
        int choice = sc.nextInt();
        if(choice == 1){
            is.mergeDivide(arr,0,n-1,choice);
            System.out.println("The elements of the Sorted array in the ascending order are: ");
            System.out.println(Arrays.toString(arr));
        } else if(choice == 2){
            is.mergeDivide(arr,0,n-1,choice);
            System.out.println("The elements of the Sorted array in the descending order are: ");
            System.out.println(Arrays.toString(arr));
        } else{
            System.out.println("Please enter a vaild option!");
        }
    }
}