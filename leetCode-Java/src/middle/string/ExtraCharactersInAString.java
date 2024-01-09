package middle.string;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 2707. 字符串中的额外字符
 * 给你一个下标从 0 开始的字符串 s 和一个单词字典 dictionary 。你需要将 s 分割成若干个 互不重叠 的子字符串，
 * 每个子字符串都在 dictionary 中出现过。s 中可能会有一些 额外的字符 不在任何子字符串中。
 * <p>
 * 请你采取最优策略分割 s ，使剩下的字符 最少 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "leetscode", dictionary = ["leet","code","leetcode"]
 * 输出：1
 * 解释：将 s 分成两个子字符串：下标从 0 到 3 的 "leet" 和下标从 5 到 8 的 "code" 。只有 1 个字符没有使用（下标为 4），所以我们返回 1 。
 * 示例 2：
 * <p>
 * 输入：s = "sayhelloworld", dictionary = ["hello","world"]
 * 输出：3
 * 解释：将 s 分成两个子字符串：下标从 3 到 7 的 "hello" 和下标从 8 到 12 的 "world" 。下标为 0 ，1 和 2 的字符没有使用，所以我们返回 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 50
 * 1 <= dictionary.length <= 50
 * 1 <= dictionary[i].length <= 50
 * dictionary[i] 和 s 只包含小写英文字母。
 * dictionary 中的单词互不相同。
 *
 * @author simple
 */
public class ExtraCharactersInAString {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> dict = new HashSet<>();
        Collections.addAll(dict, dictionary);

        int len = s.length();
        // 定义 dp[i] 为 s 前缀 s[0...i−1] 的子问题
        int[] dp = new int[len + 1];
        dp[0] = 0;
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i - 1] + 1; // 默认当前的字符是无用的
            // 计算 dp[i] 的最小值
            for (int j = i - 1; j >= 0; j--) {
                // 将问题变为： [0...j...i] 的符，最小有几个无用
                if (dict.contains(s.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        System.out.println(new ExtraCharactersInAString().minExtraChar("leetscode",new String[]{"leet","code","leetcode"}));
        System.out.println(new ExtraCharactersInAString().minExtraChar("sayhelloworld",new String[]{"hello","world"}));
    }
}
