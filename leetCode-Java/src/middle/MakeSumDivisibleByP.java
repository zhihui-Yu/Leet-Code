package middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1590. 使数组和能被 P 整除
 * <p>
 * 给你一个正整数数组 nums，请你移除 最短 子数组（可以为 空），使得剩余元素的 和 能被 p 整除。 不允许 将整个数组都移除。
 * <p>
 * 请你返回你需要移除的最短子数组的长度，如果无法满足题目要求，返回 -1 。
 * <p>
 * 子数组 定义为原数组中连续的一组元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,1,4,2], p = 6
 * 输出：1
 * 解释：nums 中元素和为 10，不能被 p 整除。我们可以移除子数组 [4] ，剩余元素的和为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [6,3,5,2], p = 9
 * 输出：2
 * 解释：我们无法移除任何一个元素使得和被 9 整除，最优方案是移除子数组 [5,2] ，剩余元素为 [6,3]，和为 9 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3], p = 3
 * 输出：0
 * 解释：和恰好为 6 ，已经能被 3 整除了。所以我们不需要移除任何元素。
 * 示例  4：
 * <p>
 * 输入：nums = [1,2,3], p = 7
 * 输出：-1
 * 解释：没有任何方案使得移除子数组后剩余元素的和被 7 整除。
 * 示例 5：
 * <p>
 * 输入：nums = [1000000000,1000000000,1000000000], p = 3
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= p <= 109
 *
 * @author simple
 */
public class MakeSumDivisibleByP {
    // 前缀和：计算出每个数组的前缀和，然后计算哪两个最近的数字之差等于 sum(nums) % p，两数下标既为结果
    public int minSubarray(int[] nums, int p) {
        int k = 0; // = sum(nums) % p
        for (int x : nums) {
            k = (k + x) % p;
        }
        if (k == 0) {
            return 0;
        }
        Map<Integer, Integer> last = new HashMap<>(); // key: sum(nums[0..i]) mod p 的值, value: 下标 i
        last.put(0, -1); // 需要全部移除，当且仅当cur-k=0时，target=0，同时由于cur=k，所以是全部移除
        int n = nums.length;
        int ans = n;
        int cur = 0;
        // 计算每个子数组中最小符合条件长度
        for (int i = 0; i < n; ++i) {
            cur = (cur + nums[i]) % p;  // sum(nums[0..i]) mod p
            // 想要 (p-[k-cur]-target) % p == 0, 需要知道target的下标
            int target = (cur - k + p) % p; // cur - k <= p, 所以 + p； 如果 (x-y) mod p = 0, 则 x mod p = y
             if (last.containsKey(target)) {
                ans = Math.min(ans, i - last.get(target)); // i - last.get(target): 当前坐标 - target 坐标
            }
            last.put(cur, i);
        }
        return ans == n ? -1 : ans;
    }

    // 超时
    public int baoLi(int[] nums, int p) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] %= p;
            sum += nums[i];
        }
        if (sum % p == 0) return 0;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                int tmp = Arrays.stream(nums).boxed().toList().subList(j, j + i + 1).stream().reduce(0, Integer::sum);
                if ((sum - tmp) % p == 0) {
                    return i + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new MakeSumDivisibleByP().minSubarray(new int[]{6, 3, 5, 2}, 9)); // 2
        System.out.println(new MakeSumDivisibleByP().minSubarray(new int[]{3 , 1, 4, 2}, 6)); // 1
        System.out.println(new MakeSumDivisibleByP().minSubarray(new int[]{1, 2, 3}, 3)); // 0
        System.out.println(new MakeSumDivisibleByP().minSubarray(new int[]{1, 2, 3}, 7)); // -1
    }
}
