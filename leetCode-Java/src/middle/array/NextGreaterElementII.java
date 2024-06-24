package middle.array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 * <p>
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 示例 2:
 * <p>
 * 输入: nums = [1,2,3,4,3]
 * 输出: [2,3,4,-1,4]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 *
 * @author simple
 */
public class NextGreaterElementII {
    // 单调栈
    public int[] nextGreaterElements_2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        // 存储下标
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < 2 * n - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ans[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ans;
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n + i + 1; j++) {
                if (nums[i] < nums[(j + n) % n]) {
                    ans[i] = nums[(j + n) % n];
                    break;
                }
                if (j == n + i) {
                    ans[i] = -1;
                }
            }
        }
        return ans;
    }
}
