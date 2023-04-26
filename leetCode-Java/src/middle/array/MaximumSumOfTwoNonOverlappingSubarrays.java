package middle.array;

/**
 * 1031. 两个非重叠子数组的最大和
 * 给你一个整数数组 nums 和两个整数 firstLen 和 secondLen，请你找出并返回两个非重叠 子数组 中元素的最大和，长度分别为 firstLen 和 secondLen 。
 * <p>
 * 长度为 firstLen 的子数组可以出现在长为 secondLen 的子数组之前或之后，但二者必须是不重叠的。
 * <p>
 * 子数组是数组的一个 连续 部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,6,5,2,2,5,1,9,4], firstLen = 1, secondLen = 2
 * 输出：20
 * 解释：子数组的一种选择中，[9] 长度为 1，[6,5] 长度为 2。
 * 示例 2：
 * <p>
 * 输入：nums = [3,8,1,3,2,1,8,9,0], firstLen = 3, secondLen = 2
 * 输出：29
 * 解释：子数组的一种选择中，[3,8,1] 长度为 3，[8,9] 长度为 2。
 * 示例 3：
 * <p>
 * 输入：nums = [2,1,5,6,0,9,5,0,3,8], firstLen = 4, secondLen = 3
 * 输出：31
 * 解释：子数组的一种选择中，[5,6,0,9] 长度为 4，[0,3,8] 长度为 3。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= firstLen, secondLen <= 1000
 * 2 <= firstLen + secondLen <= 1000
 * firstLen + secondLen <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 *
 * @author simple
 */
public class MaximumSumOfTwoNonOverlappingSubarrays {
    int[] cache; // 前缀和

    // 只要固定一个长度，遍历其他两侧数组中 second len 的最大值即可
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;

        cache = new int[n + 1];
        cache[1] = nums[0];
        for (int i = 2; i <= n; i++) cache[i] += cache[i - 1] + nums[i - 1];

        // 由于使用前缀和数组， 有点绕。指针下标要注意
        int sum = 0;
        for (int i = firstLen; i <= n; i++) {
            int fMax = dfs(i - firstLen, i, firstLen);
            int sMax = Math.max(dfs(i, n, secondLen), dfs(0, i - firstLen, secondLen));
            sum = Math.max(sum, fMax + sMax);
        }

        return sum;
    }

    // i..j 中 长度为 len 的最大值是多少
    private int dfs(int i, int j, int len) {
        int max = 0;
        for (int k = i; k + len <= j; k++) {
            max = Math.max(max, cache[k + len] - cache[k]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSumOfTwoNonOverlappingSubarrays().maxSumTwoNoOverlap(new int[]{1, 0, 3}, 1, 2)); // 4
        System.out.println(new MaximumSumOfTwoNonOverlappingSubarrays().maxSumTwoNoOverlap(new int[]{1, 0, 1}, 1, 1)); // 2
        System.out.println(new MaximumSumOfTwoNonOverlappingSubarrays().maxSumTwoNoOverlap(new int[]{0, 6, 5, 2, 2, 5, 1, 9, 4}, 1, 2)); // 20
        System.out.println(new MaximumSumOfTwoNonOverlappingSubarrays().maxSumTwoNoOverlap(new int[]{3, 8, 1, 3, 2, 1, 8, 9, 0}, 3, 2)); // 29
        System.out.println(new MaximumSumOfTwoNonOverlappingSubarrays().maxSumTwoNoOverlap(new int[]{2, 1, 5, 6, 0, 9, 5, 0, 3, 8}, 4, 3)); // 31
    }
}
