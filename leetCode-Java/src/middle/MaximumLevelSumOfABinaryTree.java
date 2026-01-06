package middle;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 1161. 最大层内元素和
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * <p>
 * 返回总和 最大 的那一层的层号 x。如果有多层的总和一样大，返回其中 最小 的层号 x。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 * 示例 2：
 * <p>
 * 输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数在 [1, 10^4]范围内
 * -10^5 <= Node.val <= 10^5
 *
 * @author simple
 */
public class MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        Map<Integer, Integer> level = new HashMap<>();
        level.put(0, root.val);
        nextLevel(root, level, 1);

        return level.entrySet().stream().sorted(((o1, o2) -> {
            if (Objects.equals(o1.getValue(), o2.getValue()))
                return o1.getKey() - o2.getKey();
            return o2.getValue() - o1.getValue();
        })).findAny().get().getKey() + 1;
    }

    private void nextLevel(TreeNode root, Map<Integer, Integer> level, int l) {
        if (root.left != null) {
            level.compute(l, (k, v) -> v == null ? root.left.val : v + root.left.val);
            nextLevel(root.left, level, l + 1);
        }
        if (root.right != null) {
            level.compute(l, (k, v) -> v == null ? root.right.val : v + root.right.val);
            nextLevel(root.right, level, l + 1);
        }
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
