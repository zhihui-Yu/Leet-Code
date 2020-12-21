package easy;

/**
 * @author simple
 * <p>
 * 给你一个字符串s，它由数字（'0' - '9'）和'#'组成。我们希望按下述规则将s映射为一些小写英文字符：
 * <p>
 * 字符（'a' - 'i'）分别用（'1' -'9'）表示。
 * 字符（'j' - 'z'）分别用（'10#'-'26#'）表示。
 * 返回映射之后形成的新字符串。
 * <p>
 * 题目数据保证映射始终唯一。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "10#11#12"
 * 输出："jkab"
 * 解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 * 示例 2：
 * <p>
 * 输入：s = "1326#"
 * 输出："acz"
 * 示例 3：
 * <p>
 * 输入：s = "25#"
 * 输出："y"
 * 示例 4：
 * <p>
 * 输入：s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
 * 输出："abcdefghijklmnopqrstuvwxyz"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s[i] 只包含数字（'0'-'9'）和'#'字符。
 * s是映射始终存在的有效字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DecryptStringFromAlphabetToIntegerMapping {
    public String freqAlphabets(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int num = i + 2 < s.length() && s.charAt(i + 2) == '#' ? (ch - '0') * 10 + (s.charAt(i + 1) - '0') : (ch - '0');
            res.append((char) ('a' + num - 1));
            if (num >= 10) i += 2;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        new DecryptStringFromAlphabetToIntegerMapping().freqAlphabets("10#11#12");
    }
}
