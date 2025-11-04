package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 3318. 计算子数组的 x-sum I
 * 给你一个由 n 个整数组成的数组 nums，以及两个整数 k 和 x。
 * <p>
 * 数组的 x-sum 计算按照以下步骤进行：
 * <p>
 * 统计数组中所有元素的出现次数。
 * 仅保留出现次数最多的前 x 个元素的每次出现。如果两个元素的出现次数相同，则数值 较大 的元素被认为出现次数更多。
 * 计算结果数组的和。
 * 注意，如果数组中的不同元素少于 x 个，则其 x-sum 是数组的元素总和。
 * <p>
 * 返回一个长度为 n - k + 1 的整数数组 answer，其中 answer[i] 是 子数组 nums[i..i + k - 1] 的 x-sum。
 * <p>
 * 子数组 是数组内的一个连续 非空 的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2,2,3,4,2,3], k = 6, x = 2
 * <p>
 * 输出：[6,10,12]
 * <p>
 * 解释：
 * <p>
 * 对于子数组 [1, 1, 2, 2, 3, 4]，只保留元素 1 和 2。因此，answer[0] = 1 + 1 + 2 + 2。
 * 对于子数组 [1, 2, 2, 3, 4, 2]，只保留元素 2 和 4。因此，answer[1] = 2 + 2 + 2 + 4。注意 4 被保留是因为其数值大于出现其他出现次数相同的元素（3 和 1）。
 * 对于子数组 [2, 2, 3, 4, 2, 3]，只保留元素 2 和 3。因此，answer[2] = 2 + 2 + 2 + 3 + 3。
 * 示例 2：
 * <p>
 * 输入：nums = [3,8,7,8,7,5], k = 2, x = 2
 * <p>
 * 输出：[11,15,15,15,12]
 * <p>
 * 解释：
 * <p>
 * 由于 k == x，answer[i] 等于子数组 nums[i..i + k - 1] 的总和。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n == nums.length <= 50
 * 1 <= nums[i] <= 50
 * 1 <= x <= k <= nums.length
 *
 * @author simple
 */
public class FindXSumOfAllKLongSubarraysI {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] cnt = new int[51];
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < k - 1; i++) {
            cnt[nums[i]]++;
        }

        int index = 0;
        for (int i = k - 1; i < n; i++) {
            cnt[nums[i]]++;
            ans[index] = sum(cnt, x);
            cnt[nums[index++]]--;
        }
        return ans;
    }

    private int sum(int[] cnt, int x) {
        Set<Integer> indexes = new HashSet<>();
        for (int i = 0; i < x; i++) {
            int maxIndex = 0;
            for (int j = 0; j < cnt.length; j++) {
                if (!indexes.contains(j)) {
                    int u = cnt[maxIndex];
                    int w = cnt[j];
                    maxIndex = w >= u ? j : maxIndex;
                }
            }
            indexes.add(maxIndex);
        }

        int ans = 0;
        for (int i : indexes) {
            ans += cnt[i] * i;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindXSumOfAllKLongSubarraysI().findXSum(new int[]{1, 1, 2, 2, 3, 4, 2, 3}, 6, 2)));
        System.out.println(Arrays.toString(new FindXSumOfAllKLongSubarraysI().findXSum(new int[]{3,8,7,8,7,5}, 2, 2)));
    }
}
