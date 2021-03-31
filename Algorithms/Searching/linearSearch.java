import java.util.Arrays;
import java.util.Scanner;

public class linearSearch {
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
        int index;
        int flag = 0;
        // for loop of linear search
        for(index=0;index<n;index++){
            if(x==arr[index]){
                flag=1;
                break;
            }
        }
        if(flag==1){
            System.out.println("The element "+x+" is present at index: "+index);
        }else{
            System.out.println("The element "+x+" is not present in the array");
        }
    }
    
}
