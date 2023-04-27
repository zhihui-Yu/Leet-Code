package middle.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 1048. 最长字符串链
 * 给出一个单词数组 words ，其中每个单词都由小写英文字母组成。
 * <p>
 * 如果我们可以 不改变其他字符的顺序 ，在 wordA 的任何地方添加 恰好一个 字母使其变成 wordB ，那么我们认为 wordA 是 wordB 的 前身 。
 * <p>
 * 例如，"abc" 是 "abac" 的 前身 ，而 "cba" 不是 "bcad" 的 前身
 * 词链是单词 [word_1, word_2, ..., word_k] 组成的序列，k >= 1，其中 word1 是 word2 的前身，word2 是 word3 的前身，依此类推。一个单词通常是 k == 1 的 单词链 。
 * <p>
 * 从给定单词列表 words 中选择单词组成词链，返回 词链的 最长可能长度 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["a","b","ba","bca","bda","bdca"]
 * 输出：4
 * 解释：最长单词链之一为 ["a","ba","bda","bdca"]
 * 示例 2:
 * <p>
 * 输入：words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
 * 输出：5
 * 解释：所有的单词都可以放入单词链 ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
 * 示例 3:
 * <p>
 * 输入：words = ["abcd","dbqca"]
 * 输出：1
 * 解释：字链["abcd"]是最长的字链之一。
 * ["abcd"，"dbqca"]不是一个有效的单词链，因为字母的顺序被改变了。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 16
 * words[i] 仅由小写英文字母组成。
 *
 * @author simple
 */
public class LongestStringChain {
    public int longestStrChain(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(words, Comparator.comparing(String::length)); // 按长度排序
        int ans = 0;
        for (var word : words) {
            int cnt = 0;
            for (int i = 0; i < word.length(); i++) {
                String pre = word.substring(0, i) + word.substring(i + 1);
                cnt = Math.max(cnt, map.getOrDefault(pre, 0) + 1); // 链长最大值
            }
            map.put(word, cnt);
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LongestStringChain().longestStrChain(new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"})); // 5
        System.out.println(new LongestStringChain().longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"})); // 4
        System.out.println(new LongestStringChain().longestStrChain(new String[]{"abcd", "dbqca"})); // 1
    }
}
