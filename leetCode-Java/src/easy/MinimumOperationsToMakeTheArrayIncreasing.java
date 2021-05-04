package easy;

/**
 * @author simple
 * <p>
 * 给你一个整数数组nums（下标从 0 开始）。每一次操作中，你可以选择数组中一个元素，并将它增加1。
 * <p>
 * 比方说，如果nums = [1,2,3]，你可以选择增加nums[1]得到nums = [1,3,3]。
 * 请你返回使 nums严格递增的 最少操作次数。
 * <p>
 * 我们称数组nums是 严格递增的，当它满足对于所有的0 <= i < nums.length - 1都有nums[i] < nums[i+1]。一个长度为 1的数组是严格递增的一种特殊情况。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：3
 * 解释：你可以进行如下操作：
 * 1) 增加 nums[2] ，数组变为 [1,1,2] 。
 * 2) 增加 nums[1] ，数组变为 [1,2,2] 。
 * 3) 增加 nums[2] ，数组变为 [1,2,3] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,5,2,4,1]
 * 输出：14
 * 示例 3：
 * <p>
 * 输入：nums = [8]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5000
 * 1 <= nums[i] <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-operations-to-make-the-array-increasing
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumOperationsToMakeTheArrayIncreasing {
    public int minOperations(int[] nums) {
        int operatorNum = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int delta = nums[i - 1] + 1 - nums[i];
                operatorNum += delta;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return operatorNum;
    }
}
