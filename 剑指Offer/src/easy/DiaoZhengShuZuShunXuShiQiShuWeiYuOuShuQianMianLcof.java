package easy;

import java.util.Arrays;

/**
 * @author simple
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 * 示例：
 * <p>
 * 输入：nums =[1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {
    // 双指针 / 手尾指针
    public int[] exchange(int[] nums) {
        int oddPos = 0, evenPos = 0;
        while (evenPos < nums.length) {
            if (nums[evenPos] % 2 != 0) {
                int tmp = nums[evenPos];
                nums[evenPos] = nums[oddPos];
                nums[oddPos++] = tmp;
            }
            evenPos++;
        }
        //可能是申明的局部遍历回收了, 内存消耗就低了
        System.gc();
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().exchange(new int[]{1, 2, 3, 4})));
    }
}
