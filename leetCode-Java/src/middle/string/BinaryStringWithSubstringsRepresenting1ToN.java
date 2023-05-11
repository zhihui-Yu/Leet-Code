package middle.string;

/**
 * 1016. 子串能表示从 1 到 N 数字的二进制串
 * 给定一个二进制字符串 s 和一个正整数 n，如果对于 [1, n] 范围内的每个整数，其二进制表示都是 s 的 子字符串 ，就返回 true，否则返回 false 。
 * <p>
 * 子字符串 是字符串中连续的字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "0110", n = 3
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "0110", n = 4
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s[i] 不是 '0' 就是 '1'
 * 1 <= n <= 10^9
 *
 * @author simple
 */
public class BinaryStringWithSubstringsRepresenting1ToN {
    public boolean queryString(String s, int n) {
        // 由于s的长度只有 1000，所以n的最大值被限制了
        for (int i = n; i > n / 2; i--) {
            if (!s.contains(Integer.toBinaryString(i))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryStringWithSubstringsRepresenting1ToN().queryString("1111000101", 5)); // true
        System.out.println(new BinaryStringWithSubstringsRepresenting1ToN().queryString("0110", 4));
        System.out.println(new BinaryStringWithSubstringsRepresenting1ToN().queryString("0110", 3));
    }
}
