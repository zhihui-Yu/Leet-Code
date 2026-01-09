package middle;

/**
 * 865. 具有所有最深节点的最小子树
 * 给定一个根为 root 的二叉树，每个节点的深度是 该节点到根的最短距离 。
 * <p>
 * 返回包含原始树中所有 最深节点 的 最小子树 。
 * <p>
 * 如果一个节点在 整个树 的任意节点之间具有最大的深度，则该节点是 最深的 。
 * <p>
 * 一个节点的 子树 是该节点加上它的所有后代的集合。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 3
 * / \
 * 5   1
 * / \ / \
 * 6  2 0  8
 * / \
 * 7   4
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4]
 * 输出：[2,7,4]
 * 解释：
 * 我们返回值为 2 的节点，在图中用黄色标记。
 * 在图中用蓝色标记的是树的最深的节点。
 * 注意，节点 5、3 和 2 包含树中最深的节点，但节点 2 的子树最小，因此我们返回它。
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * 解释：根节点是树中最深的节点。
 * 示例 3：
 * <p>
 * 输入：root = [0,1,3,null,2]
 * 输出：[2]
 * 解释：树中最深的节点为 2 ，有效子树为节点 2、1 和 0 的子树，但节点 2 的子树最小。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数量在 [1, 500] 范围内。
 * 0 <= Node.val <= 500
 * 每个节点的值都是 独一无二 的。
 *
 * @author simple
 */
public class SmallestSubtreeWithAllTheDeepestNodes {
    int maxDeep = -1;
    TreeNode ans = null;

    // 包含所有最深节点的子树，即如果最深节点只有一个，返回那个，如果有两个，则返回上一层的公共祖先
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private int dfs(TreeNode root, int deep) {
        if (root == null) {
            maxDeep = Math.max(maxDeep, deep);
            return deep;
        }

        int left = dfs(root.left, deep + 1);
        int right = dfs(root.right, deep + 1);

        if (left == right && left == maxDeep) {
            ans = root;
        }
        return Math.max(left, right);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
