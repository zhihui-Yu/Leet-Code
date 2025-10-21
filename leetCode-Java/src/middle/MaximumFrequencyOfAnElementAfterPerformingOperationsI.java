package middle;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 3346. 执行操作后元素的最高频率 I
 * 给你一个整数数组 nums 和两个整数 k 和 numOperations 。
 * <p>
 * 你必须对 nums 执行 操作  numOperations 次。每次操作中，你可以：
 * <p>
 * 选择一个下标 i ，它在之前的操作中 没有 被选择过。
 * 将 nums[i] 增加范围 [-k, k] 中的一个整数。
 * 在执行完所有操作以后，请你返回 nums 中出现 频率最高 元素的出现次数。
 * <p>
 * 一个元素 x 的 频率 指的是它在数组中出现的次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,4,5], k = 1, numOperations = 2
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 通过以下操作得到最高频率 2 ：
 * <p>
 * 将 nums[1] 增加 0 ，nums 变为 [1, 4, 5] 。
 * 将 nums[2] 增加 -1 ，nums 变为 [1, 4, 4] 。
 * 示例 2：
 * <p>
 * 输入：nums = [5,11,20,20], k = 5, numOperations = 1
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 通过以下操作得到最高频率 2 ：
 * <p>
 * 将 nums[1] 增加 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 * 0 <= k <= 105
 * 0 <= numOperations <= nums.length
 *
 * @author simple
 */
public class MaximumFrequencyOfAnElementAfterPerformingOperationsI {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Integer, Integer> cnt = new HashMap<>();
        // 差分法需要使用treeMap，遍历时候有序累加
        Map<Integer, Integer> diff = new TreeMap<>();
        for (int num : nums) {
            cnt.merge(num, 1, Integer::sum);
            diff.putIfAbsent(num, 0);
            // 差分: 把 [x-k, x+k] 中的每个整数的出现次数都加一
            diff.merge(num - k, 1, Integer::sum);
            diff.merge(num + k + 1, -1, Integer::sum);
        }
        int ans = 0;
        int sum = 0;
        for (var e : diff.entrySet()) {
            // sum 是某一个数字的次数的总和，包含了operate+nums的
            sum += e.getValue();
            // 由于最多只能操作 numOperations 次，所以需要用nums原有的+numOperations 跟 总和取小
            ans = Math.max(ans, Math.min(sum, cnt.getOrDefault(e.getKey(), 0) + numOperations));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumFrequencyOfAnElementAfterPerformingOperationsI().maxFrequency(new int[]{1,2,3,4},1,1));
    }
}
