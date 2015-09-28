// Binary search trees implementation.

import java.util.*;
class Node {

	  private int value;
	  private Node left;
	  private Node right;

	public Node(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public Node getRight() {
		return this.right;
	}

	public Node getLeft() {
		return this.left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public void setRight(Node right) {
		this.right = right;
	}
}

class BinarySearchTree {

	public Node root;
	public int count = 0;

	public BinarySearchTree insertValue(int value) {
		Node node = new Node(value);
		
		if (root == null) {
			root = node;
			return this;
		}
		insertPerfectly(root , node);
		return this;
	}


	private void insertPerfectly(Node newRoot , Node node) {

		if (newRoot.getValue() > node.getValue()) {
			if (newRoot.getLeft() == null) {
				newRoot.setLeft(node);
				return;
			} else {
				insertPerfectly(newRoot.getLeft() , node);
			}
		} else {
			if (newRoot.getRight() == null) {
				newRoot.setRight(node);
				return;
			} else {
				insertPerfectly(newRoot.getRight() , node);
			}
		}
	}

	public void delete(int value) {
		root = delete(root, value);
	}

	private Node delete(Node root, int k) {
		Node temp, ref, n;
		if (root.getValue() == k) {
			if (root.getLeft() == null && root.getRight() == null)
				return null;
			else if (root.getLeft() == null) {
				temp = root.getRight();
				return temp;
			}
			else if (root.getRight() == null) {
				temp = root.getLeft();;
				return temp;
			}
			else {
				ref = root.getRight();
				temp = root.getRight();
				while (temp.getLeft() != null)
					temp = temp.getLeft();
				temp.setLeft(root.getLeft());
				return ref;
			}
		}
		if (k < root.getValue()) {
			n = delete(root.getLeft(), k);
			root.setLeft(n);
		} else {
			n = delete(root.getRight(), k);
			root.setRight(n);             
		}
		return root;
	}


	public boolean searchValue(int val) {
		count = 0;
		return searchValue(root, val);
	}

	private boolean searchValue(Node newNode, int val) {
		boolean found = false;
		while ((newNode != null) && !found) {
			count++;
			if (val < newNode.getValue()){
				newNode = newNode.getLeft();
			} else if (val > newNode.getValue()) {
				newNode = newNode.getRight();
			}else{
				found = true;
				break;
			}
			found = searchValue(newNode, val);
		}
		return found;
	}

	public void printPostorderValues() {
		
		printPostOrder(root);
		System.out.println();
	}

	private void printPostOrder(Node currRoot) {
		
		if (currRoot == null) {
			return;
		}

		printPostOrder(currRoot.getLeft());
		printPostOrder(currRoot.getRight());
		System.out.print(currRoot.getValue() + ",");
	}

	public void printInorderValues() {
		
		printInOrder(root);
		System.out.println();
	}


	private void printInOrder(Node currRoot) {
		
		if (currRoot == null) {
			return;
		}

		printInOrder(currRoot.getLeft());
		System.out.print(currRoot.getValue());
		System.out.print(",");
		printInOrder(currRoot.getRight());
	
	}
}

	 

public class BinarySearchTreeDemoTest {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		Scanner scan = new Scanner(System.in);
		String output = scan.nextLine();	
		String[] function = output.split(",");
		for (int i = 0; i < function.length;i++) {
			if(function[i].contains("I")){
				String[] val = function[i].split(" ");
				tree.insertValue(Integer.valueOf(val[1]));
				tree.printInorderValues();
			}else if(function[i].contains("R")) {
				String[] rval = function[i].split(" ");
				tree.delete(Integer.valueOf(rval[1]));
				tree.printPostorderValues();
			}else if(function[i].contains("S")) {
				String[] sval = function[i].split(" ");
				System.out.println(tree.searchValue(Integer.valueOf(sval[1])) + "," + tree.count );
			}else{
				break;
			}
		}
	}
}
