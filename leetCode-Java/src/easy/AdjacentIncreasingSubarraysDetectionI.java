package easy;

import java.util.List;

/**
 * 3349. 检测相邻递增子数组 I
 * 给你一个由 n 个整数组成的数组 nums 和一个整数 k，请你确定是否存在 两个 相邻 且长度为 k 的 严格递增 子数组。具体来说，
 * 需要检查是否存在从下标 a 和 b (a < b) 开始的 两个 子数组，并满足下述全部条件：
 * <p>
 * 这两个子数组 nums[a..a + k - 1] 和 nums[b..b + k - 1] 都是 严格递增 的。
 * 这两个子数组必须是 相邻的，即 b = a + k。
 * 如果可以找到这样的 两个 子数组，请返回 true；否则返回 false。
 * <p>
 * 子数组 是数组中的一个连续 非空 的元素序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,5,7,8,9,2,3,4,3,1], k = 3
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * 从下标 2 开始的子数组为 [7, 8, 9]，它是严格递增的。
 * 从下标 5 开始的子数组为 [2, 3, 4]，它也是严格递增的。
 * 两个子数组是相邻的，因此结果为 true。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,4,4,4,5,6,7], k = 5
 * <p>
 * 输出：false
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 100
 * 1 <= 2 * k <= nums.length
 * -1000 <= nums[i] <= 1000
 *
 * @author simple
 */
public class AdjacentIncreasingSubarraysDetectionI {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        for (int i = 0; i < n - k; i++) {
            if (isInc(nums, i, i + k - 1) && isInc(nums, i + k, i + k + k - 1)) {
                return true;
            }
        }
        return false;
    }

    private boolean isInc(List<Integer> nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (i + 1 >= nums.size() || nums.get(i) >= nums.get(i + 1)) return false;
        }
        return true;
    }

    public boolean hasIncreasingSubarrays_2(List<Integer> nums, int k) {
        int n = nums.size();
        int cnt = 1, preCnt = 0, ans = 0;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                cnt++;
            } else {
                preCnt = cnt;
                cnt = 0;
            }
            ans = Math.max(ans, Math.max(cnt / 2, Math.min(cnt, preCnt)));
        }
        return ans >= k;
    }

    public static void main(String[] args) {
        System.out.println(new AdjacentIncreasingSubarraysDetectionI().hasIncreasingSubarrays(List.of(1, 2, 3, 4, 4, 4, 4, 5, 6, 7), 3));
        System.out.println(new AdjacentIncreasingSubarraysDetectionI().hasIncreasingSubarrays(List.of(5, 8, -2, -1), 2));
        System.out.println(new AdjacentIncreasingSubarraysDetectionI().hasIncreasingSubarrays(List.of(2, 5, 7, 8, 9, 2, 3, 4, 3, 1), 3));
    }
}
