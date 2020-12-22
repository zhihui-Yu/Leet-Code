package easy;

import java.util.Arrays;

/**
 * @author simple
 * <p>
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        int mid = nums.length / 2;
        if (mid == 0) return new TreeNode(nums[0]);

        int rootNum = nums[mid];
        TreeNode root = new TreeNode(rootNum);
        // lambda 极大的降低效率
        root.right = sortedArrayToBST(Arrays.stream(nums).skip(mid + 1).toArray());
        root.left = sortedArrayToBST(Arrays.stream(nums).limit(mid).toArray());
        return root;


    }

//     官方解法二

//    public TreeNode sortedArrayToBST(int[] nums) {
//        return helper(nums, 0, nums.length - 1);
//    }
//
//    public TreeNode helper(int[] nums, int left, int right) {
//        if (left > right) {
//            return null;
//        }
//
//        // 总是选择中间位置右边的数字作为根节点
//        int mid = (left + right + 1) / 2;
//
//        TreeNode root = new TreeNode(nums[mid]);
//        root.left = helper(nums, left, mid - 1);
//        root.right = helper(nums, mid + 1, right);
//        return root;
//    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        new ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }
}
