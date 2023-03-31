package easy.array;

import java.util.HashMap;

/**
 * 2367. 算术三元组的数目
 * 给你一个下标从 0 开始、严格递增的整数数组 nums 和一个正整数 diff 。如果满足下述全部条件，则三元组 (i, j, k) 就是一个 算术三元组 ：
 * <p>
 * i < j < k ，
 * nums[j] - nums[i] == diff 且
 * nums[k] - nums[j] == diff
 * 返回不同 算术三元组 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,4,6,7,10], diff = 3
 * 输出：2
 * 解释：
 * (1, 2, 4) 是算术三元组：7 - 4 == 3 且 4 - 1 == 3 。
 * (2, 4, 5) 是算术三元组：10 - 7 == 3 且 7 - 4 == 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,8,9], diff = 2
 * 输出：2
 * 解释：
 * (0, 2, 4) 是算术三元组：8 - 6 == 2 且 6 - 4 == 2 。
 * (1, 3, 5) 是算术三元组：9 - 7 == 2 且 7 - 5 == 2 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 200
 * 0 <= nums[i] <= 200
 * 1 <= diff <= 50
 * nums 严格 递增
 *
 * @author simple
 */
public class NumberOfArithmeticTriplets {
    public int arithmeticTriplets(int[] nums, int diff) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }

        int ans = 0;
        for (int i = 1; i < len; i++) {
            Integer left = map.getOrDefault(nums[i] - diff, -1);
            Integer right = map.getOrDefault(nums[i] + diff, -1);
            if (right != -1 && left != -1) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfArithmeticTriplets().arithmeticTriplets(new int[]{4, 5, 6, 7, 8, 9}, 2));
        System.out.println(new NumberOfArithmeticTriplets().arithmeticTriplets(new int[]{0, 1, 4, 6, 7, 10}, 3));
    }
}
