package easy;

/**
 * @author simple
 * <p>
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * <p>
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <=arr.length <= 10^5
 * -100 <= arr[i] <= 100
 * 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LianXuZiShuZuDeZuiDaHeLcof {
    public int maxSubArray(int[] nums) {
        // F(x)max = max(f(x-1) + x, x)
        int f = 0, max = nums[0];
        for (int x : nums) {
            f = Math.max(f + x, x);
            max = Math.max(f, max);
        }
        return max;
    }

    public static void main(String[] args) {
        new LianXuZiShuZuDeZuiDaHeLcof().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }
}
