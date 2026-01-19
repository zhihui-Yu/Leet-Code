package middle;

/**
 * 1292. 元素和小于等于阈值的正方形的最大边长
 * <p>
 * 给你一个大小为 m x n 的矩阵 mat 和一个整数阈值 threshold。
 * <p>
 * 请你返回元素总和小于或等于阈值的正方形区域的最大边长；如果没有这样的正方形区域，则返回 0 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
 * 输出：2
 * 解释：总和小于或等于 4 的正方形的最大边长为 2，如图所示。
 * 示例 2：
 * <p>
 * 输入：mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold = 1
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 300
 * 0 <= mat[i][j] <= 10^4
 * 0 <= threshold <= 10^5
 *
 * @author simple
 */
public class MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + mat[i][j];
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                while (ans + i < m && ans + j < n && query(sum, i, j, ans + i, ans + j) <= threshold) ans++;
            }
        }

        return ans;
    }

    // 计算正方形的元素和,
    private int query(int[][] sum, int i, int j, int i1, int j1) {
        return sum[i1 + 1][j1 + 1] - sum[i1 + 1][j] - sum[i][j1 + 1] + sum[i][j];
    }
}
