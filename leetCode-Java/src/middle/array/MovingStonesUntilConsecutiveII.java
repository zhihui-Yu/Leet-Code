package middle.array;

import java.util.Arrays;

/**
 * 1040. 移动石子直到连续 II
 * 在一个长度 无限 的数轴上，第 i 颗石子的位置为 stones[i]。如果一颗石子的位置最小/最大，那么该石子被称作 端点石子 。
 * <p>
 * 每个回合，你可以将一颗端点石子拿起并移动到一个未占用的位置，使得该石子不再是一颗端点石子。
 * <p>
 * 值得注意的是，如果石子像 stones = [1,2,5] 这样，你将 无法 移动位于位置 5 的端点石子，因为无论将它移动到任何位置（例如 0 或 3），该石子都仍然会是端点石子。
 * <p>
 * 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。
 * <p>
 * 要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_moves] 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[7,4,9]
 * 输出：[1,2]
 * 解释：
 * 我们可以移动一次，4 -> 8，游戏结束。
 * 或者，我们可以移动两次 9 -> 5，4 -> 6，游戏结束。
 * 示例 2：
 * <p>
 * 输入：[6,5,4,3,10]
 * 输出：[2,3]
 * 解释：
 * 我们可以移动 3 -> 8，接着是 10 -> 7，游戏结束。
 * 或者，我们可以移动 3 -> 7, 4 -> 8, 5 -> 9，游戏结束。
 * 注意，我们无法进行 10 -> 2 这样的移动来结束游戏，因为这是不合要求的移动。
 * 示例 3：
 * <p>
 * 输入：[100,101,104,102,103]
 * 输出：[0,0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= stones.length <= 10^4
 * 1 <= stones[i] <= 10^9
 * stones[i] 的值各不相同。
 *
 * @author simple
 */
public class MovingStonesUntilConsecutiveII {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);

        int n = stones.length;
        int d = stones[n - 1] - stones[0] + 1; // 总长度

        // 没有空格
        if (d == n) return new int[]{0, 0};

        // n-1:在区间内只有n-1个石头，因为stones[0]没有算进去
        int d1 = stones[n - 1] - stones[1] + 1 - (n - 1); // 1..n 的空白位置有多少
        int d2 = stones[n - 2] - stones[0] + 1 - (n - 1); // 0...n-1的空白位置有多少
        int max = Math.max(d1, d2); //  左右两边空格数对比，空格数多的移动次数就多。

        int min = n;
        for (int left = 0, right = 0; right < n; right++) { // 滑动窗口，固定长度遍历
            while (stones[right] - stones[left] + 1 > n) left++; // 保持窗口长度不超过n
            if (right - left + 1 == n - 1 && stones[right] - stones[left] + 1 == n - 1) { // 第一个判断是已存在的石子==只有一个石子不连续， 第二个是已占用位置==总位置-1
                min = Math.min(2, min);  // 特殊情况：只有一个石子不连续且空格大于1, 虽然[2, 3, 4, 5, 6, 8]会命中, 但是会在else中被判断为1
            } else {
                min = Math.min(min, n - (right - left + 1)); // 总石子数 - 窗口内的石子数 = 空格数，既需要移动的次数
            }
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MovingStonesUntilConsecutiveII().numMovesStonesII(new int[]{1,2, 3, 4, 5, 6, 8})));
        System.out.println(Arrays.toString(new MovingStonesUntilConsecutiveII().numMovesStonesII(new int[]{7, 4, 9})));
    }
}
