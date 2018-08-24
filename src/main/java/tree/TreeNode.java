package tree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public void insert(int key) {
        if (search(key) != null) {
            System.out.println("already has key");
            return;
        }
        TreeNode node = new TreeNode(key);
        TreeNode current = this;
        TreeNode parent;
        while (true) {
            parent = current;
            if (key < current.val) {
                current = current.left;
                if (current == null) {
                    parent.left = node;
                    System.out.println("insert " + node.val);
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = node;
                    System.out.println("insert " + node.val);
                    return;
                }
            }
        }
    }

    public TreeNode search(int key) {
        TreeNode node = this;
        while (key != node.val) {
            if (key < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
            if (node == null) {
                return null;
            }
        }
        return node;
    }

    public static void display(TreeNode node) {
        if (node != null) {
            display(node.left);
            System.out.println(node.val);
            display(node.right);
        }
    }
}
