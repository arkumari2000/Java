class Node{
	int key;
	Node left, right;
	
	public Node(int d) {
		key = d;
		left=right=null;
	}
}

public class traverseBinaryTree {
    static Node root;
    traverseBinaryTree(){
    	root = null;
    }
    
    public void preOrder(Node node) {
    	if(node==null)
    		return;
    	System.out.print(node.key+" ");
    	preOrder(node.left);
    	preOrder(node.right);
    }
    
    public void inOrder(Node node) {
    	if(node==null)
    		return;
    	inOrder(node.left);
    	System.out.print(node.key+" ");
    	inOrder(node.right);
    }
    
    public void postOrder(Node node) {
    	if(node==null)
    		return;
    	postOrder(node.left);
    	postOrder(node.right);
    	System.out.print(node.key+" ");
    	
    }
  
    public static void main(String[] args) {
		traverseBinaryTree tree = new traverseBinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(5);
		tree.root.right = new Node(6);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(7);
		tree.root.right.left = new Node(8);
		tree.root.right.right = new Node(3);
		
		System.out.println("Printing tree in preorder:");
		tree.preOrder(root);
		
		System.out.println("\n Printing tree in inorder:");
		tree.inOrder(root);
		
		System.out.println("\n Printing tree in postorder:");
		tree.postOrder(root);
	}
 
}
