package hard.tree;

/**
 * 1373. 二叉搜索子树的最大键值和
 * 给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。
 * <p>
 * 二叉搜索树的定义如下：
 * <p>
 * 任意节点的左子树中的键值都 小于 此节点的键值。
 * 任意节点的右子树中的键值都 大于 此节点的键值。
 * 任意节点的左子树和右子树都是二叉搜索树。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
 * 输出：20
 * 解释：键值为 3 的子树是和最大的二叉搜索树。
 * 示例 2：
 * <p>
 * 输入：root = [4,3,null,1,2]
 * 输出：2
 * 解释：键值为 2 的单节点子树是和最大的二叉搜索树。
 * 示例 3：
 * <p>
 * 输入：root = [-4,-2,-5]
 * 输出：0
 * 解释：所有节点键值都为负数，和最大的二叉搜索树为空。
 * 示例 4：
 * <p>
 * 输入：root = [2,1,3]
 * 输出：6
 * 示例 5：
 * <p>
 * 输入：root = [5,4,8,3,null,6,3]
 * 输出：7
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每棵树有 1 到 40000 个节点。
 * 每个节点的键值在 [-4 * 10^4 , 4 * 10^4] 之间。
 *
 * @author simple
 */
public class MaximumSumBstInBinaryTree {
    int ans = 0;
    int[] noTree = new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE}; // 其父辈也无法是搜索二叉树
    int[] empty = new int[]{0, Integer.MIN_VALUE, Integer.MAX_VALUE};

    // 前提： 必须知道是否是搜索二叉树， 且求搜索二叉树节点和最大的值
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    // 返回子树的{所有节点值的和，最大值，最小值}
    private int[] dfs(TreeNode node) {
        if (node == null)
            return empty;

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int x = node.val;
        if (left[1] >= x || right[2] <= x)
            return noTree; // 不是搜索二叉树

        int sum = left[0] + right[0] + x;
        ans = Math.max(ans, sum);

        return new int[]{sum, Math.max(x, right[1]), Math.min(x, left[2])}; // 空节点返回时需要比较
    }

    public static void main(String[] args) {
        var node = new TreeNode(9,
            new TreeNode(2,
                null,
                new TreeNode(2,
                    new TreeNode(3,
                        new TreeNode(-5,
                            null, new TreeNode(1)
                        ),
                        new TreeNode(4,
                            null, new TreeNode(10)
                        )
                    ),
                    null
                )
            ),
            new TreeNode(3));
        System.out.println(new MaximumSumBstInBinaryTree().maxSumBST(node));
    }

    public static class TreeNode {
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
