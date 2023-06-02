package middle.array;

import java.util.Arrays;
import java.util.Set;

/**
 * 2559. 统计范围内的元音字符串数
 * 给你一个下标从 0 开始的字符串数组 words 以及一个二维整数数组 queries 。
 * <p>
 * 每个查询 queries[i] = [li, ri] 会要求我们统计在 words 中下标在 li 到 ri 范围内（包含 这两个值）并且以元音开头和结尾的字符串的数目。
 * <p>
 * 返回一个整数数组，其中数组的第 i 个元素对应第 i 个查询的答案。
 * <p>
 * 注意：元音字母是 'a'、'e'、'i'、'o' 和 'u' 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
 * 输出：[2,3,0]
 * 解释：以元音开头和结尾的字符串是 "aba"、"ece"、"aa" 和 "e" 。
 * 查询 [0,2] 结果为 2（字符串 "aba" 和 "ece"）。
 * 查询 [1,4] 结果为 3（字符串 "ece"、"aa"、"e"）。
 * 查询 [1,1] 结果为 0 。
 * 返回结果 [2,3,0] 。
 * 示例 2：
 * <p>
 * 输入：words = ["a","e","i"], queries = [[0,2],[0,1],[2,2]]
 * 输出：[3,2,1]
 * 解释：每个字符串都满足这一条件，所以返回 [3,2,1] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 10^5
 * 1 <= words[i].length <= 40
 * words[i] 仅由小写英文字母组成
 * sum(words[i].length) <= 3 * 10^5
 * 1 <= queries.length <= 10^5
 * 0 <= queries[j][0] <= queries[j][1] < words.length
 *
 * @author simple
 */
public class CountVowelStringsInRanges {
    Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] sum = new int[words.length + 1];
        for (int i = 1; i < words.length + 1; i++) {
            sum[i] += sum[i - 1] + (isVowel(words[i - 1]) ? 1 : 0);
        }

        int[] ans = new int[queries.length];
        int k = 0;
        for (var query : queries) {
            var start = query[0];
            var end = query[1];
            ans[k++] = sum[end + 1] - sum[start];
        }

        return ans;
    }

    private boolean isVowel(String word) {
        return set.contains(word.charAt(0)) && set.contains(word.charAt(word.length() - 1));
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountVowelStringsInRanges().vowelStrings(new String[]{"aba","bcb","ece","aa","e"}, new int[][]{{0,2},{1,4},{1,1}})));
    }
}
