package easy;

/**
 * @author simple
 * <p>
 * 给你一个整数数组nums，请编写一个能够返回数组 “中心索引” 的方法。
 * <p>
 * 数组 中心索引 是数组的一个索引，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果数组不存在中心索引，返回 -1 。如果数组有多个中心索引，应该返回最靠近左边的那一个。
 * <p>
 * 注意：中心索引可能出现在数组的两端。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 * 示例 2：
 * <p>
 * 输入：nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心索引。
 * 示例 3：
 * <p>
 * 输入：nums = [2, 1, -1]
 * 输出：0
 * 解释：
 * 索引 0 左侧不存在元素，视作和为 0 ；右侧数之和为 1 + (-1) = 0 ，二者相等。
 * 示例 4：
 * <p>
 * 输入：nums = [0, 0, 0, 0, 1]
 * 输出：4
 * 解释：
 * 索引 4 左侧数之和为 0 ；右侧不存在元素，视作和为 0 ，二者相等。
 * <p>
 * <p>
 * 提示：
 * <p>
 * nums 的长度范围为[0, 10000]。
 * 任何一个nums[i] 将会是一个范围在[-1000, 1000]的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-pivot-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0, rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += nums[j];
            }
            for (int j = i + 1; j < nums.length; j++) {
                rightSum += nums[j];
            }
            if (leftSum - rightSum == 0) return i;
        }
        return -1;
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/find-pivot-index/solution/xun-zhao-shu-zu-de-zhong-xin-suo-yin-by-gzjle/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//    public int pivotIndex(int[] nums) {
//        int total = Arrays.stream(nums).sum();
//        int sum = 0;
//        for (int i = 0; i < nums.length; ++i) {
//            if (2 * sum + nums[i] == total) {
//                return i;
//            }
//            sum += nums[i];
//        }
//        return -1;
//    }
}
