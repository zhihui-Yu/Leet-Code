package easy.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2389. 和有限的最长子序列
 * 给你一个长度为 n 的整数数组 nums ，和一个长度为 m 的整数数组 queries 。
 * <p>
 * 返回一个长度为 m 的数组 answer ，其中 answer[i] 是 nums 中 元素之和小于等于 queries[i] 的子序列的最大长度  。
 * <p>
 * 子序列 是由一个数组删除某些元素（也可以不删除）但不改变剩余元素顺序得到的一个数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,2,1], queries = [3,10,21]
 * 输出：[2,3,4]
 * 解释：queries 对应的 answer 如下：
 * - 子序列 [2,1] 的和小于或等于 3 。可以证明满足题目要求的子序列的最大长度是 2 ，所以 answer[0] = 2 。
 * - 子序列 [4,5,1] 的和小于或等于 10 。可以证明满足题目要求的子序列的最大长度是 3 ，所以 answer[1] = 3 。
 * - 子序列 [4,5,2,1] 的和小于或等于 21 。可以证明满足题目要求的子序列的最大长度是 4 ，所以 answer[2] = 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,3,4,5], queries = [1]
 * 输出：[0]
 * 解释：空子序列是唯一一个满足元素和小于或等于 1 的子序列，所以 answer[0] = 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * m == queries.length
 * 1 <= n, m <= 1000
 * 1 <= nums[i], queries[i] <= 106
 *
 * @author simple
 */
public class LongestSubsequenceWithLimitedSum {
    // 暴力破解
    public int[] answerQueries2(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int sum = 0;
            int count = 0;
            for (int num : nums) {
                sum += num;
                if (sum > queries[i]) {
                    break;
                }
                count++;
            }
            res[i] = count;
        }
        return res;
    }
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;
        Arrays.sort(nums);
        // 为了方便处理，将queries 排序，但是不是对原数组
        Integer[] tmp = new Integer[m];
        for (int i = 0; i < m; i++) {
            tmp[i] = i;
        }
        Arrays.sort(tmp, Comparator.comparingInt(i -> queries[i])); // tmp中下标是queries排序后的

        int sum = 0;
        int nIndex = 0;

        int[] ans = new int[m];
        for (var i : tmp) { // 从小到大处理数组
            while (nIndex < n && queries[i] >= sum + nums[nIndex]) {
                sum += nums[nIndex++];
            }
            ans[i] = nIndex;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LongestSubsequenceWithLimitedSum().answerQueries(new int[]{4,5,2,1}, new int[]{3,10,21})));
    }
}
