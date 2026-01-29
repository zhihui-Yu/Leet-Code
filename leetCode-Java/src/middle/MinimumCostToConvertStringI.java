package middle;

import java.util.Arrays;

/**
 * 2976. 转换字符串的最小成本 I
 * 给你两个下标从 0 开始的字符串 source 和 target ，它们的长度均为 n 并且由 小写 英文字母组成。
 * <p>
 * 另给你两个下标从 0 开始的字符数组 original 和 changed ，以及一个整数数组 cost ，其中 cost[i] 代表将字符 original[i] 更改为字符 changed[i] 的成本。
 * <p>
 * 你从字符串 source 开始。在一次操作中，如果 存在 任意 下标 j 满足 cost[j] == z  、original[j] == x 以及 changed[j] == y 。你就可以选择字符串中的一个字符 x 并以 z 的成本将其更改为字符 y 。
 * <p>
 * 返回将字符串 source 转换为字符串 target 所需的 最小 成本。如果不可能完成转换，则返回 -1 。
 * <p>
 * 注意，可能存在下标 i 、j 使得 original[j] == original[i] 且 changed[j] == changed[i] 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：source = "abcd", target = "acbe", original = ["a","b","c","c","e","d"], changed = ["b","c","b","e","b","e"], cost = [2,5,5,1,2,20]
 * 输出：28
 * 解释：将字符串 "abcd" 转换为字符串 "acbe" ：
 * - 更改下标 1 处的值 'b' 为 'c' ，成本为 5 。
 * - 更改下标 2 处的值 'c' 为 'e' ，成本为 1 。
 * - 更改下标 2 处的值 'e' 为 'b' ，成本为 2 。
 * - 更改下标 3 处的值 'd' 为 'e' ，成本为 20 。
 * 产生的总成本是 5 + 1 + 2 + 20 = 28 。
 * 可以证明这是可能的最小成本。
 * 示例 2：
 * <p>
 * 输入：source = "aaaa", target = "bbbb", original = ["a","c"], changed = ["c","b"], cost = [1,2]
 * 输出：12
 * 解释：要将字符 'a' 更改为 'b'：
 * - 将字符 'a' 更改为 'c'，成本为 1
 * - 将字符 'c' 更改为 'b'，成本为 2
 * 产生的总成本是 1 + 2 = 3。
 * 将所有 'a' 更改为 'b'，产生的总成本是 3 * 4 = 12 。
 * 示例 3：
 * <p>
 * 输入：source = "abcd", target = "abce", original = ["a"], changed = ["e"], cost = [10000]
 * 输出：-1
 * 解释：无法将 source 字符串转换为 target 字符串，因为下标 3 处的值无法从 'd' 更改为 'e' 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= source.length == target.length <= 10^5
 * source、target 均由小写英文字母组成
 * 1 <= cost.length== original.length == changed.length <= 2000
 * original[i]、changed[i] 是小写英文字母
 * 1 <= cost[i] <= 10^6
 * original[i] != changed[i]
 *
 * @author simple
 */
public class MinimumCostToConvertStringI {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int max = Integer.MAX_VALUE / 2;
        int[][] g = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(g[i], max);
            g[i][i] = 0; // 没有从自己跳自己的
        }
        for (int i = 0; i < original.length; i++) {
            int x = original[i] - 'a';
            int y = changed[i] - 'a';
            g[x][y] = Math.min(g[x][y], cost[i]);
        }

        // Floyd-Warshall 算法， k 选与不选，然后计算从 i-> j 最短距离，
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                // 如果g[i][k] = max， 则一定会比g[i][j]大，下层循环没意义
                if (g[i][k] == max) continue;
                for (int j = 0; j < 26; j++) {
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }

        long costSum = 0;
        for (int i = 0; i < source.length(); i++) {
            int s = g[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
            if (s == max) return -1;
            costSum += s;
        }
        return costSum;
    }
}
