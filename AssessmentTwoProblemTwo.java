import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) { 
		val = x; 
	}

	public int getValue() {
		return this.val;
	}

	public TreeNode getRight() {
		return this.right;
	}

	public TreeNode getLeft() {
		return this.left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}
}

class Solution {

	private TreeNode root;

	public Solution() {
		root = null;
	}


	public TreeNode insert(int data) {
		TreeNode node = new TreeNode(data);
		if (root == null) {
			root = node;
		} else {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			while(!queue.isEmpty()) {
				TreeNode current = queue.poll();
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

	public void isValidBST() {
		boolean out = isValidBST(root);
		System.out.println(out);
	}

	public boolean isValidBST(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if(root == null) 
			return true;
		if(root.left == null && root.right == null) 
			return true;

		boolean left = isValidBSTHelper(root.left, null, root);
		boolean right = isValidBSTHelper(root.right, root, null);

		return left && right;
	}

	public boolean isValidBSTHelper(TreeNode root, TreeNode min, TreeNode max) {
		if(root == null) return true;

		if(root.left != null && root.val < root.left.val) {
			return false;
		}
		if(root.right != null && root.val >= root.right.val) {
			return false;
		}
		if(min != null && root.val <= min.val) {
			return false;
		}
		if(max != null && root.val >= max.val) {
			return false;
		}

		boolean left = isValidBSTHelper(root.left, min, root);
		boolean right = isValidBSTHelper(root.right, root, max);

		return left && right;
	}
}


public class AssessmentTwoProblemTwo {
	public static void main(String[] args) {
		
		Solution s = new Solution();
		Scanner scan = new Scanner(System.in);
		int size = (Integer.parseInt (scan.nextLine()) );
		String value = " ";
		for(int i = 1; i <= size; i++)
		value += scan.nextLine();
		try {
			StringTokenizer st = new StringTokenizer(value, " ");
			while (st.hasMoreTokens()) {
				String token = st.nextToken();
				if(!(token.equals("_") ) ) {
					s.insert(Integer.valueOf( token ) );
				}
			}
		}catch(Exception ex) {}

		s.isValidBST();
	}
}
