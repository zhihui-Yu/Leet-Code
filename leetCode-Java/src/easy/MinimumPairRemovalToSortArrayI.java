package easy;

import java.util.Arrays;

/**
 * 3507. 移除最小数对使数组有序 I
 * 给你一个数组 nums，你可以执行以下操作任意次数：
 * <p>
 * 选择 相邻 元素对中 和最小 的一对。如果存在多个这样的对，选择最左边的一个。
 * 用它们的和替换这对元素。
 * 返回将数组变为 非递减 所需的 最小操作次数 。
 * <p>
 * 如果一个数组中每个元素都大于或等于它前一个元素（如果存在的话），则称该数组为非递减。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [5,2,3,1]
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 元素对 (3,1) 的和最小，为 4。替换后 nums = [5,2,4]。
 * 元素对 (2,4) 的和为 6。替换后 nums = [5,6]。
 * 数组 nums 在两次操作后变为非递减。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [1,2,2]
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 数组 nums 已经是非递减的。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50
 * -1000 <= nums[i] <= 1000
 *
 * @author simple
 */
public class MinimumPairRemovalToSortArrayI {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        int[] next = new int[n];
        Arrays.setAll(next, x -> x + 1);
        next[n - 1] = -1;
        int count = 0;
        while (n - count > 1) {
            int cur = 0;
            int target = 0;
            int targetSum = nums[target] + nums[next[target]];
            boolean asc = true;
            // 寻找最小的相邻对
            while (cur != -1 && next[cur] != -1) {
                if (nums[cur] > nums[next[cur]]) asc = false;

                int curSum = nums[cur] + nums[next[cur]];
                if (curSum < targetSum) {
                    target = cur;
                    targetSum = curSum;
                }
                cur = next[cur];
            }
            if (asc) break;

            count++;
            next[target] = next[next[target]];
            nums[target] = targetSum;
        }
        return count;
    }
}
