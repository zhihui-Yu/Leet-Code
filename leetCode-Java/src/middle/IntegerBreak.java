package middle;

/**
 * @author simple
 * <p>
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * <p>
 * 返回 你可以获得的最大乘积 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * <p>
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 2 <= n <= 58
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/integer-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n < 4) return n - 1;
        var x = n / 3;
        var y = n % 3;
        if (y == 1) return (int) Math.pow(3, x - 1) * 4;
        if (y == 0) return (int) Math.pow(3, x);
        return (int) Math.pow(3, x) * 2;
    }

    public static void main(String[] args) {
        System.out.println(new IntegerBreak().integerBreak(2));
        System.out.println(new IntegerBreak().integerBreak(10));
        System.out.println(new IntegerBreak().integerBreak(58));
    }
}
