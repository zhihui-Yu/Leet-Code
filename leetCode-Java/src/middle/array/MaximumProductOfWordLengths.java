package middle.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 318. 最大单词长度乘积
 * 给你一个字符串数组 words ，找出并返回 length(words[i]) * length(words[j]) 的最大值，并且这两个单词不含有公共字母。如果不存在这样的两个单词，返回 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出：16
 * 解释：这两个单词为 "abcw", "xtfn"。
 * 示例 2：
 * <p>
 * 输入：words = ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出：4
 * 解释：这两个单词为 "ab", "cd"。
 * 示例 3：
 * <p>
 * 输入：words = ["a","aa","aaa","aaaa"]
 * 输出：0
 * 解释：不存在这样的两个单词。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] 仅包含小写字母
 *
 * @author simple
 */
public class MaximumProductOfWordLengths {
    // 优化： 26 < 32, 可以使用一个字节的位代表该字母，节约空间
    public int maxProduct(String[] words) {
        Arrays.sort(words, Comparator.comparing(String::length).reversed());
        int len = words.length;
        int[][] w = new int[len][26];
        for (int x = 0; x < len; x++) {
            for (var ch : words[x].toCharArray()) {
                w[x][ch - 'a']++;
            }
        }

        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                String w1 = words[i];
                String w2 = words[j];
                max = Math.max(max, calc(w, i, w1, j, w2));
            }
        }
        return max;
    }

    private int calc(int[][] w, int i, String w1, int j, String w2) {
        for (var ch : w1.toCharArray()) {
            if (w[j][ch - 'a'] != 0) return 0;
        }
        return w1.length() * w2.length();
    }

    public static void main(String[] args) {
        System.out.println(new MaximumProductOfWordLengths().maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
        System.out.println(new MaximumProductOfWordLengths().maxProduct(new String[]{"a","ab","abc","d","cd","bcd","abcd"}));
        System.out.println(new MaximumProductOfWordLengths().maxProduct(new String[]{"a","aa","aaa","aaaa"}));
    }
}
