package easy;

/**
 * @author simple
 * <p>
 * 给你一个m* n的矩阵grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
 * <p>
 * 请你统计并返回grid中 负数 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * 输出：8
 * 解释：矩阵中共有 8 个负数。
 * 示例 2：
 * <p>
 * 输入：grid = [[3,2],[1,0]]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：grid = [[1,-1],[-1,-1]]
 * 输出：3
 * 示例 4：
 * <p>
 * 输入：grid = [[-1]]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-negative-numbers-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountNegativeNumbersInASortedMatrix {
    public int countNegatives(int[][] grid) {
        int negativeDigitCount = 0;
        for (int[] row : grid) {
            for (int col : row) {
                if (col < 0) negativeDigitCount++;
            }
        }
        return negativeDigitCount;
    }
}
