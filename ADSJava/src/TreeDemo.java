// Module 12 problem 1:Inserting, printing in pre,post and In order. 

class NodeBT {

	  public int value;
	  public NodeBT left;
	  public NodeBT right;

	public NodeBT(int value) {
		this.value = value;
	}
}

class BinaryTreeTest {

	public NodeBT root;

	BinaryTreeTest() {
		root = null;
	}

	public void insert(int data) {
		root = insertData(root, data);
	}


	private NodeBT insertData(NodeBT node, int data) {
		if (node == null)
			node = new NodeBT(data);
		else {
			if (node.right == null)
				node.right = insertData(node.right, data);
			else
				node.left = insertData(node.left, data);
		}

		return node;
	} 

	public void printInorder() {
		printInOrderRec(root);
		System.out.println("");
	}

	private void printInOrderRec(NodeBT currRoot) {
		if (currRoot == null) {
			return;
		}
		printInOrderRec(currRoot.left);
		System.out.print(currRoot.value + ", ");
		printInOrderRec(currRoot.right);
	}

	 public void printPreorder() {
	 	printPreOrderRec(root);
	 	System.out.println("");
	 }


	 private void printPreOrderRec(NodeBT currRoot) {
	 	if (currRoot == null) {
	 		return;
	 	}
	 	System.out.print(currRoot.value + ", ");
	 	printPreOrderRec(currRoot.left);
	 	printPreOrderRec(currRoot.right);
	 }


	 public void printPostorder() {
	 	printPostOrderRec(root);
	 	System.out.println("");
	 }

	 private void printPostOrderRec(NodeBT currRoot) {
	 	if (currRoot == null) {
	 		return;
	 	}
	 	printPostOrderRec(currRoot.left);
	 	printPostOrderRec(currRoot.right);
	 	System.out.print(currRoot.value + ", ");
	 }

}

	 

public class TreeDemo {

	public static void main(String[] args) {

		BinaryTreeTest bst = new BinaryTreeTest();
		bst.insert(6);
		bst.insert(4);
		bst.insert(10);
		bst.insert(2);
		bst.insert(5);
		bst.insert(7);
		bst.insert(11);
		bst.insert(1);
		bst.insert(3);
		bst.insert(9);
		bst.insert(8);
		System.out.println("Inorder traversal");
		bst.printInorder();
		System.out.println("Preorder Traversal");
		bst.printPreorder();
		System.out.println("Postorder Traversal");
		bst.printPostorder();
	}
}
