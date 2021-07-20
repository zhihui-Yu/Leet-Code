package easy;

import java.util.Arrays;

/**
 * @author simple
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix =[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length<= 100
 * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShunShiZhenDaYinJuZhenLcof {
    public int[] spiralOrder(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) return new int[0];

        int col = matrix[0].length;
        if (col == 0) return new int[0];

        if (row == 1) return matrix[0];
        int size = row * col;
        int[] nums = new int[size];
        int index = 0;
        int lr = col - 1, rd = row - 1, dl = col - 1, lu = row - 1, lrSize = 0, rdSize = col - 1, dlSize = row - 1, luSize = 0;
        int i = 0;
        while (index < size) {
            for (int j = i; j < lr && index < size; j++) nums[index++] = matrix[lrSize][j];
            lrSize++;
            for (int j = i; j < rd && index < size; j++) nums[index++] = matrix[j][rdSize];
            rdSize--;
            for (int j = dl; j > i && index < size; j--) nums[index++] = matrix[dlSize][j];
            dlSize--;
            for (int j = lu; j > i && index < size; j--) nums[index++] = matrix[j][luSize];
            luSize++;
            i++;
            if (index == size - 1) {
                nums[index++] = matrix[row / 2][col / 2];
            }

            lr -= 1;
            rd -= 1;
            dl -= 1;
            lu -= 1;
        }
        System.gc();
        return nums;
    }

    public static void main(String[] args) {
//        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        System.out.println(Arrays.toString(new ShunShiZhenDaYinJuZhenLcof().spiralOrder(ints)));

//        int[][] int2 = new int[][]{{6, 9, 7}};
//        System.out.println(Arrays.toString(new ShunShiZhenDaYinJuZhenLcof().spiralOrder(int2)));

//        int[][] int3 = new int[][]{{7},{9},{6}};
//        System.out.println(Arrays.toString(new ShunShiZhenDaYinJuZhenLcof().spiralOrder(int3)));

        int[][] int4 = new int[][]{
            {1, 2, 3, 4, 5, 6},
            {7, 8, 9, 10, 11, 12},
            {13, 14, 15, 16, 17, 18},
            {19, 20, 21, 22, 23, 24},
            {25, 26, 27, 28, 29, 30}};
        System.out.println(Arrays.toString(new ShunShiZhenDaYinJuZhenLcof().spiralOrder(int4)));
    }
}
