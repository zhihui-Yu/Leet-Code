package middle;

/**
 * 840. 矩阵中的幻方
 * <p>
 * 3 x 3 的幻方是一个填充有 从 1 到 9  的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
 * <p>
 * 给定一个由整数组成的row x col 的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？
 * <p>
 * 注意：虽然幻方只能包含 1 到 9 的数字，但 grid 可以包含最多15的数字。
 * <p>
 * 示例 1：
 * 输入: grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]
 * 输出: 1
 * 解释:
 * 下面的子矩阵是一个 3 x 3 的幻方：
 * <p>
 * 而这一个不是：
 * <p>
 * 总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
 * 示例 2:
 * <p>
 * 输入: grid = [[8]]
 * 输出: 0
 * <p>
 * <p>
 * 提示:
 * <p>
 * row == grid.length
 * col == grid[i].length
 * 1 <= row, col <= 10
 * 0 <= grid[i][j] <= 15
 *
 * @author simple
 */
public class MagicSquaresInGrid {
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                // 中心必定是5
                if (grid[i + 1][j + 1] != 5) continue;

                // 第一行
                if (grid[i][j] + grid[i][j + 1] + grid[i][j + 2] != 15) continue;
                // 第二行
                if (grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2] != 15) continue;

                // 第一列
                if (grid[i][j] + grid[i + 1][j] + grid[i + 2][j] != 15) continue;
                // 第二列
                if (grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1] != 15) continue;


                int[] nums = new int[10];
                if (grid[i][j] > 9 || nums[grid[i][j]]++ > 0) continue;
                if (grid[i][j + 1] > 9 || nums[grid[i][j + 1]]++ > 0) continue;
                if (grid[i][j + 2] > 9 || nums[grid[i][j + 2]]++ > 0) continue;
                if (grid[i + 1][j] > 9 || nums[grid[i + 1][j]]++ > 0) continue;
                if (grid[i + 1][j + 2] > 9 || nums[grid[i + 1][j + 1]]++ > 0) continue;
                if (grid[i + 1][j + 2] > 9 || nums[grid[i + 1][j + 2]]++ > 0) continue;
                if (grid[i + 2][j] > 9 || nums[grid[i + 2][j]]++ > 0) continue;
                if (grid[i + 2][j + 1] > 9 || nums[grid[i + 2][j + 1]]++ > 0) continue;
                if (grid[i + 2][j + 2] > 9 || nums[grid[i + 2][j + 2]]++ > 0) continue;

                if (grid[i][j] + grid[i][j + 1] + grid[i][j + 2] + grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2] + grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2] != 45)
                    continue;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MagicSquaresInGrid().numMagicSquaresInside(new int[][]{{1, 8, 6}, {10, 5, 0}, {4, 2, 9}}));
        System.out.println(new MagicSquaresInGrid().numMagicSquaresInside(new int[][]{{5, 5, 5}, {5, 5, 5}, {5, 5, 5}}));
    }
}
