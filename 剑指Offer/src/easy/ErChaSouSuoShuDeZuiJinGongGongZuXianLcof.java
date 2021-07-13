package easy;

/**
 * @author simple
 */
public class ErChaSouSuoShuDeZuiJinGongGongZuXianLcof {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val >= root.val && q.val <= root.val) return root;
        if (p.val <= root.val && q.val >= root.val) return root;
        if (p.val >= root.val) return lowestCommonAncestor(root.right, p, q);
        return lowestCommonAncestor(root.left, p, q);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
