package tree;

public class BinaryTree {
    public static void main(String[] args) {

    }

    public boolean IsBalanced(TreeNode root) {
        if (root == null) { //一棵空树就是平衡二叉树
            return true;
        }
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1) {
            //满足左右子树高度差小于等于1,那就接着判断左右子树是不是二叉树
            return (IsBalanced(root.left) && IsBalanced(root.right));
        } else {
            //不满足左右子树高度差小于等于1,那这棵树肯定不是平衡二叉树啦
            return false;
        }
    }

    public int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return (left > right ? left : right) + 1;//树的高度怎么计算就不用我讲了吧
    }
}
