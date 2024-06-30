package middle.array;

/**
 * 494. 目标和
 * 给你一个非负整数数组 nums 和一个整数 target 。
 * <p>
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * <p>
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 示例 2：
 * <p>
 * 输入：nums = [1], target = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 *
 * @author simple
 */
public class TargetSum {
    // 0-1 背包问题， 恰巧容量为target时，有几种装法
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) return 0;


        int pv = diff / 2; // 背包容量
        int n = nums.length;
        int[][] f = new int[n + 1][pv + 1]; // 从 n 个数字中选取和为pv的可能性
        f[0][0] = 1;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = 0; j <= pv; j++) {
                if (num > j) {
                    f[i + 1][j] = f[i][j]; // 容量超过，只能不选
                } else {
                    f[i + 1][j] = f[i][j] + f[i][j - num]; // 不选 + 选
                }
            }
        }
        return f[n][pv];
    }

    public static void main(String[] args) {
        System.out.println(new TargetSum().findTargetSumWays(new int[]{1,1,1,1,1},3));
    }
}
