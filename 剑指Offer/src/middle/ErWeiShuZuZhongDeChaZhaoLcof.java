package middle;

/**
 * @author simple
 * <p>
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target=5，返回true。
 * <p>
 * 给定target=20，返回false。
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= n <= 1000
 * <p>
 * 0 <= m <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ErWeiShuZuZhongDeChaZhaoLcof {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 将矩阵旋转45°，得到一个平衡有序的二叉树
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) return false;
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            int num = matrix[row][col];
            if (num == target) return true;
            if (target < num) col--;
            else row++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ErWeiShuZuZhongDeChaZhaoLcof().findNumberIn2DArray(new int[][]{{-5}}, -5));
    }
}
