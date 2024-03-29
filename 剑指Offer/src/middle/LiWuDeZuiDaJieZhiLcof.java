package middle;

/**
 * 剑指 Offer 47. 礼物的最大价值
 * <p>
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 *
 * @author simple
 */
public class LiWuDeZuiDaJieZhiLcof {
    // 每次只能向右或者向下移动一格
    public int maxValue(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int up = i == 0 ? 0 : grid[i - 1][j];
                int left = j == 0 ? 0 : grid[i][j - 1];
                grid[i][j] = grid[i][j] + Math.max(up, left);
            }
        }
        return grid[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        System.out.println(new LiWuDeZuiDaJieZhiLcof().maxValue(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}
