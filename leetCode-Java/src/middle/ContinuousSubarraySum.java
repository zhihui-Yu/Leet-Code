package middle;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author simple
 * 给你一个整数数组 nums 和一个整数k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 * <p>
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [23,2,4,6,7], k = 6
 * 输出：true
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [23,2,6,4,7], k = 6
 * 输出：true
 * 解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
 * 42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
 * 示例 3：
 * <p>
 * 输入：nums = [23,2,6,4,7], k = 13
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 0 <= sum(nums[i]) <= 231 - 1
 * 1 <= k <= 231 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
//        超时了
//        if (nums == null || nums.length < 2) return false;
//        for (int i = 1; i < nums.length; i++) {
//            int num = nums[i];
//            for (int j = i; j > 0; j--) {
//                num += nums[j-1];
//                if (num % k == 0) {
//                    return true;
//                }
//            }
//        }
//        return false;

        // 同余定理：即当两个数除以某个数的余数相等，那么二者相减后肯定可以被该数整除
        if (nums == null || nums.length < 2) return false;
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        // (n + m) % k = x     --->   n/k + m/k = 0
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= nums.length; i++) {
            set.add(preSum[i - 2] % k);
            if (set.contains(preSum[i] % k)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ContinuousSubarraySum().checkSubarraySum(new int[]{0, 2, 2,3, 2,3}, 6));
    }
}
