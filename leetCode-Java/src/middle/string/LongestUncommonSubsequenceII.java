package middle.string;

/**
 * 522. 最长特殊序列 II
 * 给定字符串列表 strs ，返回其中 最长的特殊序列 的长度。如果最长特殊序列不存在，返回 -1 。
 * <p>
 * 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。
 * <p>
 * s 的 子序列可以通过删去字符串 s 中的某些字符实现。
 * <p>
 * 例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。"aebdc"的子序列还包括"aebdc"、 "aeb" 和 "" (空字符串)。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: strs = ["aba","cdc","eae"]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: strs = ["aaa","aaa","aa"]
 * 输出: -1
 * <p>
 * <p>
 * 提示:
 * <p>
 * 2 <= strs.length <= 50
 * 1 <= strs[i].length <= 10
 * strs[i] 只包含小写英文字母
 *
 * @author simple
 */
public class LongestUncommonSubsequenceII {
    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            boolean checked = true;
            for (int j = 0; j < n; j++) {
                if (i != j && isSubseq(strs[i], strs[j])) {
                    checked = false;
                    break; // 只要有一个，就不成立
                }
            }
            if (checked) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }

    // str1 是不是 str2 的子串
    private boolean isSubseq(String str1, String str2) {
        int p = 0, q = 0;
        while (p < str1.length() && q < str2.length()) {
            if (str1.charAt(p) == str2.charAt(q)) {
                p++;
            }
            q++;
        }
        return p == str1.length();
    }

    public static void main(String[] args) {
        System.out.println(new LongestUncommonSubsequenceII().findLUSlength(new String[]{"aaa", "aaa", "aa"}));
    }
}
