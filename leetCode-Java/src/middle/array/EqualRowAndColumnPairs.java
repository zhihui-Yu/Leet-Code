package middle.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 2352. 相等行列对
 * 给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。
 * <p>
 * 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[3,2,1],[1,7,6],[2,7,7]]
 * 输出：1
 * 解释：存在一对相等行列对：
 * - (第 2 行，第 1 列)：[2,7,7]
 * 示例 2：
 * <p>
 * 输入：grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
 * 输出：3
 * 解释：存在三对相等行列对：
 * - (第 0 行，第 0 列)：[3,1,2,2]
 * - (第 2 行, 第 2 列)：[2,4,2,2]
 * - (第 3 行, 第 2 列)：[2,4,2,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length == grid[i].length
 * 1 <= n <= 200
 * 1 <= grid[i][j] <= 10^5
 *
 * @author simple
 */
public class EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> cols = new HashMap<>();
        List<String> rows = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            StringBuilder row = new StringBuilder();
            StringBuilder col = new StringBuilder();
            for (int j = 0; j < grid.length; j++) {
                row.append(grid[i][j]).append("-");
                col.append(grid[j][i]).append("-");
            }
            rows.add(row.toString());
            cols.compute(col.toString(), (k, v) -> v == null ? 1 : v + 1);
        }

        int cnt = 0;
        for (var row : rows) {
            cnt += cols.getOrDefault(row, 0);
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new EqualRowAndColumnPairs().equalPairs(new int[][]{{11, 1}, {1, 11}}));
        System.out.println(new EqualRowAndColumnPairs().equalPairs(new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}}));
        System.out.println(new EqualRowAndColumnPairs().equalPairs(new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}}));
    }
}
