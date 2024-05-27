package easy.string;

/**
 * 2609. 最长平衡子字符串
 * 给你一个仅由 0 和 1 组成的二进制字符串 s 。
 * <p>
 * 如果子字符串中 所有的 0 都在 1 之前 且其中 0 的数量等于 1 的数量，则认为 s 的这个子字符串是平衡子字符串。请注意，空子字符串也视作平衡子字符串。
 * <p>
 * 返回  s 中最长的平衡子字符串长度。
 * <p>
 * 子字符串是字符串中的一个连续字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "01000111"
 * 输出：6
 * 解释：最长的平衡子字符串是 "000111" ，长度为 6 。
 * 示例 2：
 * <p>
 * 输入：s = "00111"
 * 输出：4
 * 解释：最长的平衡子字符串是 "0011" ，长度为  4 。
 * 示例 3：
 * <p>
 * 输入：s = "111"
 * 输出：0
 * 解释：除了空子字符串之外不存在其他平衡子字符串，所以答案为 0 。
 * <p>
 * <p>
 * 提示：
 * 1 <= s.length <= 50
 * '0' <= s[i] <= '1'
 *
 * @author simple
 */
public class FindTheLongestBalancedSubstringOfABinaryString {
    public int findTheLongestBalancedSubstring(String s) {
        int res = 0, idx = 0, n = s.length();
        while (idx < n) {
            int a = 0, b = 0;
            while (idx < n && s.charAt(idx) == '0' && ++a > 0) idx++;
            while (idx < n && s.charAt(idx) == '1' && ++b > 0) idx++;
            res = Math.max(res, Math.min(a, b) * 2);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FindTheLongestBalancedSubstringOfABinaryString().findTheLongestBalancedSubstring("01000111"));
    }
}