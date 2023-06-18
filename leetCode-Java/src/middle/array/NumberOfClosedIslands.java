package middle.array;

/**
 * 1254. 统计封闭岛屿的数目
 * 二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。
 * <p>
 * 请返回 封闭岛屿 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * 输出：2
 * 解释：
 * 灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：grid = [[1,1,1,1,1,1,1],
 * [1,0,0,0,0,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,1,0,1,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,0,0,0,0,1],
 * [1,1,1,1,1,1,1]]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 *
 * @author simple
 */
public class NumberOfClosedIslands {
    // 判断是否封闭：从一个为0的节点出发，深度遍历其所有相关节点，如果为0，则是封闭的，如果超出边界 则不是封闭。
    // - 遍历后需要把相关节点置为1，以防被再次遍历到
    // - 需要遍历所有节点，以防关联节点由于上一步而导致变成单独岛屿
    public int closedIsland(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && isClosed(grid, m, n, i, j)) {
                    ans++;
                }
            }

        }
        return ans;
    }

    public boolean isClosed(int[][] grid, int m, int n, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) return false; // 超出边界

        if (grid[i][j] != 0) return true; // 关联节点为1, 则表示封闭

        grid[i][j] = -1;  // 标记 (i,j) 被访问，避免重复访问

        // 必须所有点都遍历一遍
        boolean r1 = isClosed(grid, m, n, i - 1, j);
        boolean r2 = isClosed(grid, m, n, i + 1, j);
        boolean r3 = isClosed(grid, m, n, i, j - 1);
        boolean r4 = isClosed(grid, m, n, i, j + 1);

        return r1 & r2 & r3 & r4;
    }
}
