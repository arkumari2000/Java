import java.util.*;
public class stackUsingQueue<T> {
    Queue<T> q1, q2;
 
    // Constructor
    public stackUsingQueue(){
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }
    void add(T element){
        while(!q1.isEmpty()){
            q2.add(q1.peek());
            q1.poll();
        }
        q1.add(element);
        while(!q2.isEmpty()){
            q1.add(q2.peek());
            q2.poll();
        }
    }
    T poll(){
        T element = q1.peek();
        q1.poll();
        return element;
    }
    void print(){
        System.out.println(Arrays.toString(q1.toArray()));
    }
    public static void main(String[] args){
        stackUsingQueue<Integer> stack = new stackUsingQueue<Integer>();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter the function you want to perform:"+"\n1.add element in stack"+"\n2.delete element from stack"+"\n3.print stack"+"\n0.to stop");
            int choice = sc.nextInt();
            if(choice==1){
                int element = sc.nextInt();
                stack.add(element);
            }else if(choice==2){
                int rem = stack.poll();
                System.out.println(rem);
            }else if(choice==3){
                stack.print();
            }
            else{
                break;
            }
        }
        
    }
}
