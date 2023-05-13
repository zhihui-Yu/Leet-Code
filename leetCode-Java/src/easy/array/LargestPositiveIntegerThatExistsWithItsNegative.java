package easy.array;

import java.util.Arrays;

/**
 * 2441. 与对应负数同时存在的最大正整数
 * 给你一个 不包含 任何零的整数数组 nums ，找出自身与对应的负数都在数组中存在的最大正整数 k 。
 * <p>
 * 返回正整数 k ，如果不存在这样的整数，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,2,-3,3]
 * 输出：3
 * 解释：3 是数组中唯一一个满足题目要求的 k 。
 * 示例 2：
 * <p>
 * 输入：nums = [-1,10,6,7,-7,1]
 * 输出：7
 * 解释：数组中存在 1 和 7 对应的负数，7 的值更大。
 * 示例 3：
 * <p>
 * 输入：nums = [-10,8,6,7,-2,-3]
 * 输出：-1
 * 解释：不存在满足题目要求的 k ，返回 -1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * nums[i] != 0
 *
 * @author simple
 */
public class LargestPositiveIntegerThatExistsWithItsNegative {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        while (l != r) {
            if (nums[l] == -nums[r]) return nums[r];
            if (Math.abs(nums[l]) > nums[r]) l++;
            else r--;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new LargestPositiveIntegerThatExistsWithItsNegative().findMaxK(new int[]{-1, 2, -3, 3}));
        System.out.println(new LargestPositiveIntegerThatExistsWithItsNegative().findMaxK(new int[]{-1,10,6,7,-7,1}));
        System.out.println(new LargestPositiveIntegerThatExistsWithItsNegative().findMaxK(new int[]{-10,8,6,7,-2,-3}));
    }
}
