package middle.array;

import java.util.LinkedList;

/**
 * 1091. 二进制矩阵中的最短路径
 * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
 * <p>
 * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
 * <p>
 * 路径途经的所有单元格的值都是 0 。
 * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
 * 畅通路径的长度 是该路径途经的单元格总数。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[0,1],[1,0]]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
 * 输出：-1
 * <p>
 * 提示：
 * <p>
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 100
 * grid[i][j] 为 0 或 1
 *
 * @author simple
 */
public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;

        int n = grid.length;
        int[][] dist = new int[n][n]; // 计算路径+避免走重复路线
        dist[0][0] = 1; // 起点
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); // 将起点入栈
        int[] idx;
        int row, col;
        while (!queue.isEmpty()) {
            idx = queue.pop();
            row = idx[0];
            col = idx[1];

            // 遍历八个点 + 自己
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) continue; // 自己
                    if (row + i < 0 || col + j < 0 || row + i >= n || col + j >= n) continue; // 越界
                    if (grid[row + i][col + j] != 0 || dist[row + i][col + j] != 0) continue; // 非0不走，走过不走
                    dist[row + i][col + j] = dist[row][col] + 1;
                    queue.offer(new int[]{row + i, col + j});
                }
            }
        }
        return dist[n - 1][n - 1] == 0 ? -1 : dist[n - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new ShortestPathInBinaryMatrix().shortestPathBinaryMatrix(new int[][]{{0, 1}, {1, 0}}));
    }
}
