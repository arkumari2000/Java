import java.util.*;

public class bucketSort{
    public void increasebucketSort(float[] arr, int n){
        List<Float>[] list = new List[n];
        for(int i=0;i<n;i++){
            list[i] = new ArrayList();
        }
        for(int i=0;i<n;i++){
            float index = arr[i]*n;
            list[(int)index].add(arr[i]);
        }
        for(int i=0;i<n;i++){
            Collections.sort(list[i]);
        }
        int index = 0;
        for(List<Float> lists : list){
            for(float num : lists){
              arr[index++] = num;
            }
          }
    }
    public void decreasebucketSort(float[] arr, int n){
        List<Float>[] list = new List[n];
        for(int i=0;i<n;i++){
            list[i] = new ArrayList();
        }
        for(int i=0;i<n;i++){
            float index = arr[i]*n;
            list[(int)index].add(arr[i]);
        }
        for(int i=0;i<n;i++){
            Collections.sort(list[i]);
        }
        int index = 0;
        for(int i=n-1;i>=0;i--){
            for(int j=list[i].size()-1;j>=0;j--){
                arr[index++]=list[i].get(j);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array: ");
        int n = sc.nextInt();
        float[] arr = new float[n]; 
        System.out.println("Enter the elements of array: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextFloat();
        }
        bucketSort bs = new bucketSort();
        System.out.println("Enter your choice:\n1. to sort array in ascending order\t2. to sort array in descending order");
        int choice = sc.nextInt();
        if(choice == 1){
            bs.increasebucketSort(arr,n);
            System.out.println("The elements of the Sorted array in the ascending order are: ");
            System.out.println(Arrays.toString(arr));
        } else if(choice == 2){
            bs.decreasebucketSort(arr,n);
            System.out.println("The elements of the Sorted array in the descending order are: ");
            System.out.println(Arrays.toString(arr));
        } else{
            System.out.println("Please enter a vaild option!");
        }
    }
}