package middle.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 1072. 按列翻转得到最大值等行数
 * <p>
 * 给定 m x n 矩阵 matrix 。
 * <p>
 * 你可以从中选出任意数量的列并翻转其上的 每个 单元格。（即翻转后，单元格的值从 0 变成 1，或者从 1 变为 0 。）
 * <p>
 * 返回 经过一些翻转后，行与行之间所有值都相等的最大行数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[0,1],[1,1]]
 * 输出：1
 * 解释：不进行翻转，有 1 行所有值都相等。
 * 示例 2：
 * <p>
 * 输入：matrix = [[0,1],[1,0]]
 * 输出：2
 * 解释：翻转第一列的值之后，这两行都由相等的值组成。
 * 示例 3：
 * <p>
 * 输入：matrix = [[0,0,0],[0,0,1],[1,1,0]]
 * 输出：2
 * 解释：翻转前两列的值之后，后两行由相等的值组成。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] == 0 或 1
 *
 * @author simple
 */
public class FlipColumnsForMaximumNumberOfEqualRows {
    // 题目要求：找到行内值相同的最大行数
    // 找规律： 100 和 011 是两个本质相同的行，通过翻转后两列实现。
    // 如果将1开头的行都进行反转，并统计其数量，就可以知道最大的行数是多少。

    // 分析： 将1开头的行反转，则可以等到同质行，既得到其0开头的行是什么，由于0开头的行不进行反转，遍历所有行后，可以统计出各种同质行（0开头）的最大数量
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        int n = matrix[0].length;

        for (var row : matrix) {
            char[] r = new char[n];
            for (int i = 0; i < n; i++) {
                r[i] = (char) (row[0] ^ row[i]); // 0 ^ 1 = 1, 0 ^ 0 = 0;  1 ^ 0 =1, 1 ^ 1=0; 同为0，异为1
            }
            max = Math.max(max, map.merge(new String(r), 1, Integer::sum));
        }
        return max;
    }
}
