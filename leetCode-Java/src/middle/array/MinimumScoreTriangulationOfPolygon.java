package middle.array;

/**
 * 1039. 多边形三角剖分的最低得分
 * 你有一个凸的 n 边形，其每个顶点都有一个整数值。给定一个整数数组 values ，其中 values[i] 是第 i 个顶点的值（即 顺时针顺序 ）。
 * <p>
 * 假设将多边形 剖分 为 n - 2 个三角形。对于每个三角形，该三角形的值是顶点标记的乘积，三角剖分的分数是进行三角剖分后所有 n - 2 个三角形的值之和。
 * <p>
 * 返回 多边形进行三角剖分后可以得到的最低分 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：values = [1,2,3]
 * 输出：6
 * 解释：多边形已经三角化，唯一三角形的分数为 6。
 * 示例 2：
 * <p>
 * 输入：values = [3,7,4,5]
 * 输出：144
 * 解释：有两种三角剖分，可能得分分别为：3*7*5 + 4*5*7 = 245，或 3*4*5 + 3*4*7 = 144。最低分数为 144。
 * 示例 3：
 * <p>
 * 输入：values = [1,3,1,4,1,5]
 * 输出：13
 * 解释：最低分数三角剖分的得分情况为 1*1*3 + 1*1*4 + 1*1*5 + 1*1*1 = 13。
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
    int[][] vis;
    int[] values;

    public int minScoreTriangulation(int[] values) {
        // 问题拆分， 一个多边形拆三角形，三角形点在[0,n-1]，假设i=0,k=1,j=2,那么第一条线确认后，求剩余多边形中的最小三角形值。
        // 那么则多边形的点在 [2,n-1], 如上依次在拆分
        int n = values.length;
        this.values = values;
        this.vis = new int[n][n];
        return dfs(0, n - 1);
    }

    public int dfs(int i, int j) {
        if (i + 1 == j) return 0;
        if (vis[i][j] != 0) return vis[i][j];
        int score = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            score = Math.min(score, values[i] * values[j] * values[k] + dfs(i, k) + dfs(k, j));
        }
        return vis[i][j] = score;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumScoreTriangulationOfPolygon().minScoreTriangulation(new int[]{1, 3, 1, 4, 1, 5})); // 13
        System.out.println(new MinimumScoreTriangulationOfPolygon().minScoreTriangulation(new int[]{3, 4, 4, 4})); // 96
        System.out.println(new MinimumScoreTriangulationOfPolygon().minScoreTriangulation(new int[]{1, 2, 3})); // 6
        System.out.println(new MinimumScoreTriangulationOfPolygon().minScoreTriangulation(new int[]{3, 7, 4, 5})); // 144
    }
}
