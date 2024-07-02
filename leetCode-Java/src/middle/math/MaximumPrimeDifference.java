package middle.math;

/**
 * 3115. 质数的最大距离
 * 给你一个整数数组 nums。
 * 返回两个（不一定不同的）质数在 nums 中 下标 的 最大距离。
 * <p>
 * 示例 1：
 * 输入： nums = [4,2,9,5,3]
 * 输出： 3
 * 解释： nums[1]、nums[3] 和 nums[4] 是质数。因此答案是 |4 - 1| = 3。
 * <p>
 * 示例 2：
 * 输入： nums = [4,8,2,8]
 * 输出： 0
 * 解释： nums[2] 是质数。因为只有一个质数，所以答案是 |2 - 2| = 0。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 10^5
 * 1 <= nums[i] <= 100
 * 输入保证 nums 中至少有一个质数。
 *
 * @author simple
 */
public class MaximumPrimeDifference {
    // 质数: 同素数，除了1和自己外，不能被其他数相除
    public int maximumPrimeDifference(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (isPrimes(nums[i])) {
                for (int j = nums.length - 1; j >= i; j--) {
                    if (isPrimes(nums[j])) {
                        return j - i;
                    }
                }
            }
        }
        return -1;
    }

    private boolean isPrimes(int num) {
        if (num == 1) return false;
        if (num == 2) return true;
        for (int i = 2; i < 10; i++) {
            if (i != num && num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumPrimeDifference().maximumPrimeDifference(new int[]{4, 2, 9, 5, 3}));
        System.out.println(new MaximumPrimeDifference().maximumPrimeDifference(new int[]{4, 8, 2, 8}));
    }
}
