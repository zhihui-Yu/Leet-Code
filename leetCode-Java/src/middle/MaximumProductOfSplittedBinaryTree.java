package middle;

/**
 * 1339. 分裂二叉树的最大乘积
 * 给你一棵二叉树，它的根为 root 。请你删除 1 条边，使二叉树分裂成两棵子树，且它们子树和的乘积尽可能大。
 * <p>
 * 由于答案可能会很大，请你将结果对 10^9 + 7 取模后再返回。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,4,5,6]
 * 输出：110
 * 解释：删除红色的边，得到 2 棵子树，和分别为 11 和 10 。它们的乘积是 110 （11*10）
 * <p>
 * 示例 2：
 * 输入：root = [1,null,2,3,4,null,null,5,6]
 * 输出：90
 * 解释：移除红色的边，得到 2 棵子树，和分别是 15 和 6 。它们的乘积为 90 （15*6）
 * <p>
 * 示例 3：
 * 输入：root = [2,3,9,10,7,8,6,5,4,11,1]
 * 输出：1025
 * 示例 4：
 * <p>
 * 输入：root = [1,1]
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 每棵树最多有 50000 个节点，且至少有 2 个节点。
 * 每个节点的值在 [1, 10000] 之间。
 *
 * @author simple
 */
public class MaximumProductOfSplittedBinaryTree {
    private int mod = 1_000_000_007;
    private long ans = 0;

    public int maxProduct(TreeNode root) {
        // 计算总的
        int total = dfs1(root);
        // 计算每次截支后的积
        dfs2(root, total);
        // 最后一步才做mod，因为有可能数值大的mod后比没mod的数值小
        return (int) (ans % mod);
    }

    // 返回子树的和
    private int dfs2(TreeNode root, int total) {
        if (root == null) return 0;
        int v = root.val + dfs2(root.right, total) + dfs2(root.left, total);
        ans = Math.max(ans, (long) v * (total - v));
        return v;
    }

    private int dfs1(TreeNode root) {
        if (root == null) return 0;
        return dfs1(root.left) + dfs1(root.right) + root.val;
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
