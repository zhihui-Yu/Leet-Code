package easy;

import java.util.Arrays;

/**
 * @author simple
 * <p>
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * <p>
 * 如果不能形成任何面积不为零的三角形，返回0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[2,1,2]
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：[1,2,1]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：[3,2,3,4]
 * 输出：10
 * 示例 4：
 * <p>
 * 输入：[3,6,2,3]
 * 输出：8
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= A.length <= 10000
 * 1 <= A[i] <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-perimeter-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int len = A.length;
        int max = A[len - 1];
        int mid = A[len - 2];
        int index = 3;
        for (int i = len - 3; i >= 0; i--) {
            int min = A[i];
            if (max + mid > min && max + min > mid && min + mid > max) return max + mid + min;
            if (i == 0 && len > 3) {
                max = mid;
                mid = A[len - index];
                i = len - index;
                index++;
            }
        }
        return 0;
    }

//    官方解法
//    public int largestPerimeter(int[] A) {
//        Arrays.sort(A);
//        for (int i = A.length - 1; i >= 2; --i) {
//            if (A[i - 2] + A[i - 1] > A[i]) {
//                return A[i - 2] + A[i - 1] + A[i];
//            }
//        }
//        return 0;
//    }

    public static void main(String[] args) {
        new LargestPerimeterTriangle().largestPerimeter(new int[]{6, 3, 3, 2});
    }
}
