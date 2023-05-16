package hard.array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 739. 每日温度
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 示例 1:
 * <p>
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 * <p>
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 * <p>
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 *
 * @author simple
 */
public class DailyTemperatures {
    // 单调栈：维护一个单调递减/增的栈，可以求出下一跳最大值或最小值
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                var prev = stack.pop(); // 上一个比当前数小的下标
                ans[prev] = i - prev;
            }
            stack.push(i);
        }
        return ans;
    }

    // 超时
    public int[] dailyTemperatures_timeout(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int next = i + 1;
            while (next < n && temperatures[i] >= temperatures[next]) next++;
            ans[i] = next == n ? 0 : next - i;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70})));
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
