package tree;

public class BinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.insert(4);
        root.insert(12);
        TreeNode.display(root);
    }
}
