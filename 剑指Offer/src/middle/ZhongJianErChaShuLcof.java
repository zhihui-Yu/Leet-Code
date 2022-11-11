package middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author simple
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * <p>
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 3
 * / \
 * 9  20
 * / \
 * 15  7
 *
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZhongJianErChaShuLcof {
    int[] preorder, inorder;
    Map<Integer, Integer> map = new HashMap<>();

    // 先序遍历第一个节点是根节点
    // 中序遍历以根节点区分左右树
    // 在左(右)树中递归找根节点
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder = preorder;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return tree(0, 0, inorder.length - 1);
    }

    /**
     * @param headIdx head index of preorder
     * @param left    left index of inorder
     * @param right   right index of inorder
     */
    private TreeNode tree(int headIdx, int left, int right) {
        if (left > right) return null;

        TreeNode head = new TreeNode(preorder[headIdx]);
        int idx = map.get(preorder[headIdx]);
        head.left = tree(headIdx + 1, left, idx - 1);
        head.right = tree(headIdx + idx - left + 1, idx + 1, right); // 右子树的根节点 = headIdx - 左子树数量 + 1
        return head;
    }

    public static void main(String[] args) {
        System.out.println(new ZhongJianErChaShuLcof().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
