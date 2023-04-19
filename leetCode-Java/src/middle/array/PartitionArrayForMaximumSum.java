package middle.array;

/**
 * 1043. 分隔数组以得到最大和
 * 给你一个整数数组 arr，请你将该数组分隔为长度 最多 为 k 的一些（连续）子数组。
 * 分隔完成后，每个子数组的中的所有值都会变为该子数组中的最大值。
 * <p>
 * 返回将数组分隔变换后能够得到的元素最大和。本题所用到的测试用例会确保答案是一个 32 位整数。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,15,7,9,2,5,10], k = 3
 * 输出：84
 * 解释：数组变为 [15,15,15,9,10,10,10]
 * 示例 2：
 * <p>
 * 输入：arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
 * 输出：83
 * 示例 3：
 * <p>
 * 输入：arr = [1], k = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 10^9
 * 1 <= k <= arr.length
 *
 * @author simple
 */
public class PartitionArrayForMaximumSum {
    // 由力扣官方题解改编
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= k && i - j >= 0; j++) { // 从后往前遍历 分为 1..k个子数组的情况
                max = Math.max(arr[i - j], max);
                dp[i] = Math.max(dp[i], dp[i - j] + max * j); // 当将最后一个子数组分成 1..k时，每种情况下的最大和求最大值。 dp[i - j] => 是倒数i-[1..k]时最大值和
            }
        }
        return dp[n];
    }

    int[][] dp;

    public int maxSumAfterPartitioning2(int[] arr, int k) {
        // 0...n 分成 p...(k-p)'
        int n = arr.length;
        dp = new int[n][n];
        return dfs(arr, 0, n - 1, k);
    }

    // 虽然加了缓表，但是还是慢
    private int dfs(int[] arr, int i, int j, int k) {
        if (i > j) return 0;
        if (i == j) return arr[j];
        if (dp[i][j] != 0) return dp[i][j];
        int max = 0;
        int preMax = 0;
        for (int l = 0; l < k && l + i <= j; l++) {
            preMax = Math.max(preMax, arr[i + l]);
            int sum = dfs(arr, i + l + 1, j, k);
            max = Math.max(max, preMax * (l + 1) + sum);
        }
        dp[i][j] = max;
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionArrayForMaximumSum().maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));
    }
}
