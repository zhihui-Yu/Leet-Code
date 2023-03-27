package middle.string;

/**
 * 1638. 统计只差一个字符的子串数目
 * 给你两个字符串 s 和 t ，请你找出 s 中的非空子串的数目，这些子串满足替换一个不同字符以后，是 t 串的子串。
 * 换言之，请你找到 s 和 t 串中恰好 只有一个字符不同的子字符串对的数目。
 * <p>
 * 比方说， "computer" and "computation" 只有一个字符不同： 'e'/'a' ，所以这一对子字符串会给答案加 1 。
 * <p>
 * 请你返回满足上述条件的不同子字符串对数目。
 * <p>
 * 一个 子字符串 是一个字符串中连续的字符。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aba", t = "baba"
 * 输出：6
 * <p>
 * 示例 2：
 * 输入：s = "ab", t = "bb"
 * 输出：3
 * 示例 3：
 * 输入：s = "a", t = "a"
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：s = "abe", t = "bbc"
 * 输出：10
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, t.length <= 100
 * s 和 t 都只包含小写英文字母。
 *
 * @author simple
 */
public class CountSubstringsThatDifferByOneCharacter {
    public int countSubstrings(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int ans = 0;
        for (int i = 0; i < tLen; i++) {
            for (int j = 0; j < sLen; j++) {
                int diff = 0;
                for (int k = 0; k + i < tLen && k + j < sLen; k++) {
                    if (s.charAt(k + j) != t.charAt(k + i)) diff++;
                    if (diff == 1) ans++;
                    else if (diff > 1) break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new CountSubstringsThatDifferByOneCharacter().countSubstrings("computer","computation"));
    }
}
