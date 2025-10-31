package easy;

import java.util.Arrays;

/**
 * 3289. 数字小镇中的捣蛋鬼
 * <p>
 * 数字小镇 Digitville 中，存在一个数字列表 nums，其中包含从 0 到 n - 1 的整数。每个数字本应 只出现一次，然而，有 两个 顽皮的数字额外多出现了一次，使得列表变得比正常情况下更长。
 * <p>
 * 为了恢复 Digitville 的和平，作为小镇中的名侦探，请你找出这两个顽皮的数字。
 * <p>
 * 返回一个长度为 2 的数组，包含这两个数字（顺序任意）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [0,1,1,0]
 * <p>
 * 输出： [0,1]
 * <p>
 * 解释：
 * <p>
 * 数字 0 和 1 分别在数组中出现了两次。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [0,3,2,1,3,2]
 * <p>
 * 输出： [2,3]
 * <p>
 * 解释:
 * <p>
 * 数字 2 和 3 分别在数组中出现了两次。
 * <p>
 * 示例 3：
 * <p>
 * 输入： nums = [7,1,5,4,3,4,6,0,9,5,8,2]
 * <p>
 * 输出： [4,5]
 * <p>
 * 解释:
 * <p>
 * 数字 4 和 5 分别在数组中出现了两次。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 100
 * <p>
 * nums.length == n + 2
 * <p>
 * 0 <= nums[i] < n
 * <p>
 * 输入保证 nums 中 恰好 包含两个重复的元素。
 *
 * @author simple
 */
public class TheTwoSneakyNumbersOfDigitville {
    public int[] getSneakyNumbers(int[] nums) {
        Arrays.sort(nums);
        int[] ans = new int[2];
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                ans[index++] = nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TheTwoSneakyNumbersOfDigitville().getSneakyNumbers(new int[]{0, 1, 1, 0})));
    }
}
