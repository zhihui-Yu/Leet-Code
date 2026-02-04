package hard;

/**
 * 3640. 三段式数组 II
 * 给你一个长度为 n 的整数数组 nums。
 * <p>
 * 三段式子数组 是一个连续子数组 nums[l...r]（满足 0 <= l < r < n），并且存在下标 l < p < q < r，使得：
 * <p>
 * nums[l...p] 严格 递增，
 * nums[p...q] 严格 递减，
 * nums[q...r] 严格 递增。
 * 请你从数组 nums 的所有三段式子数组中找出和最大的那个，并返回其 最大 和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,-2,-1,-3,0,2,-1]
 * <p>
 * 输出：-4
 * <p>
 * 解释：
 * <p>
 * 选择 l = 1, p = 2, q = 3, r = 5：
 * <p>
 * nums[l...p] = nums[1...2] = [-2, -1] 严格递增 (-2 < -1)。
 * nums[p...q] = nums[2...3] = [-1, -3] 严格递减 (-1 > -3)。
 * nums[q...r] = nums[3...5] = [-3, 0, 2] 严格递增 (-3 < 0 < 2)。
 * 和 = (-2) + (-1) + (-3) + 0 + 2 = -4。
 * 示例 2:
 * <p>
 * 输入: nums = [1,4,2,7]
 * <p>
 * 输出: 14
 * <p>
 * 解释:
 * <p>
 * 选择 l = 0, p = 1, q = 2, r = 3：
 * <p>
 * nums[l...p] = nums[0...1] = [1, 4] 严格递增 (1 < 4)。
 * nums[p...q] = nums[1...2] = [4, 2] 严格递减 (4 > 2)。
 * nums[q...r] = nums[2...3] = [2, 7] 严格递增 (2 < 7)。
 * 和 = 1 + 4 + 2 + 7 = 14。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 4 <= n = nums.length <= 105
 * -109 <= nums[i] <= 109
 * 保证至少存在一个三段式子数组。
 *
 * @author simple
 */
public class TrionicArrayII {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        long ans = Long.MIN_VALUE;
        // 求所有符合条件的三段数组和
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && nums[j] > nums[j - 1]) j++; // 递增

            int p = j - 1;
            if (p == i) continue;

            long res = 0;
            res += nums[p] + nums[p - 1]; // 至少有两个数在第一段
            // 递减
            while (j < n && nums[j - 1] > nums[j]) {
                res += nums[j];
                j++;
            }

            int q = j - 1;
            if (p == q || q == n - 1 || (j < n && nums[j] <= nums[j - 1])) {
                i = q;
                continue;
            }
            res += nums[j++]; // 递减的最后一个值
            // 递增 并计算第三段中最大和
            long sum = 0;
            long maxSum = 0;
            while (j < n && nums[j] > nums[j - 1]) {
                sum += nums[j];
                maxSum = Math.max(sum, maxSum);
                j++;
            }
            res += maxSum;

            // 计算第一段中的最大和
            sum = 0;
            maxSum = 0;
            for (int k = p - 2; k >= i; k--) {
                sum += nums[k];
                maxSum = Math.max(sum, maxSum);
            }
            res += maxSum;

            ans = Math.max(res, ans);
            i = q - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new TrionicArrayII().maxSumTrionic(new int[]{1,4,2,7}));
        System.out.println(new TrionicArrayII().maxSumTrionic(new int[]{0, -2, -1, -3, 0, 2, -1}));
    }
}
