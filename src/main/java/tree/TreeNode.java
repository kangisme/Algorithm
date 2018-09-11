package tree;

import java.util.LinkedList;
import java.util.Queue;

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

    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return (right > left ? right : left) + 1;
    }


    /**
     * 求二叉树的镜像
     */
    public static void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.right);
        mirror(root.left);
    }

    /**
     * 判断两棵树的结构是否相同
     */
    public static boolean isSame(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        }
        return isSame(node1.left, node2.left) && isSame(node1.right, node2.right);
    }

    /**
     * 获取二叉树k层的节点个数
     */
    public static int getLevel(TreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getLevel(root.left, k - 1) + getLevel(root.right, k - 1);
    }

    /**
     * 获取叶子节点个数
     */
    public static int getChildNum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getChildNum(root.left);
        int right = getChildNum(root.right);
        if (left == 0 && right == 0) {
            return 1;
        } else {
            return left + right;
        }
    }

    /**
     * 节点个数
     */
    public static int getNum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getNum(root.left);
        int right = getNum(root.right);
        return left + right + 1;
    }

    /**
     * 最低公共祖先，即LCA(Lowest Common Ancestor）
     */
    public static TreeNode findLCA(TreeNode root, TreeNode target1, TreeNode target2) {
        if (root == null) {
            return null;
        }
        if (root == target1 || root == target2) {
            return root;
        }
        TreeNode left = findLCA(root.left, target1, target2);
        TreeNode right = findLCA(root.right, target1, target2);
        if ((left == null) && (right == null)) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }

    /**
     * 求任意两节点距离
     * 首先找到两个节点的LCA，然后分别计算LCA与它们的距离，最后相加即可
     */
    public static int distance(TreeNode root, TreeNode target1, TreeNode target2) {
        TreeNode lca = findLCA(root, target1, target2);
        int level1 = findLevel(lca, target1);
        int level2 = findLevel(lca, target2);
        return level1 + level2;
    }

    private static int findLevel(TreeNode lca, TreeNode target) {
        if (lca == null) {
            return -1;
        }
        if (lca == target) {
            return 0;
        }
        //先在左子树找
        int level = findLevel(lca.left, target);
        if (level == -1) {
            //如果左子树没找到，在右子树找
            level = findLevel(lca.right, target);
        }
        if (level != -1) {
            //找到了，回溯
            return level + 1;
        }
        //如果左右子树都没找到
        return -1;
    }

    public static boolean findAllAncestors(TreeNode root, TreeNode target) {
        if (root == null) {
            return false;
        }
        if (root == target) {
            return true;
        }
        if (findAllAncestors(root.left, target) || findAllAncestors(root.right, target)) {
            System.out.println(root.val);
            return true;
        }
        //如果左右子树都没找到
        return false;
    }

    /**
     * 二叉树遍历，中序
     * 前序，后序语句顺序换下就可以了
     */
    public static void display(TreeNode node) {
        if (node != null) {
            display(node.left);
            System.out.println(node.val);
            display(node.right);
        }
    }

    /**
     * 层序遍历
     */
    public static void displayLayer(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            System.out.println(current.val);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static void displayMorris(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            if (cur.left == null) {
                System.out.println(cur.val);
                cur = cur.right;
            } else {
                pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    System.out.println(cur.val);
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
    }

    public static int findLongest(TreeNode root) {
        int[] depth = new int[1];
        return getMaxDistance(root, depth);
    }

    //递归获取两个值：一个是子树的最大深度，一个是子树的结点间最大距离。
    //其中，子树最大深度通过一个数组传引用的方式获取结果；子树的最大结点间距离则由递归函数的返回值返回
    private static int getMaxDistance(TreeNode node, int[] depth) {
        if (node == null) {
            depth[0] = 0;
            return 0;
        }
        int left = getMaxDistance(node.left, depth);
        //通过数组获取左子树递归过程中统计出的子树深度
        int left_depth = depth[0];
        int right = getMaxDistance(node.right, depth);
        //通过数组获取右子树递归过程中统计出的子树深度
        int right_depth = depth[0];
        //通过数组记录当前结点的高度
        depth[0] = (left_depth > right_depth ? left_depth : right_depth) + 1;
        //比较左子树最大结点距离、右子树最大结点距离、经过当前结点到达左右子树最深结点的路径距离，最大者就是当前结点为根的树的最大结点距离
        return Math.max(Math.max(left, right), left_depth + right_depth);
    }

    @Override
    public String toString() {
        return val + "";
    }
}
