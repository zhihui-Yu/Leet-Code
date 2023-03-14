package middle;

/**
 * 48. 旋转图像
 * <p>
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * <p>
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[ 5 , 1 ,9,  11],
 * [ 2 , 4 , 8,  10],
 * [13, 3 ,  6,  7],
 * [15, 14 , 12, 16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 *
 * @author simple
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int[][] tmp = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                tmp[j][len - i - 1] = matrix[i][j];
            }
        }
        // 辅助矩阵比较简单，原地旋转的话，需要以一个数为原点，持续遍历所有点直到回到原点。 但由于是四边形，其实就4个点
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                matrix[i][j] = tmp[i][j];
            }
        }
    }
}
