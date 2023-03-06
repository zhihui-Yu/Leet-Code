package middle;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * <p>
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 1000
 * 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
 *
 * @author simple
 */
public class JianShengZi2Lcof {

    // 将绳子尽可能分成大小为3的n段，剩余尽可能分成大小为2的x段
    public int cuttingRope(int n) {

        if (n < 4) return n - 1;

        int p1; // 几个三
        int p2; // 要乘的余数

        int x = n / 3; // 能分成几个3
        int y = n % 3; // 分完的余数是多少
        int z = y / 2; // 余数可以分几个2

        if (y == 1) { // 如果余数是1，则最优是将一个 3 和一个 1 组合成 4.
            p1 = x - 1;
            p2 = 4;
        } else { // 0和1，既 p2 = 1 或者 2
            p1 = x;
            p2 = (int) Math.pow(2, z);
        }

        return pow(p2, 3, p1);
    }

    public int pow(int base, int x, int y) {
        long res = base;
        for (int i = 0; i < y; i++) {
            res *= x;
            res %= 1000000007;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        // 使用BigInteger可以解决大数问题
        System.out.println(BigInteger.valueOf(3).pow(41).multiply(BigInteger.valueOf(4)).mod(BigInteger.valueOf(1000000007)));

        System.out.println(new JianShengZi2Lcof().cuttingRope(2));  // 1
        System.out.println(new JianShengZi2Lcof().cuttingRope(3));  // 2
        System.out.println(new JianShengZi2Lcof().cuttingRope(10)); // 36
        System.out.println(new JianShengZi2Lcof().cuttingRope(120)); // 953271190
        System.out.println(new JianShengZi2Lcof().cuttingRope(127)); // 439254203
    }
}
