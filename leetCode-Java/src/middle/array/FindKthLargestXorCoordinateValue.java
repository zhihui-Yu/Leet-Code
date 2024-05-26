package middle.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 1738. 找出第 K 大的异或坐标值
 * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
 * <p>
 * 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
 * <p>
 * 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[5,2],[1,6]], k = 1
 * 输出：7
 * 解释：坐标 (0,1) 的值是 5 XOR 2 = 7 ，为最大的值。
 * 示例 2：
 * <p>
 * 输入：matrix = [[5,2],[1,6]], k = 2
 * 输出：5
 * 解释：坐标 (0,0) 的值是 5 = 5 ，为第 2 大的值。
 * 示例 3：
 * <p>
 * 输入：matrix = [[5,2],[1,6]], k = 3
 * 输出：4
 * 解释：坐标 (1,0) 的值是 5 XOR 1 = 4 ，为第 3 大的值。
 * 示例 4：
 * <p>
 * 输入：matrix = [[5,2],[1,6]], k = 4
 * 输出：0
 * 解释：坐标 (1,1) 的值是 5 XOR 2 XOR 1 XOR 6 = 0 ，为第 4 大的值。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 1000
 * 0 <= matrix[i][j] <= 10^6
 * 1 <= k <= m * n
 *
 * @author simple
 */
public class FindKthLargestXorCoordinateValue {
    public int kthLargestValue(int[][] matrix, int k) {
        int row = matrix.length, col = matrix[0].length;
        int[][] pre = new int[row + 1][col + 1];
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                /**
                 * pre[i-1][j-1] 表示到达矩阵的 (i-1, j-1) 位置，
                 * 但不包括从 (0, 0) 到 (i-1, j-1) 的所有元素的异或和。
                 *
                 * 这个值需要被加回来，因为我们在计算 pre[i-1][j] 和 pre[i][j-1] 时，(i-1, j-1) 这个位置被异或了两次，而我们需要它只异或一次。
                 */
                pre[i][j] = pre[i][j - 1] ^ pre[i - 1][j] ^ pre[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                result.add(pre[i][j]);
            }
        }

        result.sort((o1, o2) -> o2 - o1);

        return result.get(k - 1);
    }

    public static void main(String[] args) {
        System.out.println(new FindKthLargestXorCoordinateValue().kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 1));
    }
}
