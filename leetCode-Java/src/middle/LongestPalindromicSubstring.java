package middle;

/**
 * @author simple
 * <p>
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * <p>
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ac"
 * 输出："a"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int len = s.length();
        int[][] dp = new int[len][2];
        for (int i = 0; i < len; i++) {
            dp[i][1] = calculate(s.substring(i, len));
        }
        int maxIndex = 0, maxVal = dp[maxIndex][1];
        for (int i = 1; i < len; i++) {
            if (maxVal < dp[i][1]) {
                maxVal = dp[i][1];
                maxIndex = i;
            }
        }
        return s.substring(maxIndex, dp[maxIndex][1]);
    }

    private int calculate(String s) {
        int begin = 0, end = 0;
        // like : abcacba
        // begin : search the first a
        // end : search the last a
        // compare the the next is equal or not, if not the end search the previous a
        // if the end <= begin the break, and the len is 1
        return 0;
    }
}
