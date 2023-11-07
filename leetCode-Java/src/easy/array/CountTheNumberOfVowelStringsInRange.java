package easy.array;

import java.util.Set;

/**
 * 2586. 统计范围内的元音字符串数
 * 给你一个下标从 0 开始的字符串数组 words 和两个整数：left 和 right 。
 * <p>
 * 如果字符串以元音字母开头并以元音字母结尾，那么该字符串就是一个 元音字符串 ，其中元音字母是 'a'、'e'、'i'、'o'、'u' 。
 * <p>
 * 返回 words[i] 是元音字符串的数目，其中 i 在闭区间 [left, right] 内。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["are","amy","u"], left = 0, right = 2
 * 输出：2
 * 解释：
 * - "are" 是一个元音字符串，因为它以 'a' 开头并以 'e' 结尾。
 * - "amy" 不是元音字符串，因为它没有以元音字母结尾。
 * - "u" 是一个元音字符串，因为它以 'u' 开头并以 'u' 结尾。
 * 在上述范围中的元音字符串数目为 2 。
 * 示例 2：
 * <p>
 * 输入：words = ["hey","aeo","mu","ooo","artro"], left = 1, right = 4
 * 输出：3
 * 解释：
 * - "aeo" 是一个元音字符串，因为它以 'a' 开头并以 'o' 结尾。
 * - "mu" 不是元音字符串，因为它没有以元音字母开头。
 * - "ooo" 是一个元音字符串，因为它以 'o' 开头并以 'o' 结尾。
 * - "artro" 是一个元音字符串，因为它以 'a' 开头并以 'o' 结尾。
 * 在上述范围中的元音字符串数目为 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 10
 * words[i] 仅由小写英文字母组成
 * 0 <= left <= right < words.length
 *
 * @author simple
 */
public class CountTheNumberOfVowelStringsInRange {
    public int vowelStrings(String[] words, int left, int right) {
        var vowel = Set.of('a', 'e', 'i', 'o', 'u');
        int cnt = 0;
        for (int i = left; i <= right; i++) {
            if (vowel.contains(words[i].charAt(0)) && vowel.contains(words[i].charAt(words[i].length() - 1))) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new CountTheNumberOfVowelStringsInRange().vowelStrings(new String[]{"are", "amy", "u"}, 0, 2));
        System.out.println(new CountTheNumberOfVowelStringsInRange().vowelStrings(new String[]{"hey","aeo","mu","ooo","artro"}, 1, 4));
    }
}
