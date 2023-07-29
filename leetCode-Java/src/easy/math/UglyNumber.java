package easy.math;

/**
 * 263. 丑数
 * 丑数 就是只包含质因数 2、3 和 5 的正整数。
 * <p>
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：true
 * 解释：1 没有质因数，因此它的全部质因数是 {2, 3, 5} 的空集。习惯上将其视作第一个丑数。
 * 示例 3：
 * <p>
 * 输入：n = 14
 * 输出：false
 * 解释：14 不是丑数，因为它包含了另外一个质因数 7 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * -231 <= n <= 231 - 1
 *
 * @author simple
 */
public class UglyNumber {
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        int[] factors = new int[]{2, 3, 5};
        for (int i : factors) {
            // 重复除去 2，3，5； 因为如果时丑数则 x = 2^a * 3^b * 5^c, 最终数字会为 1
            while (n % i == 0) {
                n /= i;
            }
        }
        return n == 1;
    }
}
