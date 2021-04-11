import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
	int key;
	Node left, right;
	
	public Node(int d) {
		key = d;
		left=right=null;
	}
}
public class insertLevelOrder {
    static Node root;
    insertLevelOrder(){
    	root = null;
    }
    
    public void insert(Node temp, int key){
        if(temp==null)
            return;
        
        Queue<Node> q = new LinkedList<Node>();
        q.add(temp);

        while(!q.isEmpty()){
            temp = q.peek();
            q.remove();
            if(temp.left==null){
                temp.left = new Node(key);
                return;
            }else{
                q.add(temp.left);
            }
            if(temp.right==null){
                temp.right = new Node(key);
                return;
            }else{
                q.add(temp.right);
            }
        }
    }

    public void inOrder(Node node) {
    	if(node==null)
    		return;
    	inOrder(node.left);
    	System.out.print(node.key+" ");
    	inOrder(node.right);
    }

    public static void main(String[] args) {
		insertLevelOrder tree = new insertLevelOrder();
		tree.root = new Node(10);
		tree.root.left = new Node(5);
		tree.root.right = new Node(6);
		tree.root.left.left = new Node(4);
		tree.root.right.left = new Node(8);
		tree.root.right.right = new Node(3);

        System.out.println("Before adding:");
		tree.inOrder(root);

        System.out.println("\n Enter the number you want to add in the tree:");
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        tree.insert(root,t);
		
		System.out.println("after insertion:");
		tree.inOrder(root);
	}
 
}