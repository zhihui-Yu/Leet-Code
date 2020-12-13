package easy;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author simple
 * <p>
 * 给你一个由不同字符组成的字符串allowed和一个字符串数组words。如果一个字符串的每一个字符都在 allowed中，就称这个字符串是 一致字符串。
 * <p>
 * 请你返回words数组中一致字符串的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * 输出：2
 * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
 * 示例 2：
 * <p>
 * 输入：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
 * 输出：7
 * 解释：所有字符串都是一致的。
 * 示例 3：
 * <p>
 * 输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
 * 输出：4
 * 解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 104
 * 1 <= allowed.length <= 26
 * 1 <= words[i].length <= 10
 * allowed中的字符 互不相同。
 * words[i] 和allowed只包含小写英文字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-the-number-of-consistent-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountTheNumberOfConsistentStrings {
    public static int countConsistentStrings(String allowed, String[] words) {
        Set<Integer> wordSet = new TreeSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            wordSet.add(allowed.charAt(i) - 'a');
        }

        int matchCount = 0;
        for (int i = 0; i < words.length; i++) {
            matchCount ++;
            for (int j = 0; j < words[i].length(); j++) {
                if (!wordSet.contains(words[i].charAt(j) - 'a')) {
                    matchCount--;
                    break;
                }
            }
        }
        return matchCount;
    }

    public static void main(String[] args) {
        countConsistentStrings("ab", new String[] {"ad","bd","aaab","baa","badab"});
    }
}
