package middle.graph;

/**
 * 1334. 阈值距离内邻居最少的城市
 * 有 n 个城市，按从 0 到 n-1 编号。
 * 给你一个边数组 edges，其中 edges[i] = [fromi, toi, weighti] 代表 fromi 和 toi 两个城市之间的双向加权边，
 * 距离阈值是一个整数 distanceThreshold。
 * <p>
 * 返回能通过某些路径到达其他城市数目最少、且路径距离 最大 为 distanceThreshold 的城市。如果有多个这样的城市，则返回编号最大的城市。
 * <p>
 * 注意，连接城市 i 和 j 的路径的距离等于沿该路径的所有边的权重之和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
 * 输出：3
 * 解释：城市分布图如上。
 * 每个城市阈值距离 distanceThreshold = 4 内的邻居城市分别是：
 * 城市 0 -> [城市 1, 城市 2]
 * 城市 1 -> [城市 0, 城市 2, 城市 3]
 * 城市 2 -> [城市 0, 城市 1, 城市 3]
 * 城市 3 -> [城市 1, 城市 2]
 * 城市 0 和 3 在阈值距离 4 以内都有 2 个邻居城市，但是我们必须返回城市 3，因为它的编号最大。
 * 示例 2：
 * <p>
 * 输入：n = 5, edges = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]], distanceThreshold = 2
 * 输出：0
 * 解释：城市分布图如上。
 * 每个城市阈值距离 distanceThreshold = 2 内的邻居城市分别是：
 * 城市 0 -> [城市 1]
 * 城市 1 -> [城市 0, 城市 4]
 * 城市 2 -> [城市 3, 城市 4]
 * 城市 3 -> [城市 2, 城市 4]
 * 城市 4 -> [城市 1, 城市 2, 城市 3]
 * 城市 0 在阈值距离 2 以内只有 1 个邻居城市。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 100
 * 1 <= edges.length <= n * (n - 1) / 2
 * edges[i].length == 3
 * 0 <= fromi < toi < n
 * 1 <= weighti, distanceThreshold <= 10^4
 * 所有 (fromi, toi) 都是不同的。
 *
 * @author simple
 */
public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] grid = new int[n][n];
        // init
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = i == j ? 0 : 0x3f3f3f3f; // 不能用 int 的 MAX， 会溢出。0x3f3f3f3f < MAX / 2;
            }
        }

        // 边加权
        for (int[] e : edges) {
            int d1 = e[0], d2 = e[1], c = e[2];
            grid[d1][d2] = grid[d2][d1] = c;
        }

        floyd(grid, n);
        int cnt = n, ans = -1;
        for (int i = 0; i < n; i++) {
            int x = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && grid[i][j] <= distanceThreshold) x++;
            }
            // max city number
            if (x <= cnt) {
                cnt = x;
                ans = i;
            }
        }
        return ans;
    }

    private void floyd(int[][] grid, int n) {
        // floyd 基本流程为三层循环: [枚举中转点 -- 枚举起点 -- 枚举终点] => 松弛操作
        for (int p = 0; p < n; p++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = Math.min(grid[i][j], grid[i][p] + grid[p][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(0x3f3f3f3f);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(new FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance().findTheCity(4, new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}}, 4));
        System.out.println(new FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance().findTheCity(5, new int[][]{{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}}, 2));
    }
}
