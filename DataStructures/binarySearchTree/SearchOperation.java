import java.util.Scanner;
class Node{
    int data;
    Node left,right;
    public Node(int d){
        data = d;
        left = right = null;
    }
}
public class SearchOperation {
    public static Node root;
    // for traversing and printing data in inorder
    private void inOrder(Node node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }
    // for search operation
    private Node searchData(Node root, int key){
        if(root == null || root.data==key)
            return root;

        if(root.data<key)
            return searchData(root.right, key);
        
        return searchData(root.left, key);
    }
    // main function of insertion to call the recursive function
    private void insertMain(int key){
        root = insert(root,key);
    }
    // recursive insertion function
    private Node insert(Node root, int key){
        if(root == null){
            root = new Node(key);
            return root;
        }
        if(key<root.data){
            root.left = insert(root.left,key);
        }else if(key>root.data){
            root.right = insert(root.right,key);
        }
        return root;
    } 
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        SearchOperation bst = new SearchOperation();
        while(true){
            System.out.println("Enter 1 if you want to insert more elements in the tree otherwise any number :");
            int choice = sc.nextInt();
            if(choice==1){
                int x = sc.nextInt();
                bst.insertMain(x);
            }else{
                break;
            }
        }
        bst.inOrder(root);
        System.out.println("Enter the element you want to search in the BST if it exist we will return ture, else false:");
        int search = sc.nextInt();
        Node ans = bst.searchData(root,search);
        if(ans != null){
            System.out.println("Node exist in BST");
        }else{
            System.out.println("Node does not exist in BST");
        }
    }
}
