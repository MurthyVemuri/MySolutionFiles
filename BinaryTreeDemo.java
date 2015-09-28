
 class Node<T> {

	  int value;
	  public Node<?> left;
	  public Node<?> right;

	public Node(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public Node getLeft() {
		return this.left;
	}

	public Node getRightt() {
		return this.right;
	}
}

class BinaryTree {

	public Node<?> root;

	public BinaryTree insert(int value) {
		Node<Object> node = new Node<Object>(value);
		
		if (root == null) {
			root = node;
			return this;
		}
		insertRec(root, node);
		return this;
	}


	private void insertRec(Node<?> newNode, Node<?> node) {

		if (newNode.getValue() > node.getValue()) {
			if (newNode.getLeft() == null) {
				newNode.left = node;
				return;
			} else {

				insertRec(newNode.left, node);
			}
		} else {
			if (newNode.right == null) {
				newNode.right = node;
				return;
			} else {
			insertRec(newNode.right, node);
			}
		}
	}



	public int findMinimum() {
		if (root == null) {
			return 0;
		}
		Node<?> currNode = root;
		while (currNode.left != null) {
			currNode = currNode.left;
		}

		return currNode.value;

	}

	public int findMaximum() {

		if (root == null) {
			return 0;
		}

		Node<?> currNode = root;
		while (currNode.right != null) {
			currNode = currNode.right;
		}
		return currNode.value;
	}

	public void printInorder() {
		printInOrderRec(root);
		System.out.println("");
	}

	private void printInOrderRec(Node<?> currRoot) {
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


	private void printPreOrderRec(Node<?> currRoot) {
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

	private void printPostOrderRec(Node<?> currRoot) {
		if (currRoot == null) {
			return;
		}
		printPostOrderRec(currRoot.left);
		printPostOrderRec(currRoot.right);
		System.out.print(currRoot.value + ", ");
	}
	

}

	 

public class BinaryTreeDemo {

	public static void main(String[] args) {

		BinaryTree bst = new BinaryTree();
		bst .insert(40);
		bst.insert(25);
		bst.insert(78);
		bst.insert(10);
		bst.insert(3);
		bst.insert(17);
		bst.insert(32);
		System.out.println("Inorder traversal");
		bst.printInorder();
		System.out.println("Preorder Traversal");
		bst.printPreorder();
		System.out.println("Postorder Traversal");
		bst.printPostorder();
		System.out.println("minimum value " + bst.findMinimum());
		System.out.println("maximum value " + bst.findMaximum());
	}
}
