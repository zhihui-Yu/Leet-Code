package easy;

import java.util.Arrays;

/**
 * @author simple
 * <p>
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 * <p>
 * 示例:
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
 * 链接：https://leetcode-cn.com/problems/minimum-height-tree-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumHeightTreeLcci {
    // copyOfRange 速度慢很多
    public TreeNode sortedArrayToBSTV1(int[] nums) {
        if (nums.length < 1) return null;
        TreeNode root = new TreeNode(nums[nums.length / 2]);
        if (nums.length / 2 > 0)
            root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length / 2));
        if (nums.length / 2 < nums.length)
            root.right = sortedArrayToBST(Arrays.copyOfRange(nums, (nums.length / 2) + 1, nums.length));
        return root;
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    public TreeNode buildBST(int[] arr, int left, int end) {
        if (left > end) {
            return null;
        }
        int mid = (left + end) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = buildBST(arr, left, mid - 1);
        root.right = buildBST(arr, mid + 1, end);
        return root;
    }

    //Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

