package middle.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2981. 找出出现至少三次的最长特殊子字符串 I
 * 给你一个仅由小写英文字母组成的字符串 s 。
 * <p>
 * 如果一个字符串仅由单一字符组成，那么它被称为 特殊 字符串。例如，字符串 "abc" 不是特殊字符串，而字符串 "ddd"、"zz" 和 "f" 是特殊字符串。
 * <p>
 * 返回在 s 中出现 至少三次 的 最长特殊子字符串 的长度，如果不存在出现至少三次的特殊子字符串，则返回 -1 。
 * <p>
 * 子字符串 是字符串中的一个连续 非空 字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aaaa"
 * 输出：2
 * 解释：出现三次的最长特殊子字符串是 "aa" ：子字符串 "aaaa"、"aaaa" 和 "aaaa"。
 * 可以证明最大长度是 2 。
 * 示例 2：
 * <p>
 * 输入：s = "abcdef"
 * 输出：-1
 * 解释：不存在出现至少三次的特殊子字符串。因此返回 -1 。
 * 示例 3：
 * <p>
 * 输入：s = "abcaba"
 * 输出：1
 * 解释：出现三次的最长特殊子字符串是 "a" ：子字符串 "abcaba"、"abcaba" 和 "abcaba"。
 * 可以证明最大长度是 1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= s.length <= 50
 * s 仅由小写英文字母组成。
 *
 * @author simple
 */
public class FindLongestSpecialSubstringThatOccursThriceI {
    /**
     * 分组讨论
     * - 从最长字符L1中选， 即 L1-2 为答案
     * - 从次长L2中选择，  即 min(L1-1,L2) : if L1 = L2 then L1-1  else L1>L2 then L2
     * - 从第三长L3中选，  即 L3
     * <p>
     * 所以最终答案就是： 相同特殊字符的最长三个子串中选择最大的结果， 即 max(L1-2, min(L1-1,L2), L3)
     */
    public int maximumLength(String s) {
        List<Integer>[] groups = new ArrayList[26];
        Arrays.setAll(groups, x -> new ArrayList<>());

        char[] chs = s.toCharArray();
        int n = s.length();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt++;
            // 如果是最后一位，或者相邻字符不相同
            if (i == n - 1 || chs[i] != chs[i + 1]) {
                // 将一段字符的最长特殊子串长度放入数组
                groups[chs[i] - 'a'].add(cnt);
                cnt = 0;
            }
        }

        int ans = 0;
        for (List<Integer> group : groups) {
            if (group.isEmpty()) continue;
            group.sort((o1, o2) -> o2 - o1);
            // 以防group size = 1
            group.add(0);
            group.add(0);
            ans = Math.max(ans, Math.max(group.get(0) - 2, Math.max(group.get(2), Math.min(group.get(0) - 1, group.get(1)))));
        }

        return ans > 0 ? ans : -1;
    }

    public static void main(String[] args) {
        System.out.println(new FindLongestSpecialSubstringThatOccursThriceI().maximumLength("aaaa"));
        System.out.println(new FindLongestSpecialSubstringThatOccursThriceI().maximumLength("abcaba"));
    }
}
