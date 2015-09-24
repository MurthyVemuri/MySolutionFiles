import java.util.*;

class Node {

	  public String value;
	  public Node left;
	  public Node right;

	public Node(String value) {
		this.value = value;
	}

	public String getValue() {
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

class SimpleBinaryTree {

	private Node root;

	public SimpleBinaryTree() {
		root = null;
	}


	public Node insert(String data) {
		Node node = new Node(data);
		if (root == null) {
			root = node;
		} else {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			while(!queue.isEmpty()) {
				Node current = queue.poll();
				if (current.getLeft() == null) {
					current.setLeft(node);
					queue.clear();
				} else if (current.getRight() == null) {
					current.setRight(node);
					queue.clear();
				} else {
					queue.add(current.getLeft());
					queue.add(current.getRight());
				}
			}
		}
		return node;
	}

	public void inorderPrinting() {
		inorderPrinting(root);
	}

	private void inorderPrinting(Node r) {
		if (r != null) {
			inorderPrinting(r.getLeft());
			System.out.print(r.getValue() + " ");
			inorderPrinting(r.getRight());
		}
	}

	public void preorderPrinting() {
		preorderPrinting(root);
	}

	private void preorderPrinting(Node r) {
		if (r != null) {
			System.out.print(r.getValue() +" ");
			preorderPrinting(r.getLeft());
			preorderPrinting(r.getRight());
		}
	}

	public void postorderPrinting() {
		postorderPrinting(root);
	}

	private void postorderPrinting(Node r) {
		if (r != null) {
			postorderPrinting(r.getLeft());
			postorderPrinting(r.getRight());
			System.out.print(r.getValue() +" ");
		}
	}  


	public void levelOrderPrinting() {
		levelOrderPrinting(root);
	}

	public void levelOrderPrinting(Node r){
		Queue<Node> level = new LinkedList<Node>();
		level.add(r);

		while(!level.isEmpty()){
			Node node = level.poll();
			System.out.print(node.getValue() + " ");
			if(node.getLeft()!= null)
				level.add(node.getLeft());
			if(node.getRight()!= null)
				level.add(node.getRight());
		}
	}

	// public int getMin() {
	// 	if (root == null) {
	// 		return 0;
	// 	}

	// 	Node currNode = root;
	// 	while (currNode.getLeft() != null) {
	// 		currNode = currNode.getLeft();
	// 	}
	// 	return currNode.getValue();

	// }

	// public int getMax() {

	// 	if (root == null) {
	// 		return 0;
	// 	}

	// 	Node currNode = root;
	// 	while (currNode.getRight()!= null) {
	// 		currNode = currNode.getRight();
	// 	}
	// 	return currNode.getValue();

	// }

	public int maxDepthTree() {
		return(maxDepthTree(root));
	}

	private int maxDepthTree(Node node) {
		if (node==null) {
			return(0);
		} else {
			int lDepth = maxDepthTree(node.getLeft());
			int rDepth = maxDepthTree(node.getRight());
			int depth = (Math.max(lDepth, rDepth) + 1);
			return depth;
		}
	}

}
public class BinaryTreeDepthProblem {
	public static void main(String[] args) {
		SimpleBinaryTree sbt = new SimpleBinaryTree();
		Scanner scan = new Scanner(System.in);
		String value = scan.nextLine();
		StringTokenizer st = new StringTokenizer(value, " ");
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			if(token.equals("#") ) {
				sbt.insert(null);
			}else {
				sbt.insert( token );
			}
		}

		int depth = sbt.maxDepthTree();
		if(depth - 1 == 0) {
			System.out.println(0);
		}else
		System.out.println(depth - 1);
	}
}

/*
import java.util.*;

class Node {

	  public int value;
	  public Node left;
	  public Node right;

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

class SimpleBinaryTree {

	private Node root;

	public SimpleBinaryTree() {
		root = null;
	}


	public Node insert(int data) {
        Node node = new Node(data);
        if (root == null) {
            root = node;
        } else {
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);
            while(!queue.isEmpty()) {
                Node current = queue.poll();
                if (current.getLeft() == null) {
                    current.setLeft(node);
                    queue.clear();
                } else if (current.getRight() == null) {
                    current.setRight(node);
                    queue.clear();
                } else {
                    queue.add(current.getLeft());
                    queue.add(current.getRight());
                }
            }
        }
        return node;
    }

	public void inorderPrinting() {
		inorderPrinting(root);
	}

	private void inorderPrinting(Node r) {
		if (r != null) {
			inorderPrinting(r.getLeft());
			System.out.print(r.getValue() + " ");
			inorderPrinting(r.getRight());
		}
	}

	public void preorderPrinting() {
		preorderPrinting(root);
	}

	private void preorderPrinting(Node r) {
		if (r != null) {
			System.out.print(r.getValue() +" ");
			preorderPrinting(r.getLeft());
			preorderPrinting(r.getRight());
		}
	}

	public void postorderPrinting() {
		postorderPrinting(root);
	}

	private void postorderPrinting(Node r) {
		if (r != null) {
			postorderPrinting(r.getLeft());
			postorderPrinting(r.getRight());
			System.out.print(r.getValue() +" ");
		}
	}  


	public void levelOrderPrinting() {
		levelOrderPrinting(root);
	}

	public void levelOrderPrinting(Node r){
		Queue<Node> level = new LinkedList<Node>();
		level.add(r);

		while(!level.isEmpty()){
			Node node = level.poll();
			System.out.print(node.getValue() + " ");
			if(node.getLeft()!= null)
				level.add(node.getLeft());
			if(node.getRight()!= null)
				level.add(node.getRight());
		}
	}

	public int getMin() {
		if (root == null) {
			return 0;
		}

		Node currNode = root;
		while (currNode.getLeft() != null) {
			currNode = currNode.getLeft();
		}
		return currNode.getValue();

	}

	public int getMax() {

		if (root == null) {
			return 0;
		}

		Node currNode = root;
		while (currNode.getRight()!= null) {
			currNode = currNode.getRight();
		}
		return currNode.getValue();

	}

	public int maxDepthTree() {
		return(maxDepthTree(root));
	}

	private int maxDepthTree(Node node) {
		if (node==null) {
			return(0);
		} else {
			int lDepth = maxDepthTree(node.getLeft());
			int rDepth = maxDepthTree(node.getRight());
			int depth = (Math.max(lDepth, rDepth) + 1);
			return depth;
		}
	}

}
public class BinaryTreeDepthProblem {
	public static void main(String[] args) {
		SimpleBinaryTree sbt = new SimpleBinaryTree();
		Scanner scan = new Scanner(System.in);
		String value = scan.nextLine();
		StringTokenizer st = new StringTokenizer(value, " ");
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			if(token.equals("#") ) {
				sbt.insert(99);
			}else {
				sbt.insert( Integer.parseInt(token) );
			}
		}

		int depth = sbt.maxDepthTree();
		if(depth - 1 == 0) {
			System.out.println(0);
		}else
		System.out.println(depth - 1);
	}
}
*/
