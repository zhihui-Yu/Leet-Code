package easy;

/**
 * @author simple
 * <p>
 * 给你一个n行m列的矩阵，最开始的时候，每个单元格中的值都是 0。
 * <p>
 * 另有一个索引数组indices，indices[i] = [ri, ci]中的ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
 * <p>
 * 你需要将每对[ri, ci]指定的行和列上的所有单元格的值加 1。
 * <p>
 * 请你在执行完所有indices指定的增量操作后，返回矩阵中 「奇数值单元格」 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 2, m = 3, indices = [[0,1],[1,1]]
 * 输出：6
 * 解释：最开始的矩阵是 [[0,0,0],[0,0,0]]。
 * 第一次增量操作后得到 [[1,2,1],[0,1,0]]。
 * 最后的矩阵是 [[1,3,1],[1,3,1]]，里面有 6 个奇数。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 2, m = 2, indices = [[1,1],[0,0]]
 * 输出：0
 * 解释：最后的矩阵是 [[2,2],[2,2]]，里面没有奇数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 50
 * 1 <= m <= 50
 * 1 <= indices.length <= 100
 * 0 <= indices[i][0] <n
 * 0 <= indices[i][1] <m
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cells-with-odd-values-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CellsWithOddValuesInAMatrix {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];
        for (int[] i : indices) {
            int row = i[0];
            int col = i[1];
            for (int j = 0; j < matrix[row].length; j++) {
                matrix[row][j]++;
            }
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][col]++;
            }
        }
        int oddCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] % 2 != 0) oddCount++;
            }
        }
        return oddCount;
    }
}
