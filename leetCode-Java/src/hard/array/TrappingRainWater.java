package hard.array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 1 <= n <= 2 * 10^4
 * 0 <= height[i] <= 10^5
 *
 * @author simple
 */
public class TrappingRainWater {
    // 单调栈: 维护数组下标的单调递增栈，如果可以接雨水，则必有 stack(倒数第二个)[left] > stack(最后一个)[mid] < current， 通过三者下标可以算出宽高，从而计算雨水数量
    // width = right - left - 1, height = min(right,left) - mid
    public int trap(int[] height) {
        int n = height.length;
        Deque<Integer> stack = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                // 如果stack只有一个下标，且下标对应得height < 当前height[i], 说明stack中的下标无用，需要被出栈。 不出栈会死循环，且计算出的结果也一定会是0
                var mid = stack.pop();
                if (stack.isEmpty()) break;

                int left = stack.peek();
                int width = i - left - 1;
                int h = Math.min(height[i], height[left]) - height[mid];
                ans += h * width;
            }
            stack.push(i);
        }
        return ans;
    }

    // 双指针遍历[速度更快]： 维护 leftMax， rightMax, 如果 leftMax<rightMax,则left++，否则right++
    // leftRain = leftMax - height[left]
    // rightRain = rightMax - height[right]
    // 前提：保证右侧高度大于左侧，才能使用上述计算左右侧的雨量
    public int trap_v2(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int ans = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
