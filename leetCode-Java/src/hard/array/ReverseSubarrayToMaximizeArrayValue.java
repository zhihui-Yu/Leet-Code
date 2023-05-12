package hard.array;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 1330. 翻转子数组得到最大的数组值
 * 给你一个整数数组 nums 。「数组值」定义为所有满足 0 <= i < nums.length-1 的 |nums[i]-nums[i+1]| 的和。
 * <p>
 * 你可以选择给定数组的任意子数组，并将该子数组翻转。但你只能执行这个操作 一次 。
 * <p>
 * 请你找到可行的最大 数组值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,1,5,4]
 * 输出：10
 * 解释：通过翻转子数组 [3,1,5] ，数组变成 [2,5,1,3,4] ，数组值为 10 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,9,24,2,1,10]
 * 输出：68
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3*10^4
 * -10^5 <= nums[i] <= 10^5
 *
 * @author simple
 */
public class ReverseSubarrayToMaximizeArrayValue {
    // 力扣官方题解
    public int maxValueAfterReverse(int[] nums) {
        int value = 0, n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            value += Math.abs(nums[i] - nums[i + 1]);
        }
        int mx1 = 0;
        for (int i = 1; i < n - 1; i++) {
            mx1 = Math.max(mx1, Math.abs(nums[0] - nums[i + 1]) - Math.abs(nums[i] - nums[i + 1]));
            mx1 = Math.max(mx1, Math.abs(nums[n - 1] - nums[i - 1]) - Math.abs(nums[i] - nums[i - 1]));
        }
        int mx2 = Integer.MIN_VALUE, mn2 = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int x = nums[i], y = nums[i + 1];
            mx2 = Math.max(mx2, Math.min(x, y));
            mn2 = Math.min(mn2, Math.max(x, y));
        }
        return value + Math.max(mx1, 2 * (mx2 - mn2));
    }


    int n;
    int[] tab;
    int[][] vis;

    // 超时
    public int maxValueAfterReverse_timeout(int[] nums) {
        n = nums.length;
        tab = new int[n];
        vis = new int[n][n];

        for (int i = 0; i < n - 1; i++)
            tab[i] = Math.abs(nums[i] - nums[i + 1]);

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                vis[i][j] = IntStream.of(Arrays.copyOfRange(tab, i, j)).sum();
            }
        }

        int max = IntStream.of(tab).sum();
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                max = Math.max(max, f(nums, i, j));
        return max;
    }

    private int f(int[] nums, int i, int j) {
        int sum = 0;
        for (int k = j; k > i; k--)
            sum += Math.abs(nums[k] - nums[k - 1]);

        // 首位两个数的值不一样
        if (i > 0)
            sum += Math.abs(nums[i - 1] - nums[j]) + vis[0][i - 1];
        if (j < n - 1)
            sum += Math.abs(nums[i] - nums[j + 1]) + vis[j + 1][n - 1];
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseSubarrayToMaximizeArrayValue().maxValueAfterReverse(new int[]{2, 3, 1, 5, 4}));
    }
}
