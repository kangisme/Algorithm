package tree;

public class BinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.insert(4);
        root.insert(12);
        root.insert(14);
        root.insert(1);
        root.insert(6);
        root.insert(22);
//        TreeNode.display(root);
//        TreeNode.displayLayer(root);
//        System.out.println("节点个数：" + TreeNode.getNum(root));
//        System.out.println("叶子节点个数：" + TreeNode.getChildNum(root));
//        System.out.println("深度：" + TreeNode.getDepth(root));
        TreeNode.displayMorris(root);

        System.out.println("节点最大距离：" + TreeNode.findLongest(root));
    }
}
