package middle;

import java.util.Arrays;

/**
 * 3634. 使数组平衡的最少移除数目
 * 给你一个整数数组 nums 和一个整数 k。
 * <p>
 * 如果一个数组的 最大 元素的值 至多 是其 最小 元素的 k 倍，则该数组被称为是 平衡 的。
 * <p>
 * 你可以从 nums 中移除 任意 数量的元素，但不能使其变为 空 数组。
 * <p>
 * 返回为了使剩余数组平衡，需要移除的元素的 最小 数量。
 * <p>
 * 注意：大小为 1 的数组被认为是平衡的，因为其最大值和最小值相等，且条件总是成立。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：nums = [2,1,5], k = 2
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 移除 nums[2] = 5 得到 nums = [2, 1]。
 * 现在 max = 2, min = 1，且 max <= min * k，因为 2 <= 1 * 2。因此，答案是 1。
 * 示例 2:
 * <p>
 * 输入：nums = [1,6,2,9], k = 3
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 移除 nums[0] = 1 和 nums[3] = 9 得到 nums = [6, 2]。
 * 现在 max = 6, min = 2，且 max <= min * k，因为 6 <= 2 * 3。因此，答案是 2。
 * 示例 3:
 * <p>
 * 输入：nums = [4,6], k = 2
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 由于 nums 已经平衡，因为 6 <= 4 * 2，所以不需要移除任何元素。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 1 <= k <= 10^5
 *
 * @author simple
 */
public class MinimumRemovalsToBalanceArray {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int ans = n;
        int right = 0;
        for (int left = 0; left < n; left++) {
            while (right < n && nums[right] <= (long) nums[left] * k) {
                right++; // right = 实际数量, 比如长度为4的数组，取[1,2], right = 3, left = 1, ans = 4-(3-1) = 2
            }
            ans = Math.min(ans, n - (right - left));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumRemovalsToBalanceArray().minRemoval(new int[]{26155, 1776, 22815, 775, 27772, 12869, 12995, 22794, 27692, 24728, 10944, 25039, 24068, 25506, 18506, 19138, 12331, 17814, 20834, 21474, 20208, 21590, 15453, 6114, 25716, 29434, 23547, 29051, 25992, 5535, 7387}, 80020));
        System.out.println(new MinimumRemovalsToBalanceArray().minRemoval(new int[]{4, 6}, 2));
        System.out.println(new MinimumRemovalsToBalanceArray().minRemoval(new int[]{1, 6, 2, 9}, 3));
        System.out.println(new MinimumRemovalsToBalanceArray().minRemoval(new int[]{2, 1, 5}, 2));
    }
}
