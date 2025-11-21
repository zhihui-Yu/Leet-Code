package middle;

/**
 * 1930. 长度为 3 的不同回文子序列
 * 给你一个字符串 s ，返回 s 中 长度为 3 的不同回文子序列 的个数。
 * <p>
 * 即便存在多种方法来构建相同的子序列，但相同的子序列只计数一次。
 * <p>
 * 回文 是正着读和反着读一样的字符串。
 * <p>
 * 子序列 是由原字符串删除其中部分字符（也可以不删除）且不改变剩余字符之间相对顺序形成的一个新字符串。
 * <p>
 * 例如，"ace" 是 "abcde" 的一个子序列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aabca"
 * 输出：3
 * 解释：长度为 3 的 3 个回文子序列分别是：
 * - "aba" ("aabca" 的子序列)
 * - "aaa" ("aabca" 的子序列)
 * - "aca" ("aabca" 的子序列)
 * 示例 2：
 * <p>
 * 输入：s = "adc"
 * 输出：0
 * 解释："adc" 不存在长度为 3 的回文子序列。
 * 示例 3：
 * <p>
 * 输入：s = "bbcbaba"
 * 输出：4
 * 解释：长度为 3 的 4 个回文子序列分别是：
 * - "bbb" ("bbcbaba" 的子序列)
 * - "bcb" ("bbcbaba" 的子序列)
 * - "bab" ("bbcbaba" 的子序列)
 * - "aba" ("bbcbaba" 的子序列)
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= s.length <= 105
 * s 仅由小写英文字母组成
 *
 * @author simple
 */
public class UniqueLength3PalindromicSubsequences {
    public int countPalindromicSubsequence(String s) {
        int ans = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            int idx = s.indexOf(i);
            if (idx == -1) continue;

            // 计算第一个字母和第三个字母中间有多个不一样的字母
            int p3 = s.lastIndexOf(i);
            boolean[] exist = new boolean[26];
            for (int j = idx + 1; j < p3; j++) {
                int k = s.charAt(j) - 'a';
                if (!exist[k]) {
                    ans++;
                    exist[k] = true;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new UniqueLength3PalindromicSubsequences().countPalindromicSubsequence("bbcbaba"));
        System.out.println(new UniqueLength3PalindromicSubsequences().countPalindromicSubsequence("adc"));
        System.out.println(new UniqueLength3PalindromicSubsequences().countPalindromicSubsequence("aabca"));
    }
}
