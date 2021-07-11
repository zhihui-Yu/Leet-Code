package easy;

/**
 * @author simple
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0, F(1)= 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FeiBoNaQiShuLieLcof {
    public int fib(int n) {
        // timeout
        //  if(n == 0) return 0;
        //  return n > 1 ? fib(n-1)+fib(n-2) : 1;

        if (n == 0) return 0;
        if (n == 1) return 1;
        int f1 = 0, f2 = 1, f3 = 1;
        for (int i = 2; i <= n; i++) {
            f3 = (f1 + f2) % 1000000007;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    public static void main(String[] args) {
        System.out.println(new FeiBoNaQiShuLieLcof().fib(0));
        System.out.println(new FeiBoNaQiShuLieLcof().fib(1));
        System.out.println(new FeiBoNaQiShuLieLcof().fib(2));
    }
}
