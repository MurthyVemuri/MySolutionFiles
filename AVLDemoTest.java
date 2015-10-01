import java.util.*;


class Node {

	private Node left;
	private Node right;
	private int data;
	private int level;
	private int depth;

	public Node(int data) {
		this(data, null, null);
	}

	public Node(int data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
		if (left == null && right == null)
			setDepth(1);
		else if (left == null)
			setDepth(right.getDepth() + 1);
		else if (right == null)
			setDepth(left.getDepth() + 1);
		else
			setDepth(Math.max(left.getDepth(), right.getDepth()) + 1);
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String toString() {
		return level + " " + data;
	}

}



class AVLTree {

	Node root;

	public AVLTree() {
		root = null;
	}

	public Node insert(int data) {
		root = insert(root, data);
		return checkingBalancing(root);
	}

	private Node insert(Node node, int data) {
		if (node == null) {
			return new Node(data);
		}if (node.getData() < data) {
			node = new Node(node.getData(), node.getLeft(), insert(node.getRight(), data));
		}else if (node.getData() > data) {
			node = new Node(node.getData(), insert(node.getLeft(), data),node.getRight());
		}
		return checkingBalancing(node);
	}

	private Node checkingBalancing(Node node) {
		int check = balanceNumber(node);
		if(check == -1) {
			node = rotateRight(node);
		}else if(check == 1) {
			node = rotateLeft(node);
		}else {
			return node;
		}
		return node;
	}

	private int balanceNumber(Node node) {
		int lValue = depth(node.getLeft());
		int rValue = depth(node.getRight());
		if (lValue - rValue >= 2)
			return -1;
		else if (lValue - rValue <= -2)
			return 1;
		return 0;
	}

	private int depth(Node node) {
		if (node == null)
			return 0;
		return node.getDepth();
	}

	private Node rotateLeft(Node node) {
		Node temp = node;
		Node nodeRight = temp.getRight();
		Node nodeLeft = temp.getLeft();
		Node w = nodeRight.getLeft();
		Node x = nodeRight.getRight();
		temp = new Node(temp.getData(), nodeLeft, w);
		nodeRight = new Node(nodeRight.getData(), temp, x);
		return nodeRight;
	}

	private Node rotateRight(Node node) {
		Node temp = node;
		Node tempLeft = temp.getLeft();
		Node tempRight = temp.getRight();
		Node w = tempLeft.getLeft();
		Node x = tempLeft.getRight();
		temp = new Node(temp.getData(), x, tempRight);
		tempLeft = new Node(tempLeft.getData(), w, temp);
		return tempLeft;
	}

	public boolean search(int data) {
		Node local = root;
		while (local != null) {
			if (local.getData() > (data))
				local = local.getLeft();
			else if (local.getData() == data)
				return true;
			else
				local = local.getRight();
		}
		return false;
	}

	public void inorderPrinting() {
		inorderPrinting(root);
	}

	private void inorderPrinting(Node node) {
		if (node != null) {
			inorderPrinting(node.getLeft());
			System.out.print(node.getData() + " ");
			inorderPrinting(node.getRight());
		}
	}

	public void preorderPrinting() {
		preorderPrinting(root);
	}

	private void preorderPrinting(Node node) {
		if (node != null) {
			System.out.print(node.getData() +" ");
			preorderPrinting(node.getLeft());
			preorderPrinting(node.getRight());
		}
	}

	public void postorderPrinting() {
		postorderPrinting(root);
	}

	private void postorderPrinting(Node node) {
		if (node != null) {
			postorderPrinting(node.getLeft());
			postorderPrinting(node.getRight());
			System.out.print(node.getData() +" ");
		}
	} 

	public void printTree() {
		root.setLevel(0);
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			Node node = q.poll();
			System.out.println(node);
			int level = node.getLevel();
			Node left = node.getLeft();
			Node right = node.getRight();
			if (left != null) {
				left.setLevel(level + 1);
				q.add(left);
			}
			if (right != null) {
				right.setLevel(level + 1);
				q.add(right);
			}
		}
	}

	public String toString() {
		return root.toString();
	}
}


public class AVLDemoTest {

	public static void main(String[] args) {
		AVLTree trees = new AVLTree();
		trees.insert(9);
		trees.insert(8);
		trees.insert(7);
		trees.insert(6);
		trees.insert(5);
		trees.insert(4);
		trees.insert(3);
		trees.insert(2);
		// trees.insert(1);
		trees.printTree();
		trees.inorderPrinting();
	}

}
