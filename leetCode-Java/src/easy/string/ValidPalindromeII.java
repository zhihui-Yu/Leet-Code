package easy.string;

/**
 * 680. 验证回文串 II
 * 给你一个字符串 s，最多 可以从中删除一个字符。
 * <p>
 * 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aba"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "abca"
 * 输出：true
 * 解释：你可以删除字符 'c' 。
 * 示例 3：
 * <p>
 * 输入：s = "abc"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 由小写英文字母组成
 *
 * @author simple
 */
public class ValidPalindromeII {
    boolean cut = false;

    public boolean validPalindrome(String s) {
        for (int left = 0, right = s.length() - 1; left < right; ) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else if (!cut) {
                cut = true;
                return validPalindrome(s.substring(left + 1, right + 1)) || validPalindrome(s.substring(left, right));
            } else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindromeII().validPalindrome("ebcbbececabbacecbbcbe"));
        System.out.println(new ValidPalindromeII().validPalindrome("abac"));
    }
}
