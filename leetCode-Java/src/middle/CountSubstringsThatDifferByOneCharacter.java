package middle;

/**
 * @author simple
 * <p>
 * 给你两个字符串s 和t，请你找出 s中的非空子串的数目，这些子串满足替换 一个不同字符以后，是 t串的子串。换言之，请你找到 s和 t串中 恰好只有一个字符不同的子字符串对的数目。
 * <p>
 * 比方说，"computer" 和"computation" 加粗部分只有一个字符不同：'e'/'a'，所以这一对子字符串会给答案加 1 。
 * <p>
 * 请你返回满足上述条件的不同子字符串对数目。
 * <p>
 * 一个 子字符串是一个字符串中连续的字符。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aba", t = "baba"
 * 输出：6
 * 解释：以下为只相差 1 个字符的 s 和 t 串的子字符串对：
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * 加粗部分分别表示 s 和 t 串选出来的子字符串。
 * 示例 2：
 * 输入：s = "ab", t = "bb"
 * 输出：3
 * 解释：以下为只相差 1 个字符的 s 和 t 串的子字符串对：
 * ("ab", "bb")
 * ("ab", "bb")
 * ("ab", "bb")
 * 加粗部分分别表示 s 和 t 串选出来的子字符串。
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
 * s 和t都只包含小写英文字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-substrings-that-differ-by-one-character
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountSubstringsThatDifferByOneCharacter {
    public int countSubstrings(String t, String s) {
        int sLen = s.length();
        int tLen = t.length();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int res = 0, diff;
        // aa bb
        for (int i = 0; i < tLen; i++) {
            for (int j = 0; j < sLen; j++) {
                diff = 0;
                for (int k = 0; k + i < tLen && k + j < sLen; k++) {
                    // 先找到第一个字符串不同的地方，如果后面字符串是相同，则结果可加一,不相同则结果加一然后退出进行下一个字符串比较
                    if (sChars[j + k] != tChars[i + k]) diff++;
                    // 如： abb bbb
                    if (diff == 1) res++;
                    if (diff > 1) break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new CountSubstringsThatDifferByOneCharacter().countSubstrings("aba", "baba");
    }
    /**
     * A: abb B: bbb
     *
     * A -> 0, B -> 0
     * a != b res++
     * b = b  res++
     * b = b  res++
     * size = A.size  break;
     *
     * A -> 0, B -> 1
     * a != b res++
     * b = b  res++
     * size + 1 = B.size break;
     *
     * A -> 0, B -> 2
     * a != b res++
     * size + 2 = B.size break;
     *
     * A -> 1, B -> 0
     * b = b
     * b = b
     * size + 1 = A.size break;
     *
     * A -> 1, B -> 1
     * b = b
     * b = b
     * size + 1 = B.size break;
     *
     * A -> 1, B -> 2
     * b = b
     * size + 2 = B.size break;
     *
     * A -> 2, B -> 0
     * b = b
     * size + 2 = A.size break;
     *
     */
}
