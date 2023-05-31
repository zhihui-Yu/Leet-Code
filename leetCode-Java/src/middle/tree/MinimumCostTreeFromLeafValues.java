package middle.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1130. 叶值的最小代价生成树
 * <p>
 * 给你一个正整数数组 arr，考虑所有满足以下条件的二叉树：
 * <p>
 * 每个节点都有 0 个或是 2 个子节点。
 * 数组 arr 中的值与树的中序遍历中每个叶节点的值一一对应。
 * 每个非叶节点的值等于其左子树和右子树中叶节点的最大值的乘积。
 * 在所有这样的二叉树中，返回每个非叶节点的值的最小可能总和。这个和的值是一个 32 位整数。
 * <p>
 * 如果一个节点有 0 个子节点，那么该节点为叶节点。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：arr = [6,2,4]
 * 输出：32
 * 解释：有两种可能的树，第一种的非叶节点的总和为 36 ，第二种非叶节点的总和为 32 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：arr = [4,11]
 * 输出：44
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= arr.length <= 40
 * 1 <= arr[i] <= 15
 * 答案保证是一个 32 位带符号整数，即小于 2^31 。
 *
 * @author simple
 */
public class MinimumCostTreeFromLeafValues {
    // 前提： 由于一个节点只有0个或2个节点，并且非叶节点值为左右子树的最大值相乘，想取非叶节点最小和
    // 则： 需要将数组中相邻两个值最小的合并成一个值，一直到数组只有一个值。就是答案。 不需要处理构造树是否合理的问题。
    // 原因： 最小相邻值当左右子树，则非叶节点值最小
    public int mctFromLeafValues(int[] arr) {
        // 单调栈： 单调递减
        // - 如果 top <= x, top出站，x入栈，节点和+= top*x
        //   - 如果 [5,4,6],则5,4入栈后，6要入栈时：4出，6入。因为 5，4是一个节点的左右子树，保留最大值即可
        // - 如果 top > x, 入栈
        int sum = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int x : arr) {
            while (!stack.isEmpty() && stack.peek() <= x) {
                int top = stack.pop();
                sum += stack.isEmpty() || stack.peek() > x ? top * x : top * stack.peek();
            }
            stack.push(x);
        }

        while (stack.size() >= 2) { // case: [5,4,3,2,1]  恰好不会触发任何单调栈逻辑，最后从后往前合并就是答案。
            sum += stack.pop() * stack.peek();
        }
        return sum;
    }
}
