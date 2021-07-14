package easy;

/**
 * @author simple
 * <p>
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 示例:
 * <p>
 * s = "abaccdeff"
 * 返回 "b"
 * <p>
 * s = ""
 * 返回 " "
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DiYiGeZhiChuXianYiCiDeZiFuLcof {
    public char firstUniqueChar(String s) {
        if (s.length() == 0) return ' ';
        if (s.length() == 1) return s.charAt(0);
        char[] chars = s.toCharArray();
        // map 效率会更高点
        int[] letters = new int[26];
        for (char c : chars) {
            letters[c - 'a']++;
        }
        for (char c : chars) {
            if (letters[c - 'a'] == 1) return c;
        }
        return ' ';
    }
}
