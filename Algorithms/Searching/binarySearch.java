import java.util.Arrays;
import java.util.Scanner;

public class binarySearch {
    private int search(int[] arr, int key){
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length-1;
        while(low!=high){
            int mid = (high+low)/2;
            if(key==arr[mid]){
                return mid;
            }else if(key<mid){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
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
        System.out.println("Enter the number to search:");
        int x = sc.nextInt();
        binarySearch bs = new binarySearch();
        int ans = bs.search(arr, x);
        if(ans==-1){
            System.out.println("The element "+x+" is not present in the given array");
        }else{
            System.out.println("The element "+x+"is present at index: "+ans);
        }
    }
}
