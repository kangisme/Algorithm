package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 打印二叉树左视图
 */
public class ThreePrints {
    public static void printLeft(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode last = root;
        TreeNode nLast = root;
        boolean flag = true;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (flag) {
                System.out.println(node);
                flag = false;
            }
            if (node.left != null) {
                queue.offer(node.left);
                nLast = node.left;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nLast = node.right;
            }
            if (last == node) {
                flag = true;
                last = nLast;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.insert(6);
        root.insert(14);
        root.insert(4);
        root.insert(1);
        root.insert(5);
        root.insert(13);
        root.insert(12);
        root.insert(11);
        printLeft(root);
    }
}
