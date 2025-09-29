package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1039. 多边形三角剖分的最低得分
 * 你有一个凸的 n 边形，其每个顶点都有一个整数值。给定一个整数数组 values ，其中 values[i] 是第 i 个顶点的值（即 顺时针顺序 ）。
 * <p>
 * 假设将多边形 剖分 为 n - 2 个三角形。对于每个三角形，该三角形的值是顶点标记的乘积，三角剖分的分数是进行三角剖分后所有 n - 2 个三角形的值之和。
 * <p>
 * 返回 多边形进行三角剖分后可以得到的最低分 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：values = [1,2,3]
 * 输出：6
 * 解释：多边形已经三角化，唯一三角形的分数为 6。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：values = [3,7,4,5]
 * 输出：144
 * 解释：有两种三角剖分，可能得分分别为：3*7*5 + 4*5*7 = 245，或 3*4*5 + 3*4*7 = 144。最低分数为 144。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：values = [1,3,1,4,1,5]
 * 输出：13
 * 解释：最低分数三角剖分的得分情况为 1*1*3 + 1*1*4 + 1*1*5 + 1*1*1 = 13。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == values.length
 * 3 <= n <= 50
 * 1 <= values[i] <= 100
 *
 * @author simple
 */
public class MinimumScoreTriangulationOfPolygon {
    // 从任意一边开始，计算固定i,j边，移动k的最小剖分数
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] mem = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(mem[i], -1);
        }
        return dfs(0, n - 1, values, mem);
    }

    private int dfs(int i, int j, int[] v, int[][] mem) {
        // 两边不能组合成三角形
        if (i + 1 == j) return 0;
        // 如果存在则返回
        if (mem[i][j] != -1) return mem[i][j];
        // 计算那种模式可以获得最小值
        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            min = Math.min(min, dfs(i, k, v, mem) + dfs(k, j, v, mem) + v[i] * v[j] * v[k]);
        }
        return mem[i][j] = min;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumScoreTriangulationOfPolygon().minScoreTriangulation(new int[]{3, 7, 4, 5}));
        System.out.println(new MinimumScoreTriangulationOfPolygon().minScoreTriangulation(new int[]{1, 2, 3}));
        System.out.println(new MinimumScoreTriangulationOfPolygon().minScoreTriangulation(new int[]{1, 3, 1, 4, 1, 5}));
    }

}
