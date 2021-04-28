import java.util.Scanner;
class Node{
    int data;
    Node left,right;
    public Node(int d){
        data = d;
        left = right = null;
    }
}
public class DeletionInBST {
    static Node root;
    // to traverse tree inorder
    private void inOrder(Node node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }
    public void insert(int key){
        root = insertrec(root,key);
    }
    public Node insertrec(Node root, int key){
        if(root == null){
            root = new Node(key);
            return root;
        }
        if(key<root.data){
            root.left = insertrec(root.left,key);
        }else if(key>root.data){
            root.right = insertrec(root.right,key);
        }
        return root;
    }
    public void delete(int key){
        root = deleterec(root, key);
    }
    public Node deleterec(Node root, int key){
        // Base Case: If the tree is empty 
        if (root == null)
            return root;
 
        // Otherwise, recur down the tree
        if (key < root.data)
            root.left = deleterec(root.left, key);
        else if (key > root.data)
            root.right = deleterec(root.right, key);
 
        // if key is same as root's key, then This is the node to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
 
            // node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);
 
            // Delete the inorder successor
            root.right = deleterec(root.right, root.data);
        }
 
        return root;
    }
    public int minValue(Node root)
    {
        int minv = root.data;
        while (root.left != null)
        {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        DeletionInBST bst = new DeletionInBST();
        while(true){
            System.out.println("Enter 1 if you want to insert more elements in the tree otherwise any number :");
            int choice = sc.nextInt();
            if(choice==1){
                int x = sc.nextInt();
                bst.insert(x);
            }else{
                break;
            }
        }
        bst.inOrder(root);
        System.out.println("Enter the element you want to delete in the BST:");
        int delItem = sc.nextInt();
        bst.delete(delItem);
        System.out.println("After Deleting the BST:");
        bst.inOrder(root);
    }
}
