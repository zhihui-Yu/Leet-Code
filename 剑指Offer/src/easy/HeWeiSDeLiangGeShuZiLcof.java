package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author simple
 * <p>
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 * <p>
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i]<= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HeWeiSDeLiangGeShuZiLcof {
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        for (int i : nums) {
            if (set.contains(target - i)) return new int[]{i, target - i};
        }
        return new int[0];

        // 双指针解法
//        int i = 0, j = nums.length - 1;
//        while(i < j) {
//            int s = nums[i] + nums[j];
//            if(s < target) i++;
//            else if(s > target) j--;
//            else return new int[] { nums[i], nums[j] };
//        }
//        return new int[0];
    }
}
