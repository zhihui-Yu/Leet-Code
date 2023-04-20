package hard.array;

import java.util.Arrays;

/**
 * 1187. 使数组严格递增
 * 给你两个整数数组 arr1 和 arr2，返回使 arr1 严格递增所需要的最小「操作」数（可能为 0）。
 * <p>
 * 每一步「操作」中，你可以分别从 arr1 和 arr2 中各选出一个索引，分别为 i 和 j，0 <= i < arr1.length 和 0 <= j < arr2.length，然后进行赋值运算 arr1[i] = arr2[j]。
 * <p>
 * 如果无法让 arr1 严格递增，请返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr1 = [1,5,3,6,7], arr2 = [1,3,2,4]
 * 输出：1
 * 解释：用 2 来替换 5，之后 arr1 = [1, 2, 3, 6, 7]。
 * 示例 2：
 * <p>
 * 输入：arr1 = [1,5,3,6,7], arr2 = [4,3,1]
 * 输出：2
 * 解释：用 3 来替换 5，然后用 4 来替换 3，得到 arr1 = [1, 3, 4, 6, 7]。
 * 示例 3：
 * <p>
 * 输入：arr1 = [1,5,3,6,7], arr2 = [1,6,3,3]
 * 输出：-1
 * 解释：无法使 arr1 严格递增。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr1.length, arr2.length <= 2000
 * 0 <= arr1[i], arr2[i] <= 10^9
 *
 * @author simple
 */
public class MakeArrayStrictlyIncreasing {
    // dp: 第i个元素进行j次交换后的最小值 [j = Math.min(arr1.length, arr2.length)]
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2); // 使用集合会超时

        int INF = 0x3f3f3f3f;
        int m = arr2.length;
        int n = arr1.length;

        int[][] dp = new int[n + 1][Math.min(m, n) + 1]; // 下标i时，进行j次替换后最小的值
        for (var d : dp) Arrays.fill(d, INF);

        dp[0][0] = -1;
        for (int i = 1; i <= n; i++) {
            // 可发生的交换次数
            for (int j = 0; j <= Math.min(i, m); j++) {
                // 如果有序，则不交换时最小值为arr[i-1]
                if (arr1[i - 1] > dp[i - 1][j]) dp[i][j] = arr1[i - 1];

                // 如果需要交换，需要寻找arr2中大于dp[i - 1][j - 1]的最小值，与dp[i][j] 取小。
                if (j > 0 && dp[i - 1][j - 1] != INF) {
                    int idx = find(arr2, dp[i - 1][j - 1]);
                    if (idx != m) dp[i][j] = Math.min(dp[i][j], arr2[idx]);
                }
                if (i == n && dp[i][j] != INF) return j;
            }
        }
        return -1;
    }

    private int find(int[] arr2, int target) {
        int low = 0, h = arr2.length;
        while (low < h) {
            int mid = low + (h - low) / 2;
            if (arr2[mid] > target) {
                h = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(new MakeArrayStrictlyIncreasing().makeArrayIncreasing(new int[]{4, 3, 2, 1}, new int[]{1, 3, 2, 4}));
        System.out.println(new MakeArrayStrictlyIncreasing().makeArrayIncreasing(new int[]{1, 5, 3, 6, 7}, new int[]{1, 3, 2, 4}));
        System.out.println(new MakeArrayStrictlyIncreasing().makeArrayIncreasing(new int[]{1, 5, 3, 6, 7}, new int[]{1, 6, 3, 3}));
    }
}
