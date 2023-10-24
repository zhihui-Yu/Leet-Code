package middle;

/**
 * 1155. 掷骰子等于目标和的方法数
 * 这里有 n 个一样的骰子，每个骰子上都有 k 个面，分别标号为 1 到 k 。
 * <p>
 * 给定三个整数 n ,  k 和 target ，返回可能的方式(从总共 k^n 种方式中)滚动骰子的数量，使正面朝上的数字之和等于 target 。
 * <p>
 * 答案可能很大，你需要对 10^9 + 7 取模 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1, k = 6, target = 3
 * 输出：1
 * 解释：你扔一个有 6 个面的骰子。
 * 得到 3 的和只有一种方法。
 * 示例 2：
 * <p>
 * 输入：n = 2, k = 6, target = 7
 * 输出：6
 * 解释：你扔两个骰子，每个骰子有 6 个面。
 * 得到 7 的和有 6 种方法：1+6 2+5 3+4 4+3 5+2 6+1。
 * 示例 3：
 * <p>
 * 输入：n = 30, k = 30, target = 500
 * 输出：222616187
 * 解释：返回的结果必须是对 10^9 + 7 取模。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n, k <= 30
 * 1 <= target <= 1000
 *
 * @author simple
 */
public class NumberOfDiceRollsWithTargetSum {
    public static void main(String[] args) {
        System.out.println(new NumberOfDiceRollsWithTargetSum().numRollsToTarget(3, 3, 2));
    }

    // 链接：https://leetcode.cn/problems/number-of-dice-rolls-with-target-sum/
    public int numRollsToTarget(int n, int k, int target) {
        int MOD = 1000000007;

        // f(i,j) = 使用 i 个骰子且数字之和为 j 的方案数
        int[][] f = new int[n + 1][target + 1];
        f[0][0] = 1; // 0个骰子 扔 0 次 数字之和为 target => 1
        for (int i = 1; i <= n; ++i) { // 骰子数
            for (int j = 1; j <= target; ++j) { // 数字和
                for (int x = 1; x <= k && j >= x; ++x) { // 骰子数字枚举
                    f[i][j] = (f[i][j] + f[i - 1][j - x]) % MOD;
                }
            }
        }
        return f[n][target];
    }


    public int numRollsToTarget2(int n, int k, int target) {
        int MOD = 1000000007;
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) { // 骰子数
            for (int j = target; j >= 0; --j) { // 数字和
                f[j] = 0;
                for (int x = 1; x <= k && j >= x; ++x) {
                    f[j] = (f[j] + f[j - x]) % MOD;
                }
            }
        }
        return f[target];
    }
}
