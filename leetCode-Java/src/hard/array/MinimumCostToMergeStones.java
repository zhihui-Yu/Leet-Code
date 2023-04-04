package hard.array;

import java.util.Arrays;

/**
 * 1000. 合并石头的最低成本
 * 有 N 堆石头排成一排，第 i 堆中有 stones[i] 块石头。
 * <p>
 * 每次移动（move）需要将连续的 K 堆石头合并为一堆，而这个移动的成本为这 K 堆石头的总数。
 * <p>
 * 找出把所有石头合并成一堆的最低成本。如果不可能，返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：stones = [3,2,4,1], K = 2
 * 输出：20
 * 解释：
 * 从 [3, 2, 4, 1] 开始。
 * 合并 [3, 2]，成本为 5，剩下 [5, 4, 1]。
 * 合并 [4, 1]，成本为 5，剩下 [5, 5]。
 * 合并 [5, 5]，成本为 10，剩下 [10]。
 * 总成本 20，这是可能的最小值。
 * 示例 2：
 * <p>
 * 输入：stones = [3,2,4,1], K = 3
 * 输出：-1
 * 解释：任何合并操作后，都会剩下 2 堆，我们无法再进行合并。所以这项任务是不可能完成的。.
 * 示例 3：
 * <p>
 * 输入：stones = [3,5,1,2,6], K = 3
 * 输出：25
 * 解释：
 * 从 [3, 5, 1, 2, 6] 开始。
 * 合并 [5, 1, 2]，成本为 8，剩下 [3, 8, 6]。
 * 合并 [3, 8, 6]，成本为 17，剩下 [17]。
 * 总成本 25，这是可能的最小值。
 * <p>
 * 提示：
 * <p>
 * 1 <= stones.length <= 30
 * 2 <= K <= 30
 * 1 <= stones[i] <= 100
 *
 * @author simple
 */
public class MinimumCostToMergeStones {
    // 定义dp[i][j][k]为合并第i堆到第j堆石头为k堆的成本
    // dp[i][j][1] = dp[i][j][k] + sum(i, j)
    // dp[i][j][m] = min(dp[i][p][1] + dp[p + 1][j][m - 1])，i <= p < j，2 <= m <= k。
//    初始化dp[i][i][1] = 0，答案就是dp[1][n][1]。
    private int[][][] memo;
    private int[] sum;
    private int k;

    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) return -1; // n - C*(k-1) = 1 -> C 是常数
        this.k = k;
        this.sum = new int[n + 1];
        this.memo = new int[n][n][k + 1]; // 最后一个使用时忽略下表0，所以是k+1的长度
        for (int i = 0; i < n; i++) sum[i + 1] = sum[i] + stones[i]; // 前缀和
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) Arrays.fill(memo[i][j], -1); // 没计算过则是-1
        return dfs(0, n - 1, 1);
    }

    private int dfs(int i, int j, int p) {
        // 访问过直接返回
        if (memo[i][j][p] != -1) return memo[i][j][p];
        // 变成1堆的条件是 i..j 分按k切分合并。 由于最终合并时消耗相当于 i..j 全部相加，既前缀和
        if (p == 1) return memo[i][j][p] = i == j ? 0 : dfs(i, j, k) + sum[j+1] - sum[i];
        int min = Integer.MAX_VALUE;
        for (int l = i; l < j; l += k - 1) {
            min = Math.min(min, dfs(i, l, 1) + dfs(l + 1, j, p - 1)); // i..l..j, 总共分成p堆，则前面是1，后面就是p-1
        }
        return memo[i][j][p] = min;
    }

    // 错误思路：取每个段里面最小的合就会构造出最小的值
    public int mergeStones2(int[] stones, int k) {
        int[] arr = Arrays.copyOfRange(stones, 0, stones.length);
        int cnt = 0;
        while (arr.length != 1) {
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for (int i = k - 1; i < arr.length; i++) {
                int t = 0;
                for (int x = k - 1; x >= 0; x--) {
                    t += arr[i - x];
                }
                int tmp = Math.min(t, min);
                if (min != tmp) {
                    idx = i;
                    min = tmp;
                }
            }
            if (idx == -1) return -1;

            cnt += min;
            int[] tmpArr = new int[arr.length - k + 1];
            for (int i = 0; i < tmpArr.length; i++) {
                if (i == idx - k + 1) {
                    for (int x = k - 1; x >= 0; x--) {
                        tmpArr[i] += arr[i + x];
                    }
                } else if (i < idx - k + 1) {
                    tmpArr[i] = arr[i];
                } else {
                    tmpArr[i] = arr[i + k - 1];
                }
            }
            arr = tmpArr;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumCostToMergeStones().mergeStones(new int[]{3, 5, 1, 2, 6}, 3)); // 25
        System.out.println(new MinimumCostToMergeStones().mergeStones(new int[]{3, 2, 4, 1}, 2)); // 20
        System.out.println(new MinimumCostToMergeStones().mergeStones(new int[]{3, 2, 4, 1}, 3)); // -1
    }
}
