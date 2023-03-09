package easy;

import java.util.Arrays;
import java.util.Map;

/**
 * 2379. 得到 K 个黑块的最少涂色次数
 * <p>
 * 给你一个长度为 n 下标从 0 开始的字符串 blocks ，blocks[i] 要么是 'W' 要么是 'B' ，表示第 i 块的颜色。字符 'W' 和 'B' 分别表示白色和黑色。
 * <p>
 * 给你一个整数 k ，表示想要 连续 黑色块的数目。
 * <p>
 * 每一次操作中，你可以选择一个白色块将它 涂成 黑色块。
 * <p>
 * 请你返回至少出现 一次 连续 k 个黑色块的 最少 操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：blocks = "WBBWWBBWBW", k = 7
 * 输出：3
 * 解释：
 * 一种得到 7 个连续黑色块的方法是把第 0 ，3 和 4 个块涂成黑色。
 * 得到 blocks = "BBBBBBBWBW" 。
 * 可以证明无法用少于 3 次操作得到 7 个连续的黑块。
 * 所以我们返回 3 。
 * 示例 2：
 * <p>
 * 输入：blocks = "WBWBBBW", k = 2
 * 输出：0
 * 解释：
 * 不需要任何操作，因为已经有 2 个连续的黑块。
 * 所以我们返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == blocks.length
 * 1 <= n <= 100
 * blocks[i] 要么是 'W' ，要么是 'B' 。
 * 1 <= k <= n
 *
 * @author simple
 */
public class MinimumRecolorsToGetKConsecutiveBlackBlocks {
    public int minimumRecolors(String blocks, int k) {
        // 滑动窗口
        int whiteCnt = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W')
                whiteCnt++;
        }
        int min = whiteCnt;
        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W')
                whiteCnt++;
            if (blocks.charAt(i - k) == 'W')
                whiteCnt--;
            min = Math.min(whiteCnt, min);
        }
        return min;
    }

    // 暴力破解
    public int direct(String blocks, int k) {
        char[] chars = blocks.toCharArray();
        int lastOne = blocks.length() - k + 1;
        int min = blocks.length();
        for (int i = 0; i < lastOne; i++) {
            int tmp = 0;
            for (int j = 0; j < k; j++) {
                if (chars[i + j] == 'W')
                    tmp += 1;
            }
            min = Math.min(tmp, min);
        }
        return min;
    }

    public int dp(String blocks, int k) {
        char[] chars = blocks.toCharArray();
        int lastOne = blocks.length() - k + 1;
        int[] dp = new int[lastOne];
        for (int i = 0; i < lastOne; i++) {
            for (int j = 0; j < k; j++) {
                if (chars[i + j] == 'W')
                    dp[i] += 1;
            }
        }
        Arrays.sort(dp);
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(new MinimumRecolorsToGetKConsecutiveBlackBlocks().minimumRecolors("WBBWWBBWBW", 7));
        System.out.println(new MinimumRecolorsToGetKConsecutiveBlackBlocks().minimumRecolors("WBWBBBW", 2));
    }
}
