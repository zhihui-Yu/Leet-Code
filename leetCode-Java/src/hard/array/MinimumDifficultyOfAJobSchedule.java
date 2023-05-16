package hard.array;

import java.util.Arrays;

/**
 * 1335. 工作计划的最低难度
 * 你需要制定一份 d 天的工作计划表。工作之间存在依赖，要想执行第 i 项工作，你必须完成全部 j 项工作（ 0 <= j < i）。
 * <p>
 * 你每天 至少 需要完成一项任务。工作计划的总难度是这 d 天每一天的难度之和，而一天的工作难度是当天应该完成工作的最大难度。
 * <p>
 * 给你一个整数数组 jobDifficulty 和一个整数 d，分别代表工作难度和需要计划的天数。第 i 项工作的难度是 jobDifficulty[i]。
 * <p>
 * 返回整个工作计划的 最小难度 。如果无法制定工作计划，则返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：jobDifficulty = [6,5,4,3,2,1], d = 2
 * 输出：7
 * 解释：第一天，您可以完成前 5 项工作，总难度 = 6.
 * 第二天，您可以完成最后一项工作，总难度 = 1.
 * 计划表的难度 = 6 + 1 = 7
 * 示例 2：
 * <p>
 * 输入：jobDifficulty = [9,9,9], d = 4
 * 输出：-1
 * 解释：就算你每天完成一项工作，仍然有一天是空闲的，你无法制定一份能够满足既定工作时间的计划表。
 * 示例 3：
 * <p>
 * 输入：jobDifficulty = [1,1,1], d = 3
 * 输出：3
 * 解释：工作计划为每天一项工作，总难度为 3 。
 * 示例 4：
 * <p>
 * 输入：jobDifficulty = [7,1,7,1,7,1], d = 3
 * 输出：15
 * 示例 5：
 * <p>
 * 输入：jobDifficulty = [11,111,22,222,33,333,44,444], d = 6
 * 输出：843
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= jobDifficulty.length <= 300
 * 0 <= jobDifficulty[i] <= 1000
 * 1 <= d <= 10
 *
 * @author simple
 */
public class MinimumDifficultyOfAJobSchedule {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) return -1;

        // 寻找子问题，求5天完成7个任务的最小总难度 => 分段理解：每天必须处理1~3个任务 => 求出每段的值，即可推导出后续的值
        int[][] dp = new int[d][n];

        for (int i = 0; i < d; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int j = 0, max = 0; j < n; j++) {
            max = Math.max(max, jobDifficulty[j]);
            dp[0][j] = max;
        }

        for (int i = 1; i < d; i++) { // 第i+1天
            for (int j = i; j <= n - d + i; j++) { // 可执行任务的下标： 最小任务下标开始，到最大任务下标，j变大，说明当前天数可完成的任务数量变小
                for (int k = j, max = 0; k <= n - d + i; k++) { // 当前天数可完成的任务数量； 可以考虑加memo缓存数组 memo[i][j]表示从i开始到j的子数组最大值
                    // 当前天完成多个任务时的需要取最大难度值
                    max = Math.max(max, jobDifficulty[k]);
                    // dp[i - 1][j - 1]：前一天执行到当前下标的前一个任务时耗费的最小和值
                    dp[i][k] = Math.min(dp[i][k], dp[i - 1][j - 1] + max);
                }
            }
        }
        return dp[d - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new MinimumDifficultyOfAJobSchedule().minDifficulty(new int[]{11, 111, 22, 222, 33, 333, 44, 444}, 6));
    }
}
