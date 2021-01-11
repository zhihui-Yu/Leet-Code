package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author simple
 *
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        // 先序遍历 + 组装
        List<TreeNode> values = xianXu(root);
        for (int i = 1; i < values.size(); i++) {
            TreeNode pre = values.get(i - 1);
            TreeNode cur = values.get(i);
            pre.right = cur;
            pre.left = null;
        }
    }

    private List<TreeNode> xianXu(TreeNode node) {
        if (node == null) return List.of();
        List<TreeNode> res = new ArrayList<>();
        res.add(node);
        res.addAll(xianXu(node.left));
        res.addAll(xianXu(node.right));
        return res;
    }

    public static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
}
