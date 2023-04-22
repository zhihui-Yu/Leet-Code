package middle;

/**
 * 1027. 最长等差数列
 * 给你一个整数数组 nums，返回 nums 中最长等差子序列的长度。
 * <p>
 * 回想一下，nums 的子序列是一个列表 nums[i1], nums[i2], ..., nums[ik] ，且 0 <= i1 < i2 < ... < ik <= nums.length - 1。并且如果 seq[i+1] - seq[i]( 0 <= i < seq.length - 1) 的值都相同，那么序列 seq 是等差的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,6,9,12]
 * 输出：4
 * 解释：
 * 整个数组是公差为 3 的等差数列。
 * 示例 2：
 * <p>
 * 输入：nums = [9,4,7,2,10]
 * 输出：3
 * 解释：
 * 最长的等差子序列是 [4,7,10]。
 * 示例 3：
 * <p>
 * 输入：nums = [20,1,15,3,10,5,8]
 * 输出：4
 * 解释：
 * 最长的等差子序列是 [20,15,10,5]。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 1000
 * 0 <= nums[i] <= 500
 *
 * @author simple
 */
public class LongestArithmeticSubsequence {
    // 动态规划：dp[i][j]=>下标为 i 时， 差值为 j 的数组长度
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][1001]; // 下标为 i 时， 差值为 j 的数组长度
        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int dif = nums[i] - nums[j] + 500;
                dp[i][dif] = Math.max(dp[i][dif], dp[j][dif] + 1); // max 是为了差值一样的情况
                max = Math.max(max, dp[i][dif]);
            }
        }
        return max + 1;
    }

    // 超时
    public int longestArithSeqLength2(int[] nums) {
        int[] cache = new int[500];
        for (int num : nums) cache[num]++;
        int cnt = 0;
        for (int i = 1; i < nums.length; i++) {
            int tmp = 2;
            int dif = nums[i] - nums[i - 1];
            for (int j = nums[i] + dif; j >= 0 && cache[j] != 0; j += dif) tmp++;
            cnt = Math.max(tmp, cnt);
            for (int j = 0; j < i - 1; j++) {
                tmp = 2;
                dif = nums[i] - nums[j];
                for (int k = nums[i] + dif; k >= 0 && cache[k] != 0; k += dif) tmp++;
                cnt = Math.max(tmp, cnt);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new LongestArithmeticSubsequence().longestArithSeqLength(new int[]{83, 20, 17, 43, 52, 78, 68, 45})); // 2
        System.out.println(new LongestArithmeticSubsequence().longestArithSeqLength(new int[]{3, 6, 9, 12})); // 4
        System.out.println(new LongestArithmeticSubsequence().longestArithSeqLength(new int[]{9, 4, 7, 2, 10})); // 3
        System.out.println(new LongestArithmeticSubsequence().longestArithSeqLength(new int[]{20, 1, 15, 3, 10, 5, 8})); // 4
    }
}
