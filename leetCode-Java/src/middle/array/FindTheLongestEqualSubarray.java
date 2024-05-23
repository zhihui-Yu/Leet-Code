package middle.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2831. 找出最长等值子数组
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * <p>
 * 如果子数组中所有元素都相等，则认为子数组是一个 等值子数组 。注意，空数组是 等值子数组 。
 * <p>
 * 从 nums 中删除最多 k 个元素后，返回可能的最长等值子数组的长度。
 * <p>
 * 子数组 是数组中一个连续且可能为空的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,2,3,1,3], k = 3
 * 输出：3
 * 解释：最优的方案是删除下标 2 和下标 4 的元素。
 * 删除后，nums 等于 [1, 3, 3, 3] 。
 * 最长等值子数组从 i = 1 开始到 j = 3 结束，长度等于 3 。
 * 可以证明无法创建更长的等值子数组。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,2,2,1,1], k = 2
 * 输出：4
 * 解释：最优的方案是删除下标 2 和下标 3 的元素。
 * 删除后，nums 等于 [1, 1, 1, 1] 。
 * 数组自身就是等值子数组，长度等于 4 。
 * 可以证明无法创建更长的等值子数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= nums.length
 * 0 <= k <= nums.length
 *
 * @author simple
 */
public class FindTheLongestEqualSubarray {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        // 每个数字，数字下标的数组
        Map<Integer, List<Integer>> numMap = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            numMap.computeIfAbsent(nums.get(i), x -> new ArrayList<>()).add(i);
        }

        /**
         * 最难理解应该就是这个 `(num.get(i) - num.get(j) - (i - j) > k)`
         *
         * 其实我认为应该是 `num.get(i) - num.get(j) + 1` 代表窗口，即ai...aj,
         * `i - j + 1` 代表已经遍历的个数（`0-0+1`,遍历1个），两者相减即 `(num.get(i) - num.get(j) - (i - j)`,
         * 如果大于k，说明窗口超了，需要缩小，即`j++`,在`j++` 后，`ans`的值由于`i+1,j+1`，所以这一轮超的时候计算的`i-j+1`和上一轮`i-j+1`时候是一样的。  (有点妙)
         */
        int ans = 0;
        for (var num : numMap.values()) {
            for (int i = 0, j = 0; i < num.size(); i++) {
                // end - start - 已经遍历了的 > 最大可以移除的， 则j++
                while (num.get(i) - num.get(j) - (i - j) > k) {
                    j++;
                }
                // i-j+1 => 最长有几个连在一起
                ans = Math.max(ans, i - j + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new FindTheLongestEqualSubarray().longestEqualSubarray(List.of(1, 3, 2, 3, 1, 3), 3)); // 3
        System.out.println(new FindTheLongestEqualSubarray().longestEqualSubarray(List.of(1, 1, 2, 2, 1, 1), 2)); // 4
    }
}
