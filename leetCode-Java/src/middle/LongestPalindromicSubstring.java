package middle;

import java.util.ArrayList;
import java.util.List;

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
        return s.substring(maxIndex, maxIndex + dp[maxIndex][1]);
    }

    private int calculate(String s) {
        int begin = 0, end = s.length() - 1;

        int[] indexes = new int[end + 1];
        int k = 0;
        for (int i = end; i > 0; i--) {
            if (s.charAt(i) == s.charAt(0)) {
                indexes[k++] = i;
            }
        }
        // like : abcacba
        // begin : search the first a
        // end : search the last a
        // compare the the next is equal or not, if not the end search the previous a
        // if the end <= begin the break, and the len is 1
        int equalCount = 0;
        int validEnd = 0;
        k = 0;
        while (begin <= end) {
            if (s.charAt(begin) == s.charAt(end)) { //bacabab
                if (++equalCount == 1) {            //0123456
                    validEnd = end;
                }
                begin++;
                end--;
            } else {
                equalCount = 0;
                validEnd = 0;
                begin = 0;
                end = indexes[k++];
            }
        }
        return validEnd + 1;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("bacabab"));
    }

    // Manacher 算法
    public String longestPalindromeV2(String s) {
        int start = 0, end = -1;
        StringBuffer t = new StringBuffer("#");
        for (int i = 0; i < s.length(); ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        t.append('#');
        s = t.toString();

        List<Integer> arm_len = new ArrayList<Integer>();
        int right = -1, j = -1;
        for (int i = 0; i < s.length(); ++i) {
            int cur_arm_len;
            if (right >= i) {
                int i_sym = j * 2 - i;
                int min_arm_len = Math.min(arm_len.get(i_sym), right - i);
                cur_arm_len = expand(s, i - min_arm_len, i + min_arm_len);
            } else {
                cur_arm_len = expand(s, i, i);
            }
            arm_len.add(cur_arm_len);
            if (i + cur_arm_len > right) {
                j = i;
                right = i + cur_arm_len;
            }
            if (cur_arm_len * 2 + 1 > end - start) {
                start = i - cur_arm_len;
                end = i + cur_arm_len;
            }
        }

        StringBuffer ans = new StringBuffer();
        for (int i = start; i <= end; ++i) {
            if (s.charAt(i) != '#') {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    public int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return (right - left - 2) / 2;
    }
}
