package easy.string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 1177. 构建回文串检测
 * 给你一个字符串 s，请你对 s 的子串进行检测。
 * <p>
 * 每次检测，待检子串都可以表示为 queries[i] = [left, right, k]。我们可以 重新排列 子串 s[left], ..., s[right]，并从中选择 最多 k 项替换成任何小写英文字母。
 * <p>
 * 如果在上述检测过程中，子串可以变成回文形式的字符串，那么检测结果为 true，否则结果为 false。
 * <p>
 * 返回答案数组 answer[]，其中 answer[i] 是第 i 个待检子串 queries[i] 的检测结果。
 * <p>
 * 注意：在替换时，子串中的每个字母都必须作为 独立的 项进行计数，也就是说，如果 s[left..right] = "aaa" 且 k = 2，我们只能替换其中的两个字母。
 * （另外，任何检测都不会修改原始字符串 s，可以认为每次检测都是独立的）
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
 * 输出：[true,false,false,true,true]
 * 解释：
 * queries[0] : 子串 = "d"，回文。
 * queries[1] : 子串 = "bc"，不是回文。
 * queries[2] : 子串 = "abcd"，只替换 1 个字符是变不成回文串的。
 * queries[3] : 子串 = "abcd"，可以变成回文的 "abba"。 也可以变成 "baab"，先重新排序变成 "bacd"，然后把 "cd" 替换为 "ab"。
 * queries[4] : 子串 = "abcda"，可以变成回文的 "abcba"。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, queries.length <= 10^5
 * 0 <= queries[i][0] <= queries[i][1] < s.length
 * 0 <= queries[i][2] <= s.length
 * s 中只有小写英文字母
 *
 * @author simple
 */
public class CanMakePalindromeFromSubstring {

    // 由于字母只有26位， 可以利用异或前缀和表达，前i个字母中不同字符出现的次数
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        int[] cnt = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            cnt[i] = cnt[i - 1] ^ (1 << (s.charAt(i - 1) - 'a')); // int 32位， 用26位表达前面未重复的字符
        }

        List<Boolean> ans = new LinkedList<>();
        for (int[] query : queries) {
            ans.add(Integer.bitCount(cnt[query[1] + 1] ^ cnt[query[0]]) <= 2 * query[2] + 1);
        }

        return ans;
    }


    // 超时
    public List<Boolean> canMakePaliQueries2(String s, int[][] queries) {
        List<Boolean> ans = new LinkedList<>();
        for (int[] query : queries) {
            ans.add(f(s, query[0], query[1], query[2]));
        }
        return ans;
    }

    // 对于区间 [i..j], 可以重排序所有字符串
    private Boolean f(String s, int i, int j, int k) {
        Set<Character> chs = new HashSet<>();
        for (int l = i; l <= j; l++) {
            if (!chs.add(s.charAt(l))) {
                chs.remove(s.charAt(l));
            }
        }
        return chs.size() <= k * 2 + 1;
    }

    public static void main(String[] args) {
//        System.out.println(new CanMakePalindromeFromSubstring().f("hunu", 0, 3, 1));
        System.out.println(new CanMakePalindromeFromSubstring().canMakePaliQueries("abcda", new int[][]{{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}}));
    }
}
