package middle.tree;

import java.util.TreeSet;

/**
 * 1026. 节点与其祖先之间的最大差值
 * 给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * 输出：7
 * 解释：
 * 我们有大量的节点与其祖先的差值，其中一些如下：
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * 在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
 * <p>
 * 示例 2：
 * 输入：root = [1,null,2,null,0,3]
 * 输出：3
 * <p>
 * 提示：
 * <p>
 * 树中的节点数在 2 到 5000 之间。
 * 0 <= Node.val <= 105
 *
 * @author simple
 */
public class MaximumDifferenceBetweenNodeAndAncestor {
    public int maxAncestorDiff(TreeNode root) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(root.val);
        return Math.max(f(set, root.left), f(set, root.right));
    }

    private int f(TreeSet<Integer> parents, TreeNode head) {
        if (head == null) return 0;

        int cnt = 0;
        cnt = Math.max(cnt, Math.abs(parents.first() - head.val));
        cnt = Math.max(cnt, Math.abs(parents.last() - head.val));

        boolean add = parents.add(head.val);

        int left = 0, right = 0;
        if (head.left != null) left = f(parents, head.left);
        if (head.right != null) right = f(parents, head.right);

        if (add) {
            parents.remove(head.val);
        }
        return Math.max(cnt, Math.max(left, right));
    }

    // 只维护最大值节点和最小值节点
    private int dfs(int ans, int max, int min, TreeNode cur) {
        // main: return dfs(0,root.val,root.val,root);

        if (cur == null) return 0;
        max = Math.max(cur.val, max);
        min = Math.min(cur.val, min);
        ans = Math.max(ans, max - min);
        return Math.max(ans, Math.max(dfs(ans, max, min, cur.left), dfs(ans, max, min, cur.right)));
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(8,
            new TreeNode(3,
                new TreeNode(1),
                new TreeNode(6,
                    new TreeNode(4),
                    new TreeNode(7)
                )
            ),
            new TreeNode(10,
                null,
                new TreeNode(14,
                    new TreeNode(13), null
                )
            )
        );

        System.out.println(new MaximumDifferenceBetweenNodeAndAncestor().maxAncestorDiff(node));
    }

    static class TreeNode {
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
