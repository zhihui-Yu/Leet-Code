package easy;

/**
 * @author simple
 * <p>
 * 给你一个二维整数数组 logs ，其中每个 logs[i] = [birthi, deathi] 表示第 i 个人的出生和死亡年份。
 * <p>
 * 年份 x 的 人口 定义为这一年期间活着的人的数目。第 i 个人被计入年份 x 的人口需要满足：x 在闭区间 [birthi, deathi - 1] 内。注意，人不应当计入他们死亡当年的人口中。
 * <p>
 * 返回 人口最多 且 最早 的年份。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：logs = [[1993,1999],[2000,2010]]
 * 输出：1993
 * 解释：人口最多为 1 ，而 1993 是人口为 1 的最早年份。
 * 示例 2：
 * <p>
 * 输入：logs = [[1950,1961],[1960,1971],[1970,1981]]
 * 输出：1960
 * 解释：
 * 人口最多为 2 ，分别出现在 1960 和 1970 。
 * 其中最早年份是 1960 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= logs.length <= 100
 * 1950 <= birthi < deathi <= 2050
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-population-year
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumPopulationYear {
    // 思路：当前年的人数 = 前一年存活的人数 + 当前年出身的人
    public int maximumPopulation(int[][] logs) {
        // 算出每年出生的人和死去的人数。
        int offset = 1950;
        int[] dp = new int[101];
        for (int[] log : logs) {
            dp[log[0] - offset]++;
            dp[log[1] - offset]--;
        }

        // 计算每年存活的人数
        int count = 0, max = 0, resultYear = 0;
        for (int i = 0; i < dp.length; i++) {
            count += dp[i];
            if (max < count) {
                max = count;
                resultYear = offset + i;
            }
        }
        return resultYear;
    }
}
