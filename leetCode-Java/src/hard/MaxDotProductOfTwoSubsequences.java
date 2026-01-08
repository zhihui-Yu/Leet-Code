package hard;

import java.util.Arrays;

/**
 * 1458. 两个子序列的最大点积
 * 给你两个数组 nums1 和 nums2 。
 * <p>
 * 请你返回 nums1 和 nums2 中两个长度相同的 非空 子序列的最大点积。
 * <p>
 * 数组的非空子序列是通过删除原数组中某些元素（可能一个也不删除）后剩余数字组成的序列，但不能改变数字间相对顺序。
 * 比方说，[2,3,5] 是 [1,2,3,4,5] 的一个子序列而 [1,5,3] 不是。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [2,1,-2,5], nums2 = [3,0,-6]
 * 输出：18
 * 解释：从 nums1 中得到子序列 [2,-2] ，从 nums2 中得到子序列 [3,-6] 。
 * 它们的点积为 (2*3 + (-2)*(-6)) = 18 。
 * 示例 2：
 * <p>
 * 输入：nums1 = [3,-2], nums2 = [2,-6,7]
 * 输出：21
 * 解释：从 nums1 中得到子序列 [3] ，从 nums2 中得到子序列 [7] 。
 * 它们的点积为 (3*7) = 21 。
 * 示例 3：
 * <p>
 * 输入：nums1 = [-1,-1], nums2 = [1,1]
 * 输出：-1
 * 解释：从 nums1 中得到子序列 [-1] ，从 nums2 中得到子序列 [1] 。
 * 它们的点积为 -1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 500
 * -1000 <= nums1[i], nums2[i] <= 1000
 *
 * @author simple
 */
public class MaxDotProductOfTwoSubsequences {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // 都表示从 num1 的前缀 [0,i] 和 num2 的前缀 [0,j] 中选两个长度相等的非空子序列，计算两个子序列点积的最大值
        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(f[i], Integer.MIN_VALUE);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                f[i + 1][j + 1] = Math.max(
                    // 包含前面的 / 只选 nums1[i] 和 nums2[j]
                    Math.max(f[i][j], 0) + nums1[i] * nums2[j],
                    // 不选 nums1[i] / 不选 nums2[j]
                    Math.max(f[i + 1][j], f[i][j + 1])
                );
            }
        }

        return f[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new MaxDotProductOfTwoSubsequences().maxDotProduct(new int[]{-1,-1}, new int[]{1,1}));
    }
}
