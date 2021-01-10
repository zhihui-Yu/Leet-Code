package middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author simple
 * <p>
 * 你有一个单词列表words和一个模式pattern，你想知道 words 中的哪些单词与模式匹配。
 * <p>
 * 如果存在字母的排列 p，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
 * <p>
 * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
 * <p>
 * 返回 words 中与给定模式匹配的单词列表。
 * <p>
 * 你可以按任何顺序返回答案。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * 输出：["mee","aqq"]
 * 解释：
 * "mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
 * "ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
 * 因为 a 和 b 映射到同一个字母。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 50
 * 1 <= pattern.length = words[i].length<= 20
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-and-replace-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern)) res.add(word);
        }
        return res;
    }

    /**
     * example : word ecc, pattern abb
     * wordToPattern:{e -> a, c -> b}
     * patternToWord:{a -> e, b ->c}
     * 如果映射关系有改变则说明是不匹配的
     *
     * @param word 当前需要匹配的字符
     * @param pattern 匹配的规则
     * @return return true if match
     */
    private boolean match(String word, String pattern) {
        // 在可以确定的条件下 可能用数组更加快速
        Map<Character, Character> wordToPattern = new HashMap<>();
        Map<Character, Character> patternToWord = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!wordToPattern.containsKey(w)) wordToPattern.put(w, p);
            if (!patternToWord.containsKey(p)) patternToWord.put(p, w);
            if (wordToPattern.get(w) != p || patternToWord.get(p) != w) return false;
        }
        return true;
    }
}
