package middle.array;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 示例 2：
 * <p>
 * 输入：triangle = [[-10]]
 * 输出：-10
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -10^4 <= triangle[i][j] <= 10^4
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
 *
 * @author simple
 */
public class Triangle {
    /**
     * -> f[i][0] + triangle[i][0]                         j=0
     * f[i][j] = -> f[i-1][i-1] + triangle[i][i]                     j=i
     * -> min(f[i-1][j-i],f[i-1][j] + triangle[i][i]       otherwise
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.getFirst().getFirst();
        for (int i = 1; i < n; i++) {
            f[i][0] = f[i - 1][0] + triangle.get(i).getFirst();
            for (int j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[n - 1][0];
        for (int i = 1; i < n; i++) {
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }
        return minTotal;
    }

    /**
     * 由于i行只与i-1行的数据有关联，所以可以只维护一个int[2][n], 空间复杂度变从 O(n^2)-> O(n)
     */
    public int minimumTotal_2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[2][n];
        f[0][0] = triangle.getFirst().getFirst();
        for (int i = 1; i < n; i++) {
            int curr = i % 2;
            int prev = 1 - curr;
            f[curr][0] = f[prev][0] + triangle.get(i).getFirst();
            for (int j = 1; j < i; j++) {
                f[curr][j] = Math.min(f[prev][j - 1], f[prev][j]) + triangle.get(i).get(j);
            }
            f[curr][i] = f[prev][i - 1] + triangle.get(i).get(i);
        }
        int i = (n - 1) % 2;
        int minTotal = f[i][0];
        for (int j = 1; j < n; j++) {
            minTotal = Math.min(minTotal, f[i][j]);
        }
        return minTotal;
    }

    // 倒序计算，可以从右往左覆盖，维护一维数组
    public int minimumTotal_3(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] f = new int[n];
        f[0] = triangle.getFirst().getFirst();
        for (int i = 1; i < n; i++) {
            f[i] = f[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; j--) {
                f[j] = Math.min(f[j - 1], f[j]) + triangle.get(i).get(j);
            }
            f[0] += triangle.get(i).getFirst();
        }

        int minTotal = f[0];
        for (int i = 1; i < n; i++) {
            minTotal = Math.min(minTotal, f[i]);
        }
        return minTotal;
    }

    public static void main(String[] args) {
        System.out.println(new Triangle().minimumTotal_3(List.of(
            List.of(2),
            List.of(3, 4),
            List.of(6, 5, 7),
            List.of(4, 1, 8, 3)
        )));
    }
}
