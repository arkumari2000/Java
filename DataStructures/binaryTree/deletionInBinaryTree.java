import java.util.*;
class Node{
    Node left,right;
    int data;
    public Node(int d){
        data = d;
        left = right =null;
    }
}
public class deletionInBinaryTree {
    static Node root;

    public void inorder(Node node){
        if(node==null)
            return;
        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }
    public void deleteDeepest(Node root, Node delNode){
        Queue<Node> q = new LinkedList();
        q.add(root);
        Node temp = root;
        while(!q.isEmpty()){
            temp = q.peek();
            q.remove();
            if(temp==delNode){
                temp = null;
                return;
            }
            if(temp.right!=null){
                if(temp.right==delNode){
                    temp.right = null;
                    return;
                }
                q.add(temp.right);
            }
            if(temp.left!=null){
                if(temp.left==delNode){
                    temp.left = null;
                    return;
                }
                q.add(temp.left);
            }
        }
    }
    public void delete(Node root, int key){
        Queue<Node> q = new LinkedList();
        q.add(root);
        Node keyNode = root;
        Node temp = root;
        while(!q.isEmpty()){
            temp = q.peek();
            q.remove();
            if(temp.data == key)
                keyNode = temp;
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }
        int x = temp.data;
        deleteDeepest(root,temp);
        keyNode.data = x;
    }
    public static void main(String[] args){
        deletionInBinaryTree tree = new deletionInBinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(5);
		tree.root.right = new Node(6);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(7);
		tree.root.right.left = new Node(8);
		tree.root.right.right = new Node(3);

        tree.inorder(root);
        System.out.println("Please enter the node you want to delete: ");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        tree.delete(root,x);
        tree.inorder(root);
    }
}
