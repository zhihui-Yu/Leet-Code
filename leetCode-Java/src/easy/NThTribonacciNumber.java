package easy;

/**
 * @author simple
 * <p>
 * 泰波那契序列Tn定义如下：
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 给你整数n，请返回第 n 个泰波那契数Tn 的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 * <p>
 * 输入：n = 25
 * 输出：1389537
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即answer <= 2^31 - 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-th-tribonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NThTribonacciNumber {
    public int tribonacci(int n) {
//        递归  (但超出题目的内存限制)
//        if (n == 0) return 0;
//        else if (n <= 2) return 1;
//        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);

        if (n <= 2) return n == 0 ? 0 : 1;
        int k0 = 0, k1 = 1, k2 = 1;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = k0 + k1 + k2;
            k0 = k1;
            k1 = k2;
            k2 = temp;
        }
        return temp;
    }
}
