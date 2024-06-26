package easy.array;

/**
 * 2908. 元素和最小的山形三元组 I
 * 给你一个下标从 0 开始的整数数组 nums 。
 * 如果下标三元组 (i, j, k) 满足下述全部条件，则认为它是一个 山形三元组 ：
 * i < j < k
 * nums[i] < nums[j] 且 nums[k] < nums[j]
 * 请你找出 nums 中 元素和最小 的山形三元组，并返回其 元素和 。如果不存在满足条件的三元组，返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [8,6,1,5,3]
 * 输出：9
 * 解释：三元组 (2, 3, 4) 是一个元素和等于 9 的山形三元组，因为：
 * - 2 < 3 < 4
 * - nums[2] < nums[3] 且 nums[4] < nums[3]
 * 这个三元组的元素和等于 nums[2] + nums[3] + nums[4] = 9 。可以证明不存在元素和小于 9 的山形三元组。
 * 示例 2：
 * <p>
 * 输入：nums = [5,4,8,7,10,2]
 * 输出：13
 * 解释：三元组 (1, 3, 5) 是一个元素和等于 13 的山形三元组，因为：
 * - 1 < 3 < 5
 * - nums[1] < nums[3] 且 nums[5] < nums[3]
 * 这个三元组的元素和等于 nums[1] + nums[3] + nums[5] = 13 。可以证明不存在元素和小于 13 的山形三元组。
 * 示例 3：
 * <p>
 * 输入：nums = [6,5,4,3,4,5]
 * 输出：-1
 * 解释：可以证明 nums 中不存在山形三元组。
 * <p>
 * <p>
 * 提示：
 * 3 <= nums.length <= 50
 * 1 <= nums[i] <= 50
 *
 * @author simple
 */
public class MinimumSumOfMountainTripletsI {
    public int minimumSum(int[] nums) {
        // res, min 代表不可能超过的最大值，根据题目最大值是 50+50+50=150
        int n = nums.length, res = 256, min = 256;
        // 从左往右遍历，计算位置i的最小值
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = min = Math.min(min, nums[i]);
        }

        // 从右往左遍历，如果存在一个数 x > left[i] && x > right[k], 则存在一个三元组
        int right = nums[n - 1];
        for (int i = n - 2; i > 0; i--) {
            if (nums[i] > right && nums[i] > left[i - 1]) {
                res = Math.min(res, right + nums[i] + left[i - 1]);
            }
            right = Math.min(right, nums[i]);
        }

        // 如果不存在，则res=256
        return res != 256 ? res : -1;
    }
}
