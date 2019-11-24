public class BasicExercises9 {
	private BstNode root;

	public boolean isEmpty() {

		return (this.root == null);
	}

	public void insert(Integer data) {

		System.out.print("[input: " + data + "]");
		if (root == null) {
			this.root = new BstNode(data);
			System.out.println(" -> inserted: " + data);
			return;
		}

		insertNode(this.root, data);
		System.out.print(" -> inserted: " + data);
		System.out.println();
	}

	private BstNode insertNode(BstNode root, Integer data) {

		BstNode tmpNode = null;
		System.out.print(" ->" + root.getData());
		if (root.getData() >= data) {
			System.out.print(" [L]");
			if (root.getLeft() == null) {
				root.setLeft(new BstNode(data));
				return root.getLeft();
			} else {
				tmpNode = root.getLeft();
			}
		} else {
			System.out.print(" [R]");
			if (root.getRight() == null) {
				root.setRight(new BstNode(data));
				return root.getRight();
			} else {
				tmpNode = root.getRight();
			}
		}

		return insertNode(tmpNode, data);
	}

	public void inOrderTraversal() {
		doInOrder(this.root);
	}

	private void doInOrder(BstNode root) {

		if (root == null)
			return;
		doInOrder(root.getLeft());
		System.out.print(root.getData() + " ");
		doInOrder(root.getRight());
	}

	public void postorder() {
		postorderSubtree(this.root);
		System.out.println();
	}
	private void postorderSubtree(BstNode root) {
		if (root == null)
			return;
		postorderSubtree(root.getLeft());
		postorderSubtree(root.getRight());
		System.out.print(root.getData() + " ");
	}

	public void preorder() {
		preorderSubtree(this.root);
		System.out.println();
	}

	private void preorderSubtree(BstNode root) {
		if (root == null)
			return;
		System.out.print(root.getData() + " ");
		preorderSubtree(root.getLeft());
		preorderSubtree(root.getRight());
	}

	public static void main(String a[]) {

		BasicExercises9 bst = new BasicExercises9();
		bst.insert(2);
		bst.insert(7);
		bst.insert(9);
		bst.insert(4);
		bst.insert(1);
		bst.insert(5);
		bst.insert(3);
		bst.insert(6);
		bst.insert(6);
		bst.insert(0);
		bst.insert(8);
		System.out.println("-------------------");
		System.out.println("In order:");
		bst.inOrderTraversal();
		System.out.println(" ");
		System.out.println("Post order:");
		bst.postorder();
		System.out.println("Preorder:");
		bst.preorder();

	}
}
