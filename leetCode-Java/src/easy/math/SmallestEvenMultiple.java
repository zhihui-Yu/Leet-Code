package easy.math;

/**
 * 2413. 最小偶倍数
 * 给你一个正整数 n ，返回 2 和 n 的最小公倍数（正整数）。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5
 * 输出：10
 * 解释：5 和 2 的最小公倍数是 10 。
 * 示例 2：
 * <p>
 * 输入：n = 6
 * 输出：6
 * 解释：6 和 2 的最小公倍数是 6 。注意数字会是它自身的倍数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 150
 *
 * @author simple
 */
public class SmallestEvenMultiple {
    public int smallestEvenMultiple(int n) {
//        return (n & 1) != 0 ? n << 1 : n;
        return n << (n & 1); // 节省了分支判断
    }
}
