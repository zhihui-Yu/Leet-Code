package middle.math;

/**
 * 1017. 负二进制转换
 * 给你一个整数 n ，以二进制字符串的形式返回该整数的 负二进制（base -2）表示。
 * <p>
 * 注意，除非字符串就是 "0"，否则返回的字符串中不能含有前导零。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出："110"
 * 解释：(-2)^2 + (-2)^1 = 2
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出："111"
 * 解释：(-2)^2 + (-2)^1 + (-2)^0 = 3
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出："100"
 * 解释：(-2)^2 = 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 10^9
 *
 * @author simple
 */
public class ConvertToBase2 {
    public String baseNeg2_1(int n) {
        if (n == 0) return "0";
        int k = 1; // 第0位是偶数，所以是1而不是-1
        StringBuilder ans = new StringBuilder();
        while (n > 0) {
            if (n % 2 != 0) { //
                ans.append("1");
                n -= k; // 偶数倍(2^i = 2^i)，奇数倍 (2^i = 2^(i+1) - 2^i)
            } else {
                ans.append("0");
            }
            k *= -1; // 奇偶位
            n /= 2;
        }
        return ans.reverse().toString();
    }

    public String baseNeg2(int n) {
        StringBuilder ans = new StringBuilder();
        while (n != 0) {
            ans.append(n & 1); // 是否2的倍数，是为0，不是为1
            n = -(n >> 1); // 负数的二进制是 正数补码： 正数反码+1
        }
        return ans.isEmpty() ? "0" : ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println((-3>>1));
        System.out.println(-3/-2);
        System.out.println(new ConvertToBase2().baseNeg2_1(6)); // 11010 110->
        System.out.println(new ConvertToBase2().baseNeg2(6));
        System.out.println(new ConvertToBase2().baseNeg2(1));
        System.out.println(new ConvertToBase2().baseNeg2(2));
        System.out.println(new ConvertToBase2().baseNeg2(3));
        System.out.println(new ConvertToBase2().baseNeg2(4));
    }
}
