package tree;

/**
 * 判断二叉树是否平衡二叉树
 */
public class BinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.insert(8);
        root.insert(7);
        root.insert(9);
        // 加上11就是平衡二叉树
        root.insert(11);
        TreeNode.displayLayer(root);
        if (isBalance(root)) {
            System.out.println("isBalanced");
        }
    }

    /**
     * 优化后只对这棵树进行了一遍后序遍历，所以这个时间复杂度也就是O（N）
     * @param root
     * @return
     */
    public static boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        }
        int[] depth = new int[1];
        return isBal(root, depth);
    }

    public static boolean isBal(TreeNode node, int[] depth) {
        if (node == null) {
            depth[0] = 0;
            return true;
        }
        int[] right = new int[1];
        int[] left = new int[1];
        if (isBal(node.right, right) && isBal(node.left, left)) {
            if (Math.abs(left[0] - right[0]) < 2) {
                depth[0] = 1 + (right[0] > left[0] ? right[0] : left[0]);
                return true;
            }
        }
        return false;
    }

    /**
     * 会发生对多个节点进行重复遍历的问题。复杂度就是O（N^2）
     */
    public static boolean isBalanced(TreeNode root) {
        if (root == null) { //一棵空树就是平衡二叉树
            return true;
        }
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1) {
            //满足左右子树高度差小于等于1,那就接着判断左右子树是不是二叉树
            return (isBalanced(root.left) && isBalanced(root.right));
        } else {
            //不满足左右子树高度差小于等于1,那这棵树肯定不是平衡二叉树啦
            return false;
        }
    }

    public static int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return (left > right ? left : right) + 1;//树的高度怎么计算就不用我讲了吧
    }
}
