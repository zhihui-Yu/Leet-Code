package middle.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 1110. 删点成林
 * 给出二叉树的根节点 root，树上每个节点都有一个不同的值。
 * <p>
 * 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 * <p>
 * 返回森林中的每棵树。你可以按任意顺序组织答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * 输出：[[1,2,null,4],[6],[7]]
 * 示例 2：
 * <p>
 * 输入：root = [1,2,4,null,3], to_delete = [3]
 * 输出：[[1,2,4]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数最大为 1000。
 * 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。
 * to_delete.length <= 1000
 * to_delete 包含一些从 1 到 1000、各不相同的值。
 *
 * @author simple
 */
public class DeleteNodesAndReturnForest {
    List<TreeNode> res = new LinkedList<>();
    int[] delete = new int[1001];

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (to_delete != null) {
            for (var j : to_delete)
                delete[j] = 1;
        }
        del(root, true);
        return res;
    }

    // 如果是需要被删除，则继续遍历其左右节点，但是将删除节点置位空
    // 如果不需要被删除且没有父节点，则将当前节点放入结果数组
    public void del(TreeNode root, boolean parentDel) {
        if (root == null) return;

        // 判断自身是否被删除
        var del = delete[root.val] == 1;
        // 如果自身没有被删除，且父类被删除，则保存该node
        if (!del && parentDel) {
            res.add(root);
        }

        // 判断子树是否被删除，被删除则遍历被删除的树的左右子树
        if (root.left != null && delete[root.left.val] == 1) {
            del(root.left.left, true);
            del(root.left.right, true);
            root.left = null;
        }
        if (root.right != null && delete[root.right.val] == 1) {
            del(root.right.left, true);
            del(root.right.right, true);
            root.right = null;
        }

        del(root.left, del);
        del(root.right, del);
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
