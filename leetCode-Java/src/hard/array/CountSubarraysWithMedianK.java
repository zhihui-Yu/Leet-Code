package hard.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2488. 统计中位数为 K 的子数组
 * 给你一个长度为 n 的数组 nums ，该数组由从 1 到 n 的不同整数组成。另给你一个正整数 k 。
 * <p>
 * 统计并返回 nums 中的 中位数 等于 k 的非空子数组的数目。
 * <p>
 * 注意：
 * <p>
 * 数组的中位数是按 递增 顺序排列后位于 中间 的那个元素，如果数组长度为偶数，
 * 例如，[2,3,1,4] 的中位数是 2 ，[8,4,3,5,1] 的中位数是 4 。
 * 子数组是数组中的一个连续部分。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,1,4,5], k = 4
 * 输出：3
 * 解释：中位数等于 4 的子数组有：[4]、[4,5] 和 [1,4,5] 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,3,1], k = 3
 * 输出：1
 * 解释：[3] 是唯一一个中位数等于 3 的子数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i], k <= n
 * nums 中的整数互不相同
 *
 * @author simple
 */
public class CountSubarraysWithMedianK {
    public int countSubarrays(int[] nums, int k) {
        int len = nums.length;
        var kIndex = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] == k) {
                kIndex = i;
                break;
            }
        }
        int ans = 0;
        Map<Integer, Integer> counts = new HashMap<>(); // <前缀和，次数>
        counts.put(0, 1); // 前缀和 0， 次数 1
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += sign(nums[i] - k);
            if (i < kIndex) { // 只需要前kIndex个
                counts.put(sum, counts.getOrDefault(sum, 0) + 1);
            } else {
                int prev0 = counts.getOrDefault(sum, 0); // 前缀和是sum的子数组个数
                int prev1 = counts.getOrDefault(sum - 1, 0); // 偶数取左边，所以sum-1: 多一个比k小的在数组里
                ans += prev0 + prev1;
            }
        }
        return ans;
    }

    public int sign(int num) {
        if (num == 0) {
            return 0;
        }
        return num > 0 ? 1 : -1;
    }


    // 超时
    public int countSubarrays2(int[] nums, int k) {
        int len = nums.length;
        var midIndex = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] == k) {
                midIndex = i;
                break;
            }
        }
        int cnt = 0;
        for (int i = 0; i <= midIndex; i++) {
            for (int j = len; j > midIndex; j--) {
                var tmp = Arrays.copyOfRange(nums, i, j);
                Arrays.sort(tmp);
                int m = tmp.length % 2 == 0 ? (tmp.length / 2) - 1 : tmp.length / 2;
                if (tmp[m] == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new CountSubarraysWithMedianK().countSubarrays(new int[]{2, 5, 1, 4, 3, 6}, 1)); // 3
        System.out.println(new CountSubarraysWithMedianK().countSubarrays(new int[]{3, 2, 1, 4, 5}, 4)); // 3
    }

}
