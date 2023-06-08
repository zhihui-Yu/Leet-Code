package hard;

/**
 * 1240. 铺瓷砖
 * 你是一位施工队的工长，根据设计师的要求准备为一套设计风格独特的房子进行室内装修。
 * <p>
 * 房子的客厅大小为 n x m，为保持极简的风格，需要使用尽可能少的 正方形 瓷砖来铺盖地面。
 * <p>
 * 假设正方形瓷砖的规格不限，边长都是整数。
 * <p>
 * 请你帮设计师计算一下，最少需要用到多少块方形瓷砖？
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2, m = 3
 * 输出：3
 * 解释：3 块地砖就可以铺满卧室。
 * 2 块 1x1 地砖
 * 1 块 2x2 地砖
 * 示例 2：
 * <p>
 * 输入：n = 5, m = 8
 * 输出：5
 * 示例 3：
 * <p>
 * 输入：n = 11, m = 13
 * 输出：6
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 13
 * 1 <= m <= 13
 *
 * @author simple
 */
public class TilingARectangleWithTheFewestSquares {
    public int tilingRectangle(int n, int m) {
        if (n % m == 0) return n / m;
        if (m % n == 0) return m / n;

        // 动态规划 dp[n][m] =
    }
}
